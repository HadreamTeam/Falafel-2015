package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.OI;
import org.usfirst.frc.team3075.robot.RobotMap;
import org.usfirst.frc.team3075.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Conveyor extends PIDSubsystem {

    
    public Conveyor(double p, double i, double d, double period) {
		super(p, i, d, period);
		setAbsoluteTolerance(RobotMap.conveyorTolerance);
		// TODO Auto-generated constructor stub
	}
    
    public Conveyor(double p, double i, double d) {
		super(p, i, d, 0.02);
		setAbsoluteTolerance(RobotMap.conveyorTolerance);
		// TODO Auto-generated constructor stub
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Wait());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	
    	return OI.conveyorEncoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	RobotMap.conveyorMotor.set(output);
    }
    
    public void setSpeed(double speed)
    {
    	RobotMap.conveyorMotor.set(speed);
    }
    
}





