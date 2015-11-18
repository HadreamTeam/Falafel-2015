package org.usfirst.frc.team3075.robot.subsystems;

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
	
	public double getDistTotal()
	{
		return 0;
	}
	
	public double getDistRight()
	{
		return 0;
	}
	
	public double getDistLeft()
	{
		return 0;
	}
	
	public double getAngle()
	{
		return 0;
	}
}
