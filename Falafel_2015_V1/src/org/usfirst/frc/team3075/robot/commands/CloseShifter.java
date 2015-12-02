package org.usfirst.frc.team3075.robot.commands;

import java.awt.Component;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseShifter extends Command {

	DoubleSolenoid shifter0;
	
    public CloseShifter() {
//    	shifter0 = OI.shifter;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   	Constants.autoGearFinish = true;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	shifter0.set(DoubleSolenoid.Value.kReverse);
    	Components.shifter.set(DoubleSolenoid.Value.kReverse);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
