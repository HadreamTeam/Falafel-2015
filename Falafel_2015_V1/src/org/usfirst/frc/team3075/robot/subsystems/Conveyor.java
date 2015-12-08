package org.usfirst.frc.team3075.robot.subsystems;

import libPurple.CANTalon3075;
import libPurple.utils;

import org.usfirst.frc.team3075.robot.Components;
import org.usfirst.frc.team3075.robot.commands.ManualConveyor;
import org.usfirst.frc.team3075.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Conveyor extends Subsystem {
	
	
    public Conveyor() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualConveyor());
    }
    
    public void setSpeed(double speed)
    {
    	Components.conveyorMotor.set(-speed);
    }
    
   
    
}





