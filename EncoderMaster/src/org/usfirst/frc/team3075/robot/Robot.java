
package org.usfirst.frc.team3075.robot;


import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

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
//    RobotDrive myRobot;
    Joystick stick;
    Joystick stick2;
    
    CANTalon rightFront;
    CANTalon rightRear;
    CANTalon rightMiddle;
    
    CANTalon leftFront;
    CANTalon leftRear;
    CANTalon leftMiddle;
    CANTalon shooterTop;
    CANTalon shooterBottom;
    
    TripleSolenoid triple;
//    Solenoid3075 triple;
    Solenoid3075 littleArms;
    Solenoid3075 ballPusher;
    Solenoid3075 shooterAngle;
    Solenoid3075 shifter;
    Solenoid3075 sol5;
    Solenoid3075 sol6;
    
    JoystickButton button1;
    JoystickButton button2;
    JoystickButton button3;
    JoystickButton button4;
    JoystickButton button5;
    JoystickButton button6;
    JoystickButton button7;
    
    AnalogPressureSensor pressure;
    EncoderTalon3075 rightEncoder;
    EncoderTalon3075 leftEncoder;

//    CANTalon t1; 
//    CANTalon t2;

    
    
    
//    public static final int kExponantial = 1012*739;
//    public static final double driveDistancePerPulseRight = kExponantial/1012;
//	public static final double driveDistancePerPulseLeft = kExponantial/739;
//    Encoder[] encoders = 
//    	{
//    		new Encoder(0, 1, true, Encoder.EncodingType.k4X),
//    		new Encoder(2, 3, false, Encoder.EncodingType.k4X)
//    	};


//    double[] maxs = new double[encoders.length];
    
    public Robot() {
    	
    	stick = new Joystick(0);
    	stick2 = new Joystick(1);

    	leftFront = new CANTalon(4);
    	leftFront.setInverted(false);
    	leftMiddle = new CANTalon(5);
//    	leftMiddle.setInverted(true);
    	leftRear = new CANTalon(3);
    	leftRear.setInverted(true);
    	
    	rightFront = new CANTalon(7);
    	rightFront.setInverted(true);
    	rightMiddle = new CANTalon(6);
    	rightMiddle.setInverted(true);
    	rightRear = new CANTalon(8);
//    	rightRear.setInverted(true);
    	
    	
    	shooterTop = new CANTalon(1);
    	shooterBottom = new CANTalon(2);
    	
//    	triple = new TripleSolenoid(0, 7);
    	littleArms = new Solenoid3075(4,5);
    	ballPusher = new Solenoid3075(0,1);
    	shooterAngle = new Solenoid3075(6,7);
    	shifter = new Solenoid3075(2,3);
    	triple = new TripleSolenoid(11,3,2);
//    	triple = new Solenoid3075(11,3,2);
    	
    	button1 = new JoystickButton(stick, 1);
    	button2 = new JoystickButton(stick, 2);
    	button3 = new JoystickButton(stick, 3);
    	button4 = new JoystickButton(stick, 4);
    	button5 = new JoystickButton(stick, 5);
//    	button6 = new JoystickButton(stick, 6);
//    	button7 = new JoystickButton(stick, 7);

//    	button1.whenPressed(littleArms.ToggleCommand());
//    	button2.whenPressed(ballPusher.ToggleCommand());
//    	button3.whenPressed(shooterAngle.ToggleCommand());
//    	button4.whenPressed(shifter.ToggleCommand());
//    	button5.whenPressed(triple.ToggleCommand());
    	
    	
    	pressure = new AnalogPressureSensor(0);
    	leftEncoder = new EncoderTalon3075(leftMiddle);
    	rightEncoder = new EncoderTalon3075(rightMiddle);
    	leftEncoder.setDistancePerPulse(11558);
    	rightEncoder.setDistancePerPulse(11822);
    	leftEncoder.reset();
    	rightEncoder.reset();
//    	leftFront.setSlave(leftMiddle);
//    	rightFront.
    	
//        myRobot = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
//        myRobot.setExpiration(0.1);
        
//
//        encoders[0].setDistancePerPulse(driveDistancePerPulseLeft);
//        encoders[1].setDistancePerPulse(driveDistancePerPulseRight);
//        encoders[0].reset();
//        encoders[1].reset();
//        
//        t1 = new CANTalon(1);
//        t2 = new CANTalon(0);
//       

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
    	leftEncoder.reset();
    	leftEncoder.invert(true);
    	rightEncoder.reset();
//        myRobot.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
        	DriverStation.reportError("Air Pressure: " + (int)pressure.readPressure() + "\n", false);
//        	DriverStation.reportError("Left pos: " + leftEncoder.getRawPosition() + "\n", false);
//        	DriverStation.reportError("Right pos: " + rightEncoder.getRawPosition() + "\n", false);
//        	maxSpeeds();
//        	for(int i = 0; i < encoders.length; i++)
//        	{
//        		SmartDashboard.putNumber("Encoder " + i + " rate", encoders[i].getRate()/kExponantial);
//        		SmartDashboard.putNumber("Encoder " + i + " distance", encoders[i].getDistance()/kExponantial);
//        		SmartDashboard.putNumber("Encoder " + i + " max speed", maxs[i]);
////        		encoders[i].setDistancePerPulse(SmartDashboard.getNumber("Encoder " + i + " DisPerPul"));
//        	}
//        	
//        	SmartDashboard.putNumber("Talon 0", t1.getSpeed());
//        	SmartDashboard.putNumber("Talon 1", t2.getSpeed());

        	
        	double[] arcade = utils.arcadeDrive(-stick.getY(), stick.getX());
        	double left = arcade[0];
        	double right = arcade[1];
//        	
        	leftFront.set(left);
        	leftMiddle.set(left);
        	leftRear.set(left);
        	
        	rightFront.set(right);
        	rightMiddle.set(right);
        	rightRear.set(right);
        	
        	shooterTop.set((1-stick.getRawAxis(2))/2);
        	shooterBottom.set(-(1-stick.getRawAxis(2))/2);
            
        	if(stick2.getRawButton(6))
        	{
        		shooterTop.set(-0.3);
            	shooterBottom.set(-0.6);
        	}
        	
        	if(stick2.getRawButton(7))
        	{
        		shooterTop.set(0.65);
            	shooterBottom.set(-0.65);
        	}
//        	
//        	if(stick.getRawButton(5))
//        	{
//        		triple.set(Solenoid3075.Value.kForward);
////        		Timer.delay(0.05);
////            	triple.set(Solenoid3075.Value.kOff);
//        	}
//        	
//        	if(stick.getRawButton(6))
//        	{
//        		triple.set(Solenoid3075.Value.kReverse);
////        		Timer.delay(0.05);
////            	triple.set(Solenoid3075.Value.kOff);
//        	}
//        	
        	if(stick.getRawButton(3))
        		littleArms.set(Value.kReverse);
        	else
        		littleArms.set(Value.kForward);
        	
        	if(stick.getRawButton(5))
        		triple.set(Value.kReverse);
        	else if(stick.getRawButton(6))
        		triple.set(Value.kForward);
        	
        	if(stick.getRawButton(1))
        		ballPusher.set(Value.kReverse);
        	else
        		ballPusher.set(Value.kForward);
        	
        	if(stick.getRawButton(4))
        		shooterAngle.set(Value.kForward);
        	else
        		shooterAngle.set(Value.kReverse);
        	
        	if(stick.getRawButton(2))
        		shifter.set(Value.kForward);
        	else
        		shifter.set(Value.kReverse);
        	
        	if(stick2.getRawButton(1))
        	{
        		leftEncoder.reset();
            	rightEncoder.reset();
        	}
//        	if(stick.getRawButton(1))
//        	{
//        		littleArms.set(littleArms.get() == Value.kReverse ? Value.kForward : Value.kReverse);
//        	}
//        	
//        	if(stick.getRawButton(2))
//        	{
//        		triple.set(triple.get() == Value.kReverse ? Value.kForward : Value.kReverse);
//        	}
//        	
//        	if(stick.getRawButton(3))
//        	{
//        		ballPusher.set(ballPusher.get() == Value.kReverse ? Value.kForward : Value.kReverse);
//        	}
//        	
//        	if(stick.getRawButton(4))
//        	{
//        		shooterAngle.set(shooterAngle.get() == Value.kReverse ? Value.kForward : Value.kReverse);
//        		Timer.delay(0.05);
//        	}
//        	
//        	if(stick.getRawButton(5))
//        	{
//        		shifter.set(shifter.get() == Value.kReverse ? Value.kForward : Value.kReverse);
//        	}
        	SmartDashboard.putNumber("Encoder Left", leftEncoder.getDistance());
        	
        	SmartDashboard.putNumber("Encoder Right", rightEncoder.getDistance());
        	
            Timer.delay(0.005);		// wait for a motor update time
        }
    }

    /**
     * Runs during test mode
     */
    public void test() {
    }
    
//    public void maxSpeeds()
//    {
//    	for(int i = 0; i < encoders.length; i++)
//    	{
//    		if(maxs != null && encoders[i].getRate() > maxs[i])
//    			maxs[i] = encoders[i].getRate();
//    	}
//    }
}
