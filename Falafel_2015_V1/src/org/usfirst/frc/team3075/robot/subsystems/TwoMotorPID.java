package org.usfirst.frc.team3075.robot.subsystems;

import libPurple.Victor3075;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class TwoMotorPID extends PIDSubsystem {
    
	private Victor3075 rearMotor;
	private Victor3075 frontMotor;
	private Encoder encoder;
	private boolean returnRate = true;
	
    public TwoMotorPID(Victor3075 rear, Victor3075 front, double p, double i, double d, double period) {
		super(p, i, d, period);
		rearMotor = rear;
		frontMotor = front;
		// TODO Auto-generated constructor stub
	}
    
    public TwoMotorPID(Victor3075 rear, Victor3075 front, double p, double i, double d) {
		super(p, i, d, 0.02);
		rearMotor = rear;
		frontMotor = front;
		// TODO Auto-generated constructor stub
	}
    
    public TwoMotorPID(Victor3075 rear, Victor3075 front, Encoder encoder, double p, double i, double d) {
		super(p, i, d, 0.02);
		rearMotor = rear;
		frontMotor = front;
		this.encoder = encoder;
		// TODO Auto-generated constructor stub
	}

	public boolean isReturnRate() {
		return returnRate;
	}

	public void setReturnRate(boolean returnRate) {
		this.returnRate = returnRate;
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return returnRate ? encoder.getRate() : encoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        rearMotor.set(output);
        frontMotor.set(output);
    }
}
