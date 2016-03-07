package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.RobotMap;
import org.usfirst.frc.team3075.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
//	public DriveSystem() {
//		// TODO Auto-generated constructor stub
//		RobotMap.middleLeft.setInverted(true);
//		RobotMap.middleRight.setInverted(true);
//
//	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArcadeDrive());
    }
    
    public void arcadeDrive(Joystick j)
    {
    	RobotMap.arcadeDrive.arcadeDrive(j);
    }

	
}

