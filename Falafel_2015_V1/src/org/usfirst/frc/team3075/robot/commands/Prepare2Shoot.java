package org.usfirst.frc.team3075.robot.commands;

import libPurple.utils;

import org.usfirst.frc.team3075.robot.Robot;
import org.usfirst.frc.team3075.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Prepare2Shoot extends Command {
	private double errorRight;
	private double errorLeft;
	
	
	private final double shootingRate=7200;
	
	private final double diff=20;
	
	private boolean toFinish = true;

    public Prepare2Shoot(boolean finish) {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.shooter);
         
         toFinish = finish;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    
    protected void execute() 
    {
    	errorRight = shootingRate - Robot.shooter.getRightRate(); 
    	errorLeft = shootingRate - Robot.shooter.getLeftRate();
    	Robot.shooter.setRightSpeed(errorRight / RobotMap.kpShooter);
    	Robot.shooter.setLeftSpeed(errorLeft / RobotMap.kpShooter);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return toFinish && utils.inRange(errorRight, 0, diff) && utils.inRange(errorLeft, 0, diff);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
