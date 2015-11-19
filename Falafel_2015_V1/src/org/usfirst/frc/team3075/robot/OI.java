package org.usfirst.frc.team3075.robot;

import libPurple.JoyStick3075;

import org.usfirst.frc.team3075.robot.commands.CloseShifter;
import org.usfirst.frc.team3075.robot.commands.ManualConveyor;
import org.usfirst.frc.team3075.robot.commands.MoveOneSlot;
import org.usfirst.frc.team3075.robot.commands.OpenShifter;
import org.usfirst.frc.team3075.robot.commands.Wait;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	 public static JoyStick3075 driveStick;
	 public static JoyStick3075 systemStick;
	 public static Button button0;  //Open the shifter on  1
	 public static Button button1;  //Close the shifter on 2
	 public static Button button2;  //Move one slot on 3
	 public static Button button3;  //Toggle conveyor to manual on 4
	 
	 public static Encoder conveyorEncoder; 
	 public static Encoder shooterLeftEncoder;
	 public static Encoder shooterRightEncoder;
	 public static Encoder driveLeftEncoder;
	 public static Encoder driveRightEncoder;
	 
	 //Constants
	 public static final double kConveyorDiameter = 137; 
	 public static final double kDriveDiameter = 15;
	 
	 public static void init() {
		 
		 driveStick = new JoyStick3075(0);
		 systemStick = new JoyStick3075(1);
		 
		 button0 = new JoystickButton(driveStick, 1);
		 button0.whenPressed(new OpenShifter());
		 
		 button1 = new JoystickButton(driveStick, 2);
		 button1.whenPressed(new CloseShifter());
		 
		 button2 = new JoystickButton(systemStick, 1);
		 button2.whenPressed(new MoveOneSlot());
		 
		 button3 = new JoystickButton(systemStick, 2);
		 if(button3.get())
			 button3.toggleWhenPressed(new ManualConveyor());
		 else
			 button3.toggleWhenPressed(new Wait());
		 
		 
		 conveyorEncoder = new Encoder(0,1,false,Encoder.EncodingType.k4X);
		 conveyorEncoder.setDistancePerPulse(kConveyorDiameter * Math.PI / 4);
		 
		 shooterLeftEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		 shooterLeftEncoder.setDistancePerPulse(90);
		 shooterRightEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
		 shooterRightEncoder.setDistancePerPulse(90);
		 
		 driveLeftEncoder = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
		 driveLeftEncoder.setDistancePerPulse(kDriveDiameter * Math.PI / 4);
		 driveRightEncoder = new Encoder(8, 9, true, Encoder.EncodingType.k4X);
		 driveLeftEncoder.setDistancePerPulse(kDriveDiameter * Math.PI / 4);
		 
	 }

    
	
	
}

