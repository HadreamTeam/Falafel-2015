package org.usfirst.frc.team3075.robot;

import org.usfirst.frc.team3075.robot.subsystems.TwoMotorPID;

import libPurple.Solenoid3075;
import libPurple.Victor3075;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;


public class RobotMap {
	
	//Drive System
	public static Victor3075 rearLeft;
	public static Victor3075 frontLeft;
	public static Victor3075 rearRight;
	public static Victor3075 frontRight;
//	public static RobotDrive drive;
	public static TwoMotorPID driveLeft;
	public static TwoMotorPID driveRight;
	
	
	//Pneumatic System
	public static Solenoid3075 shifter;
	
	//Shooting system
	public static Victor leftWheel;
	public static Victor rightWheel;

	//Conveyor system
	public static Victor conveyorMotor;
	
	//Constants
	public static final double slotLength = 0.22;
	
	public static final double robotWidth = 0.8;
	
	public static final double correctionDistConveyor = 1;
	public static final double kpConveyor = 1 / correctionDistConveyor;
	public static final double kiConveyor = 0;
	public static final double kdConveyor = 0;
	public static final double conveyorTolerance = 0.01;
	
	public static final double kpShooter = 10;
	
	public static final double kpDriveLeft = 10;
	public static final double kiDriveLeft = 10;
	public static final double kdDriveLeft = 10;
	
	public static final double kpDriveRight = 10;
	public static final double kiDriveRight = 10;
	public static final double kdDriveRight = 10;
	
	public static final double kpTurn = 10;
	
	public static void init()
	{
		//Initialize driving motors
		rearLeft = new Victor3075(1);
		frontLeft = new Victor3075(0);
		rearRight = new Victor3075(2);
		frontRight = new Victor3075(3);
		
		rearLeft.setInverted(true);
		frontLeft.setInverted(true);
		
		driveLeft = new TwoMotorPID(rearLeft, frontLeft, kpDriveLeft, kiDriveLeft, kdDriveLeft);
		driveRight = new TwoMotorPID(rearRight, frontRight, kpDriveRight, kiDriveRight, kdDriveRight);
//		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
//		
//		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
//		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
//		
//		//Default drive setting
//		drive.setSafetyEnabled(true);
//        drive.setExpiration(0.1);
//        drive.setSensitivity(0.5);
//        drive.setMaxOutput(1.0);
        
        //Initialize shooting system
        leftWheel = new Victor(5);
        rightWheel = new Victor(6);
        
        //Want to be conveyer
        conveyorMotor = new Victor(4);
        
        shifter = new Solenoid3075(4,5);
        
        	}
	
}
