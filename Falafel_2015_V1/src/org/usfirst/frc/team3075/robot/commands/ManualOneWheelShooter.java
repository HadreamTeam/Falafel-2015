//package org.usfirst.frc.team3075.robot.commands;
//
//import org.usfirst.frc.team3075.robot.Components;
//import org.usfirst.frc.team3075.robot.Robot;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class ManualOneWheelShooter extends Command {
//
//
//	
//	double value;
//	
//    public ManualOneWheelShooter() {
//        // Use requires() here to declare subsystem dependencies
//        requires(Robot.shooter);
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize()
//    {
//    	value = 0;
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() 
//    {
//    	value = ((-Components.systemStick.axisGet(2)) + 1) / 2; // change the value from -1 ~ 1 to 0 ~ 1
//    	Robot.shooter.setLeftSpeed(value);
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
//}