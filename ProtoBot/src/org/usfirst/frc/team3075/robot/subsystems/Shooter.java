package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.RobotMap;
import org.usfirst.frc.team3075.robot.commands.ManualShooter;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem
{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualShooter());
    }
    
    
    //Control the motors speed
    public void setWheelsSpeed(double value)
    {
    	RobotMap.leftWheel.set(value); //This motor is inverted
    	RobotMap.rightWheel.set(-value);
//    	RobotMap.leftWheel.set(value);
    }

}

