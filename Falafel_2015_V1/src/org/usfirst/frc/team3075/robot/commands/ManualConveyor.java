package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualConveyor extends Command {

		
	    public ManualConveyor() {
	        // Use requires() here to declare subsystem dependencies
	        requires(Robot.conveyor);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize()
	    {
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() 
	    {
	    	Robot.conveyor.setSpeed(Components.systemStick.yGet());
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    	// Should stop the conveyor if you press the toggle button
	    	// while you move the conveyor
	    	Robot.conveyor.setSpeed(0);
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
	}
