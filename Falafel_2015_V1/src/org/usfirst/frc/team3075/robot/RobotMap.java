package org.usfirst.frc.team3075.robot;

import libPurple.Solenoid3075;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;


public class RobotMap {
	
	//Drive System
	public static Victor rearLeft;
	public static Victor frontLeft;
	public static Victor rearRight;
	public static Victor frontRight;
	public static RobotDrive drive;
	
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
	
	public static final double kpConveyor = 1.5;
	
	public static final double kpShooter = 10;
	
	public static final double kpDrive = 10;
	
	public static final double kpTurn = 10;
	
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
        
        //Want to be conveyer
        conveyorMotor = new Victor(4);
        
        shifter = new Solenoid3075(4,5);
        
        	}
	
}
