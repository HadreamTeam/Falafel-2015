package org.usfirst.frc.team3075.robot;

import LibPurple.JoyStick3075;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3075.robot.commands.ExampleCommand;
import org.usfirst.frc.team3075.robot.commands.GearDown;
import org.usfirst.frc.team3075.robot.commands.GearUp;
import org.usfirst.frc.team3075.robot.commands.Grab;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static JoyStick3075 driveStick;
	public static JoyStick3075 systemStick;
	public static JoystickButton grabberTrigger;
	public static JoystickButton shifterUp;
	public static JoystickButton shifterDown;

	
 public static void init()
 {
		 
		 driveStick = new JoyStick3075(0);
		 systemStick = new JoyStick3075(1);
		 grabberTrigger = new JoystickButton(systemStick, 1);
		 grabberTrigger.whenPressed(RobotMap.grabber.ToggleCommand());
		 
		 shifterDown = new JoystickButton(driveStick, 2);
		 shifterDown.whenPressed(new GearDown());
		 
		 shifterUp = new JoystickButton(driveStick, 3);
		 shifterUp.whenPressed(new GearUp());

 }
 
}

