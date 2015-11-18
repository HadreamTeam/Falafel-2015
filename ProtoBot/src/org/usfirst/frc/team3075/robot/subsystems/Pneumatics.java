package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.RobotMap;
import org.usfirst.frc.team3075.robot.commands.PneuWait;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new PneuWait());
    }
    
    public void grabberLift()
    {
    	RobotMap.grabber.set(DoubleSolenoid.Value.kForward);
    }
    
    public void grabberRelease()
    {
    	RobotMap.grabber.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void gearUp()
    {
    	RobotMap.shifter.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void gearDown()
    {
    	RobotMap.shifter.set(DoubleSolenoid.Value.kForward);
    }
}

