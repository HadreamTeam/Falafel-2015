package org.usfirst.frc.team3075.robot.commands;
import libPurple.utils;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;


public class JoyStickArcadeDrive extends Command {
	
	double valueX;
	double valueY;
	double lastValueX;
	double lastValueY;
	
	public JoyStickArcadeDrive() {
		
		requires(Robot.drive);
	}
	
	@Override
	protected void initialize() {
		
		lastValueX = 0;
	    lastValueY = 0;
	     
		Components.driveLeft.enable();
		Components.driveRight.enable();

		
	}

	@Override
	protected void execute() {
		
		valueX = Components.driveStick.axisGet(0) * 0.5;
//		valueX = utils.accellimit(valueX, lastValueX, Constants.kAccelimit);
		
		valueY = Components.driveStick.axisGet(1) * 0.5;
//		valueY = utils.accellimit(valueY, lastValueY, Constants.kAccelimit);
		
		Robot.drive.arcadeDrive(-valueY, valueX);
		
		lastValueX = valueX;
		lastValueY = valueY;
	
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
