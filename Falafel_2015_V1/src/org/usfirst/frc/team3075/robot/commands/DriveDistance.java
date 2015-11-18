package org.usfirst.frc.team3075.robot.commands;

import libPurple.utils;

import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	private double dist = 0;
	private final double minDiff = 0.1;
    public DriveDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
    	dist = distance;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.arcadeDrive(1, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return utils.inRange(dist, Robot.drive.getDistTotal(), minDiff);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
