package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.RobotMap;
import org.usfirst.frc.team3075.robot.commands.ManualCannon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cannon extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualCannon());
    }
    
    public void setSpeed(double upper, double lower)
    {
    	RobotMap.cannonUpper.set(upper);
    	RobotMap.cannonLower.set(lower);
    }
    
    public void setSpeed(double speed)
    {
    	setSpeed(speed, speed * -1);
    }
}

