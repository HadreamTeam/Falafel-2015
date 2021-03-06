package org.usfirst.frc.team3075.robot.subsystems;

import libPurple.utils;

import org.omg.CORBA.NO_IMPLEMENT;
import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;
import org.usfirst.frc.team3075.robot.commands.JoyStickArcadeDrive;
import org.usfirst.frc.team3075.robot.commands.NoPidArcadeDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveSystem extends Subsystem{
	
	private boolean	runPID = true;
	private double turnSensitivity = 0.3;
	
	public DriveSystem() {
		// TODO Auto-generated constructor stub
		//Initialize driving motors

	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new NoPidArcadeDrive());
	}
	
	public void rawArcadeDrive(double y, double x)
	{
		
		Components.driveLeft.disable();
		Components.driveRight.disable();
		
		double[] arr = utils.arcadeDrive(y, x);
		
		SmartDashboard.putNumber("left value raw", arr[0]);
		SmartDashboard.putNumber("right value raw", arr[1]);
		
		
		
		Components.robotDrive.tankDrive(arr[0], arr[1]);
		
	}
	
	public void arcadeDrive(double y, double x)
	{
		// arr[0] = left
		double[] driveValues = utils.arcadeDrive(y, x, turnSensitivity);
//		if(runPID)
//		{
			

			Components.driveLeft.setReturnRate(true);
			Components.driveRight.setReturnRate(true);
		
			Components.driveLeft.setAbsoluteTolerance(0.05);
			Components.driveRight.setAbsoluteTolerance(0.05);
			
			SmartDashboard.putNumber("Setpoint r",driveValues[1]*Constants.maxSpeed);
			SmartDashboard.putNumber("Setpoint l",driveValues[0]*Constants.maxSpeed);

			
			Components.driveLeft.setSetpoint(driveValues[0]*Constants.maxSpeed);
			Components.driveRight.setSetpoint(driveValues[1]*Constants.maxSpeed);
//		}
//		else
//		{
//			Components.driveLeft.setRaw(driveValues[0]);
//			Components.driveRight.setRaw(driveValues[1]);
//		}
	}
	
	public void driveDistance(double targetRight, double targetLeft)
	{
		Components.driveLeft.enable();
		Components.driveRight.enable();

		Components.driveLeft.setReturnRate(false);
		Components.driveRight.setReturnRate(false);
		
		Components.driveLeft.setAbsoluteTolerance(0.02);
		Components.driveRight.setAbsoluteTolerance(0.02);
		
		Components.driveLeft.setSetpoint(targetLeft);
		Components.driveRight.setSetpoint(targetRight);
	}
	
	public void turnAngle(double angle)
	{
		driveDistance(utils.angleDist(angle), -utils.angleDist(angle));
	}
	
	public double getDistAverage()
	{
		return (getDistLeft() + getDistRight()) / 2;
	}
	
	public double getRateAverage()
	{
		return (Components.driveLeftEncoder.getRate() + Components.driveRightEncoder.getRate()) / 2;
	}
	
	public double getDistRight()
	{
		return Components.driveRightEncoder.getDistance();
	}
	
	public double getDistLeft()
	{
		return Components.driveLeftEncoder.getDistance();
	}
	
	public double getAngle()
	{
		return getAngleRight() + getAngleLeft();
	}
	
	private double getAngleRight()
	{
		return 1 * Components.driveRightEncoder.getDistance() / Constants.robotWidth * 360 / (2 * Math.PI);
	}
	
	private double getAngleLeft()
	{
		return -1 * Components.driveLeftEncoder.getDistance() / Constants.robotWidth * 360 / (2 * Math.PI);
	}
	
	public void setRunPID(boolean toRun)
	{
		runPID = toRun;
		if(runPID)
		{
			 Components.driveLeft.enable();
			 Components.driveRight.enable();
		}
		else
		{
			 Components.driveLeft.disable();
			 Components.driveRight.disable();
		}
	}
	
	public void setAccellimit(double newAccellimit)
	{
		Components.driveLeft.setAccellimit(newAccellimit);
		Components.driveRight.setAccellimit(newAccellimit);
	}
	
//	public void setDeAccellimit(double newdeAccellimit)
//	{
//		Components.driveLeft.setDeAccellimit(newdeAccellimit);
//		Components.driveRight.setDeAccellimit(newdeAccellimit);
//	}
	
	public void setMotorBound(double newMotorBound)
	{
		Components.driveLeft.setMotorBound(newMotorBound);
		Components.driveRight.setMotorBound(newMotorBound);
	}
	
	public void setTurningSensitivity(double sensitivity)
	{
		turnSensitivity = sensitivity;
	}
}
