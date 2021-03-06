package libPurple;

import org.usfirst.frc.team3075.robot.Constants;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

public class CANTalon3075 extends CANTalon{
    
    private double motorBound = 0;
    private int inverted = 1;
	
	public CANTalon3075(int channel)
	{
		super(channel);
		
	}
	
	public CANTalon3075(int channel, boolean inverted)
	{
		super(channel);
		super.reverseOutput(inverted);
		this.inverted = inverted ? -1 : 1;
	}
	
	public CANTalon3075(int channel, CANTalon3075 master)
	{
		super(channel);
		super.changeControlMode(CANTalon.ControlMode.Follower);
		super.set(master.getDeviceID());
	}
	
	public CANTalon3075(int channel, CANTalon3075 master, boolean inverted)
	{
		super(channel);
		super.changeControlMode(CANTalon.ControlMode.Follower);
		super.reverseOutput(inverted);
		this.inverted = inverted ? -1 : 1;
		super.set(master.getDeviceID());
	}
	
	public void setSpeed(double speed)
	{
		super.set(utils.motorBound(speed, motorBound));
	}
	
	@Override
	public void set(double outputValue) {
		// TODO Auto-generated method stub
		super.set(outputValue * inverted);
	}
}
