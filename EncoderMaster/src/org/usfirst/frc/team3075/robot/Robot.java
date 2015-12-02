
package org.usfirst.frc.team3075.robot;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
    RobotDrive myRobot;
    Joystick stick;
    
    CANTalon t1; 
    CANTalon t2;

    
    
    
    public static final int kExponantial = 1012*739;
    public static final double driveDistancePerPulseRight = kExponantial/1012;
	public static final double driveDistancePerPulseLeft = kExponantial/739;
    Encoder[] encoders = 
    	{
    		new Encoder(0, 1, true, Encoder.EncodingType.k4X),
    		new Encoder(2, 3, false, Encoder.EncodingType.k4X)
    	};


    double[] maxs = new double[encoders.length];
    
    public Robot() {
        myRobot = new RobotDrive(0, 3, 2, 1);
        myRobot.setExpiration(0.1);
        stick = new Joystick(0);
        

        encoders[0].setDistancePerPulse(driveDistancePerPulseLeft);
        encoders[1].setDistancePerPulse(driveDistancePerPulseRight);
        encoders[0].reset();
        encoders[1].reset();
        
        t1 = new CANTalon(1);
        t2 = new CANTalon(0);
       

    }

    /**
     * Drive left & right motors for 2 seconds then stop
     */
    public void autonomous() {
//        myRobot.setSafetyEnabled(false);
//        myRobot.drive(-0.5, 0.0);	// drive forwards half speed
//        Timer.delay(2.0);		//    for 2 seconds
//        myRobot.drive(0.0, 0.0);	// stop robot
    }

    /**
     * Runs the motors with arcade steering.
     */
    public void operatorControl() {
    	
        myRobot.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
        	maxSpeeds();
        	for(int i = 0; i < encoders.length; i++)
        	{
        		SmartDashboard.putNumber("Encoder " + i + " rate", encoders[i].getRate()/kExponantial);
        		SmartDashboard.putNumber("Encoder " + i + " distance", encoders[i].getDistance()/kExponantial);
        		SmartDashboard.putNumber("Encoder " + i + " max speed", maxs[i]);
//        		encoders[i].setDistancePerPulse(SmartDashboard.getNumber("Encoder " + i + " DisPerPul"));
        	}
        	
        	SmartDashboard.putNumber("Talon 0", t1.getSpeed());
        	SmartDashboard.putNumber("Talon 1", t2.getSpeed());

        	
        	
            myRobot.arcadeDrive(-stick.getY(), stick.getX()); // drive with arcade style (use right stick)
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
    
    public void maxSpeeds()
    {
    	for(int i = 0; i < encoders.length; i++)
    	{
    		if(maxs != null && encoders[i].getRate() > maxs[i])
    			maxs[i] = encoders[i].getRate();
    	}
    }
}
