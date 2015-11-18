package org.usfirst.frc.team3075.robot;

import LibPurple.DoubleSolenoid3075;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Victor rearLeft;
	public static Victor frontLeft;
	public static Victor rearRight;
	public static Victor frontRight;
	public static RobotDrive drive;
	
	//Shooting system
	public static Victor leftWheel;
	public static Victor rightWheel;

	//Conveyor system
	public static Victor conveyorMotor;
	
	public static Compressor c;
	
	public static DoubleSolenoid3075 grabber;
	public static DoubleSolenoid3075 shifter;
	public static void init()
		{
			//Initialize driving motors
			rearLeft = new Victor(1);
			frontLeft = new Victor(0);
			rearRight = new Victor(2);
			frontRight = new Victor(3);
			
			drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
			
			drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
			drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
			
			//Default drive setting
			drive.setSafetyEnabled(true);
	        drive.setExpiration(0.1);
	        drive.setSensitivity(0.5);
	        drive.setMaxOutput(1.0);
	        
	        //Initialize shooting system
	        leftWheel = new Victor(5);
	        rightWheel = new Victor(6);
	        
	        //Wannabe conveyer
	        conveyorMotor = new Victor(4);
	        
	        c = new Compressor(0);
	        c.setClosedLoopControl(true);
	        c.start();
	        
	        grabber = new DoubleSolenoid3075(1, 0);

	        shifter = new DoubleSolenoid3075(4, 5);
	        
	        grabber.clearAllPCMStickyFaults();
	        
		}
}
