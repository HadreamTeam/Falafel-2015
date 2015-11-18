package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.OI;
import org.usfirst.frc.team3075.robot.Robot;
import org.usfirst.frc.team3075.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


public class MoveOneSlot extends Command {
	private double initialValue;
	private double distance;

    public MoveOneSlot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conveyor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialValue = OI.conveyorEncoder.getDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//Proportional motor speed
    	distance = Robot.conveyor.rotationCheck() - initialValue;
    	Robot.conveyor.setSpeed((RobotMap.slotLength - distance) / RobotMap.kpConveyor);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return distance >= RobotMap.slotLength;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
