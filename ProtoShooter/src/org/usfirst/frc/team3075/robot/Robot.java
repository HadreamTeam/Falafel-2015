
package org.usfirst.frc.team3075.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the RobotDrive class.
 * The SampleRobot class is the base of a robot application that will automatically call your
 * Autonomous and OperatorControl methods at the right time as controlled by the switches on
 * the driver station or the field controls.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're inexperienced,
 * don't. Unless you know what you are doing, complex code will be much more difficult under
 * this system. Use IterativeRobot or Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
   
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    SendableChooser chooser;
    public CANTalon v0;
    public CANTalon v1;
    Preferences pref;
    public Joystick stick;


    public Robot() {
    	
    	v0 = new CANTalon(4);
    	v0.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	v1 = new CANTalon(2);
    	v0.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	pref = pref.getInstance();
    	stick = new Joystick(0);
    }
    
    public void robotInit() {
 
    	
    }

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the if-else structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomous() {
    	
//    	String autoSelected = (String) chooser.getSelected();
////		String autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
//		System.out.println("Auto selected: " + autoSelected);
//    	
//    	switch(autoSelected) {
//    	case customAuto:
//            myRobot.setSafetyEnabled(false);
//            myRobot.drive(-0.5, 1.0);	// spin at half speed
//            Timer.delay(2.0);		//    for 2 seconds
//            myRobot.drive(0.0, 0.0);	// stop robot
//            break;
//    	case defaultAuto:
//    	default:
//            myRobot.setSafetyEnabled(false);
//            myRobot.drive(-0.5, 0.0);	// drive forwards half speed
//            Timer.delay(2.0);		//    for 2 seconds
//            myRobot.drive(0.0, 0.0);	// stop robot
//            break;
//    	}
    }

    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
        	
//        	v0.set(pref.getDouble("0", 0));
//        	v1.set(pref.getDouble("1", 0));
        	if(stick.getRawButton(1))
        	{
        		v0.set(-0.65);
        		v1.set(0.65);
        	}
        	
        	else if(stick.getRawButton(2))
        	{
        		v0.set(-0.55);
        		v1.set(0);
        	}
        	
        	else if(stick.getRawButton(3))
        	{
        		v0.set(-0.4);
        		v1.set(0.4);
        	}
        	
        	else if(stick.getRawButton(4))
        	{
        		v0.set(-0.5);
        		v1.set(0.5);
        	}
        	
        	else if(stick.getRawButton(5))
        	{
        		v0.set(-0.6);
        		v1.set(0.6);
        	}
        	
        	else if(stick.getRawButton(6))
        	{
        		v0.set(-0.7);
        		v1.set(0.7);
        	}
        	
        	else if(stick.getRawButton(7))
        	{
        		v0.set(-0.8);
        		v1.set(0.8);
        	}
        	
        	else if(stick.getRawButton(8))
        	{
        		v0.set(-0.9);
        		v1.set(0.9);
        	}
        	
        	else if(stick.getRawButton(9))
        	{
        		v0.set(-1);
        		v1.set(1);
        	}
        	
        	else if(stick.getRawButton(10))
        	{
        		v0.set(-1);
        		v1.set(1);
        	}
        	
        	else if(stick.getRawButton(11))
        	{
        		v0.set(-1);
        		v1.set(1);
        	}
        	
        	else if(stick.getRawButton(12))
        	{
        		v0.set(-1);
        		v1.set(1);
        	}
        	
        	else
        	{
        		v0.set(0);
        		v1.set(0);
        	}

        	
        	
        	Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
}
