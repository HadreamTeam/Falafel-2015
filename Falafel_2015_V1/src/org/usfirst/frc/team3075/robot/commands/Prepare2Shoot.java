package org.usfirst.frc.team3075.robot.commands;

import java.awt.Component;

import libPurple.utils;

import org.usfirst.frc.team3075.robot.Robot;
import org.usfirst.frc.team3075.robot.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Prepare2Shoot extends Command {
	
	
	
    private double speed;

	public Prepare2Shoot(double speed) {
        // Use requires() here to declare subsystem dependencies
         requires(Robot.shooter);
         this.speed = speed;
         
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	setTimeout(5.0);
    }

    // Called repeatedly when this Command is scheduled to run
    
    protected void execute() 
    {
    	Robot.shooter.setWheelsSpeed(speed);
    	
    	
    	
    	SmartDashboard.putNumber("Time 2 Shoot", timeSinceInitialized());
    	SmartDashboard.putBoolean("Ready to Shoot", isTimedOut());
    	    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	return false;
    	
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	SmartDashboard.putNumber("Time 2 Shoot", 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
