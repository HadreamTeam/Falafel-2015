package org.usfirst.frc.team3075.robot;

import LibPurple.CANTalon3075;
import LibPurple.DoubleSolenoid3075;
import edu.wpi.first.wpilibj.CANTalon;
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
//	public static CANTalon3075 leftWheel;
//	public static CANTalon3075 rightWheel;
	public static CANTalon leftWheel;
	public static CANTalon rightWheel;

	//Conveyor system
	public static CANTalon3075 conveyorMotor;
	
	public static DoubleSolenoid3075 grabber;
	public static DoubleSolenoid3075 shifter;
	
	//Run period in milliseconds.
	public static final int runPeriod = 20;
	
	public static void init()
		{
			//Initialize driving motors
			rearLeft = new Victor(3);
			frontLeft = new Victor(0);
			rearRight = new Victor(1);
			frontRight = new Victor(2);
			
			drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
			
			drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
			drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
			
			//Default drive setting
			drive.setSafetyEnabled(true);
	        drive.setExpiration(0.1);
	        drive.setSensitivity(0.5);
	        drive.setMaxOutput(1.0);
	        
	        //Initialize shooting system
//	        leftWheel = new CANTalon3075(0);
//	        leftWheel = new CANTalon3075(2);
//	        rightWheel = new CANTalon3075(2, leftWheel, true);
	        leftWheel = new CANTalon(0);
	        rightWheel = new CANTalon(2);
	        
	        //Wannabe conveyer
	        conveyorMotor = new CANTalon3075(1);
	        
	        grabber = new DoubleSolenoid3075(4, 5);

	        shifter = new DoubleSolenoid3075(0, 1);
	        
	        grabber.clearAllPCMStickyFaults();
	        
		}
}
