
package org.usfirst.frc.team3075.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import libPurple.utils;

import org.usfirst.frc.team3075.robot.commands.AutonomusCommand;
import org.usfirst.frc.team3075.robot.commands.DriveDistance;
import org.usfirst.frc.team3075.robot.commands.ExampleCommand;
import org.usfirst.frc.team3075.robot.subsystems.Conveyor;
import org.usfirst.frc.team3075.robot.subsystems.DriveSystem;
import org.usfirst.frc.team3075.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team3075.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveSystem drive;
	public static Shooter shooter;
	public static Conveyor conveyor;
    Command autonomousCommand;
    
   
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	
    	Constants.init();
    	Components.init();
    	Components.conveyorMotor.setPosition(0);
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomusCommand();
        
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
        Components.driveLeft.setOutputRange(-0.5, 0.5);
		Components.driveRight.setOutputRange(-0.65, 0.65);
        Components.conveyorMotor.setPosition(0);
        Robot.conveyor.setSpeed(0);
        Components.driveLeftEncoder.reset();
        Components.driveRightEncoder.reset();
        Components.portableTargetServo.setAngle(180);
        Components.log();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
//    	drive.setAccellimit(2);
//    	drive.setDeAccellimit(2);

        Scheduler.getInstance().run();
        Components.log();
        Components.testLog();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
//    	drive.setAccellimit(Constants.kAccelimit);
//        drive.setDeAccellimit(Constants.kAccelimit);
        Components.driveLeft.setOutputRange(-1, 1);
		Components.driveRight.setOutputRange(-1, 1);
        Components.conveyorMotor.setPosition(0);
        Robot.conveyor.setSpeed(0);
        Components.driveLeftEncoder.reset();
        Components.driveRightEncoder.reset();
        Components.portableTargetServo.setAngle(180);
        Components.log();
        
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.setRunPID(Constants.runPID);
        Scheduler.getInstance().run();
        Components.log();
        Components.testLog();
        if(Components.servoButton1.get() && Components.servoButton2.get())
        {
        	Components.portableTargetServo.setAngle(-90);
        }
        utils.batteryWatcher();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
//        LiveWindow.run();
        Scheduler.getInstance().run();
        Components.log();
        Components.testLog();
    }
}
