package org.usfirst.frc.team3075.robot;

import org.usfirst.frc.team3075.robot.subsystems.Cannon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static Talon rearRight = new Talon(3);
	public static Talon middleRight = new Talon(4);
	public static Talon frontRight = new Talon(5);
	
	public static Talon rearLeft = new Talon(8);
	public static Talon middleLeft = new Talon(7);
	public static Talon frontLeft = new Talon(6);
	
	public static Talon cannonUpper = new Talon(6);
	public static Talon cannonLower = new Talon(7);
	
	public static RobotDrive arcadeDrive = new RobotDrive(RobotMap.rearLeft, RobotMap.frontLeft, RobotMap.rearRight,RobotMap.frontRight);

	public static DoubleSolenoid cannonPush = new DoubleSolenoid(0, 1);
 }
