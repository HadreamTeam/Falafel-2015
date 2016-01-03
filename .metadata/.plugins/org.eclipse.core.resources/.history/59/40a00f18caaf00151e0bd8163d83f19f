package org.usfirst.frc.team3075.robot.subsystems;

import libPurple.CANTalon3075;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.commands.ManualShooter;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem
{

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Shooter() {
		// TODO Auto-generated constructor stub
    
	}

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualShooter());
    }
    
    //Control the motors speed
    public void setWheelsSpeed(double speed)
    {
    	Components.leftWheel.set(speed); //This motor is inverted
    	Components.rightWheel.set(speed);
    }
    
    public void setLeftSpeed(double speed)
    {
    	Components.leftWheel.set(speed);
    }
    
    public void setRightSpeed(double speed)
    {
    	Components.rightWheel.set(speed);
    }
}