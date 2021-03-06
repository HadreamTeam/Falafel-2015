package org.usfirst.frc.team3075.robot.commands;

import libPurple.utils;

import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnAngle extends Command {
	
	private double angle = 0;
	private double initialAngle = 0;
	private double minDiff = 0.1;
	
    public TurnAngle(double turningAngle) {
        // Use requires() here to declare subsystem dependencies
    	angle = turningAngle;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialAngle = Robot.drive.getAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.arcadeDrive(0, ( 1 / Constants.kpTurn) * (angle - (initialAngle - Robot.drive.getAngle())));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return utils.inRange(angle, initialAngle - Robot.drive.getAngle(), minDiff);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
