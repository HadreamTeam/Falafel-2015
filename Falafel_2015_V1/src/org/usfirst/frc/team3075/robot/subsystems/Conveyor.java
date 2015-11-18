package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.OI;
import org.usfirst.frc.team3075.robot.RobotMap;
import org.usfirst.frc.team3075.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Conveyor extends Subsystem
	{
	    
	    // Put methods for controlling this subsystem
	    // here. Call these from Commands.

	    public void initDefaultCommand() 
	    {
	        // Set the default command for a subsystem here.
	        setDefaultCommand(new Wait());
	    }
	    
	    
	    //Control the motors speed
	    public void setSpeed(double x)
	    {
	    	RobotMap.conveyorMotor.set(x);
	    }
	    public double rotationCheck()
	    {
	    	return OI.conveyorEncoder.getDistance();
	    }

	}
