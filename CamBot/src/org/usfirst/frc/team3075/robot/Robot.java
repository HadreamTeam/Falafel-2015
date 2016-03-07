
package org.usfirst.frc.team3075.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    final String defaultAuto = "Default";
    final String customAuto = "My Auto";
    String autoSelected;
    SendableChooser chooser;
//    NetworkTable server;
    ImageDetection3075 deImageDetectorV1TESTTESTDROPTABLE;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
//        chooser = new SendableChooser();
//        chooser.addDefault("Default Auto", defaultAuto);
//        chooser.addObject("My Auto", customAuto);
//        SmartDashboard.putData("Auto choices", chooser);
//    	server = NetworkTable.getTable("SmartDashboard");
//    	Drivier("port :" + server.DEFAULT_PORT);
    	deImageDetectorV1TESTTESTDROPTABLE = new ImageDetection3075();
    }
    
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString line to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the switch structure below with additional strings.
	 * If using the SendableChooser make sure to add them to the chooser code above as well.
	 */
    public void autonomousInit() {
    	autoSelected = (String) chooser.getSelected();
//		autoSelected = SmartDashboard.getString("Auto Selector", defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	switch(autoSelected) {
    	case customAuto:
        //Put custom auto code here   
            break;
    	case defaultAuto:
    	default:
    	//Put default auto code here
            break;
    	}
    }

    /**
     * This function is called periodically during operator control
     */
	public void teleopPeriodic() {
		Rectangle res = deImageDetectorV1TESTTESTDROPTABLE.getRectangle();
		res.setTargetRatio(deImageDetectorV1TESTTESTDROPTABLE.targetRatio);
//		DriverStation.reportError(res.toString()+ "\n", false);
//		DriverStation.reportError("Width is " + res.getWidth() + " pixels\n", false);
//		DriverStation.reportError("Height is " + res.getHeight() + " pixels\n", false);
		DriverStation.reportError("Angle is " + res.getAngle() + " degrees\n", false);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}