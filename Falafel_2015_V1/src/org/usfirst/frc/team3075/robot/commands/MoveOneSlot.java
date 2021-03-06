package org.usfirst.frc.team3075.robot.commands;

import libPurple.utils;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class MoveOneSlot extends Command {
	
	double startPos;
    public MoveOneSlot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	startPos = Components.conveyorMotor.getPosition();
    	setTimeout(5);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Proportional motor speeds
    	Robot.conveyor.setSpeed(1);
    	//Components.conveyorMotor.setPosition(startPos + Constants.slotLength);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return isTimedOut() || utils.inRange(Components.conveyorMotor.getPosition(), startPos + Constants.slotLength, 100);

    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyor.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
