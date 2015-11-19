package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.OI;
import org.usfirst.frc.team3075.robot.RobotMap;
import org.usfirst.frc.team3075.robot.commands.JoyStickArcadeDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem{
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoyStickArcadeDrive());
	}
	 
	public void arcadeDrive(double y, double x)
	{
		RobotMap.drive.arcadeDrive(x, y);
	}
	
	public double getDistAverage()
	{
		return (getDistLeft() + getDistRight()) / 2;
	}
	
	public double getDistRight()
	{
		return OI.driveRightEncoder.getDistance();
	}
	
	public double getDistLeft()
	{
		return OI.driveLeftEncoder.getDistance();
	}
	
	public double getAngle()
	{
		return getAngleRight() + getAngleLeft();
	}
	
	private double getAngleRight()
	{
		return 1 * OI.driveRightEncoder.getDistance() / RobotMap.robotWidth * 360 / (2 * Math.PI);
	}
	
	private double getAngleLeft()
	{
		return -1 * OI.driveLeftEncoder.getDistance() / RobotMap.robotWidth * 360 / (2 * Math.PI);
	}
}
