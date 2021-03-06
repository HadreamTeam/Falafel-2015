package org.usfirst.frc.team3075.robot;

import org.usfirst.frc.team3075.robot.subsystems.TwoMotorPID;

import libPurple.CANTalon3075;
import libPurple.Solenoid3075;
import libPurple.Victor3075;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;


public class Constants {
	
	//Pneumatic System
	
	//Shooting system
//	public static Victor leftWheel;
//	public static Victor rightWheel;

	//Conveyor system
//	public static Victor conveyorMotor;
	
	
	//Constants
	public static final double autonomusDistancetoLine = 2.50; 
	
	public static final double slotLength = 1148;
	
	public static final double robotWidth = 0.8;
	
	public static final double kpShooter = 10;
	
	public static final double kpTurn = 10;
	
	public static final double kGearUp = 1.5;

	public static double WheelsSpeed = 0.75;
	
	//Drive pid constants
	public static double kpDriveLeft = 5;
	public static double kiDriveLeft = 0;
	public static double kdDriveLeft = 1.4;
	
	public static double kpDriveRight = 5;
	public static double kiDriveRight = 0;
	public static double kdDriveRight = 1.4;
	
	//Control period in milliseconds.
	public static int runPeriod = 20;
	//The maximum speed of the slower side of the drive system.
	public static double maxSpeed = 4;
	
	public static boolean autoGearFinish;
	
	//Encoder measuring values.
	public static int pulsesPerMeterRight = 1012;
	public static int pulsesPerMeterLeft = 739;
	
	//public static double kExponantial = (pulsesPerMeterRight * pulsesPerMeterLeft);
	
	public static double driveDistancePerPulseRight = 2894;
	public static double driveDistancePerPulseLeft = 2882;
	
	public static double testingDistance = 5;
	
	public static boolean runPID = true;

	public static double kAccelimit = 0.3;
	public static double kDeAccelimit = 0.3;


	public static double xFix = 0.75;

	public static double driveMotorBound = 0.3;

	
	public static void init()
	{
//		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
//		
//		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
//		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
////		
//		//Default drive setting
//		drive.setSafetyEnabled(true);
//        drive.setExpiration(0.1);
//        drive.setSensitivity(0.5);
//        drive.setMaxOutput(1.0);
        
        //Initialize shooting system
//        leftWheel = new Victor(5);
//        rightWheel = new Victor(6);
        //Want to be conveyer
//        conveyorMotor = new Victor(4);
        
        autoGearFinish = false;
        
	}
	
}
