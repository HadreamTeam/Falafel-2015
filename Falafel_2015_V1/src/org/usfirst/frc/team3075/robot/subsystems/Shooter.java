package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.OI;
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
    public void setWheelsSpeed(double speed)
    {
    	RobotMap.leftWheel.set(speed); //This motor is inverted
    	RobotMap.rightWheel.set(-speed);
    }
    
    public void setLeftSpeed(double speed)
    {
    	RobotMap.leftWheel.set(speed);
    }
    
    public void setRightSpeed(double speed)
    {
    	RobotMap.rightWheel.set(-speed);
    }
    
    public double getRightRate()
    {
    	return OI.shooterRightEncoder.getRate();
    }
    public double getLeftRate()
    {
    	return OI.shooterLeftEncoder.getRate();
    }
//    public void suckIt()
//    {
//    	new Robot.dick = small;
//    	new Duani = 0;
//    	execute Duani.mouth.activate(Suck);
//    }
}