package org.usfirst.frc.team3075.robot.subsystems;

import org.usfirst.frc.team3075.robot.Constants;
import org.usfirst.frc.team3075.robot.commands.Wait;

import libPurple.EncoderTalon3075;
import libPurple.Victor3075;
import libPurple.utils;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TwoMotorPID extends PIDSubsystem {
    
	private Victor3075 rearMotor;
	private Victor3075 frontMotor;
	private EncoderTalon3075 encoder;
	private boolean returnRate = true;
	
    public TwoMotorPID(Victor3075 rear, Victor3075 front, double p, double i, double d, double period) {
		super(p, i, d, period);
		super.setInputRange(-Constants.maxSpeed, Constants.maxSpeed);
		rearMotor = rear;
		frontMotor = front;
		// TODO Auto-generated constructor stub
	}
    
    public TwoMotorPID(Victor3075 rear, Victor3075 front, double p, double i, double d) {
		super(p, i, d, 0.02);
		super.setInputRange(-Constants.maxSpeed, Constants.maxSpeed);
		rearMotor = rear;
		frontMotor = front;
		// TODO Auto-generated constructor stub
	}
    
    public TwoMotorPID(Victor3075 rear, Victor3075 front, EncoderTalon3075 encoder, double p, double i, double d) {
		super(p, i, d, 0.02);
		super.setInputRange(-Constants.maxSpeed, Constants.maxSpeed);

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
        
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	SmartDashboard.putNumber("pid think", encoder.getRate());
    	
    	return returnRate ? (encoder.getRate()):
    		encoder.getDistance() ;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
    	
    	    SmartDashboard.putNumber("pid to motor", output);
        	rearMotor.set(output);
            frontMotor.set(output);
    }
    
    public void setRaw(double output)
    {
    	rearMotor.set(output);
        frontMotor.set(output);
    }
    
    public void setAccellimit(double newAccellimit)
    {
    	rearMotor.setAccellimit(newAccellimit);
    	frontMotor.setAccellimit(newAccellimit);
    }
    
//    public void setDeAccellimit(double newdeAccellimit)
//    {
//    	rearMotor.setDeAccellimit(newdeAccellimit);
//    	frontMotor.setDeAccellimit(newdeAccellimit);
//    }
    
    public void setMotorBound(double newMotorBound)
    {
    	rearMotor.setMotorBound(newMotorBound);
    	frontMotor.setMotorBound(newMotorBound);
    	
    }
    
    public TwoMotorPID setPID( double p, double i, double d)
    {
    	
    	return new TwoMotorPID(rearMotor, frontMotor, encoder, p, i, d);
    	
    }
    
}
