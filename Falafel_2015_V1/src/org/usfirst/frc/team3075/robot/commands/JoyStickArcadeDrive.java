package org.usfirst.frc.team3075.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Robot;


public class JoyStickArcadeDrive extends Command {
	
	public JoyStickArcadeDrive() {
		
		requires(Robot.drive);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
		Robot.drive.arcadeDrive(Components.driveStick.axisGet(1), Components.driveStick.axisGet(0));
	
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
