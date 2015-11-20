package org.usfirst.frc.team3075.robot.commands;

import libPurple.utils;

import org.usfirst.frc.team3075.robot.Robot;
import org.usfirst.frc.team3075.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	private double dist = 0;
	private double initialDist = 0;
	private final double minDiff = 0.1;
    public DriveDistance(double distance) {
        // Use requires() here to declare subsystem dependencies
    	dist = distance;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialDist = Robot.drive.getDistAverage();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.arcadeDrive((1 / RobotMap.kpDrive) * (dist - (Robot.drive.getDistAverage() - initialDist)), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return utils.inRange(dist, Robot.drive.getDistAverage(), minDiff);
    }

    // Called once after isFinished returns true
    protected void end() {
    	// So the robot will stop moving.
    	Robot.drive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
