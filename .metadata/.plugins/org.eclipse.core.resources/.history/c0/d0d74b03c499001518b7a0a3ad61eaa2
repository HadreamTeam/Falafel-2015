package org.usfirst.frc.team3075.robot.commands;

import libPurple.utils;

import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	private double distanceR = 0;
	private double distanceL = 0;
	private double initialDistR = 0;
	private double initialDistL = 0;
	private final double minDiff = 0.1;
    public DriveDistance(double distanceRight, double distanceLeft) {
        // Use requires() here to declare subsystem dependencies
    	distanceR = distanceRight;
    	distanceL = distanceLeft;
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	initialDistR = Robot.drive.getDistRight();
    	initialDistL = Robot.drive.getDistLeft();
    	
    	Robot.drive.driveDistance(initialDistR + distanceR, initialDistL + distanceL);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return utils.inRange(distanceL, Robot.drive.getDistLeft(), minDiff) &&
        	   utils.inRange(distanceR, Robot.drive.getDistRight(), minDiff);
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
