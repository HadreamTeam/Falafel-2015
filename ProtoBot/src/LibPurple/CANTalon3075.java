package LibPurple;

import org.usfirst.frc.team3075.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;

public class CANTalon3075 extends CANTalon {
    
    private double motorBound = 0;
	
	public CANTalon3075(int channel)
	{
		super(channel, RobotMap.runPeriod);
	}
	
	public CANTalon3075(int channel, CANTalon3075 master)
	{
		super(channel, RobotMap.runPeriod);
		super.changeControlMode(CANTalon.ControlMode.Follower);
		super.set(master.getDeviceID());
	}
	
	public CANTalon3075(int channel, CANTalon3075 master, boolean inverted)
	{
		super(channel, RobotMap.runPeriod);
		super.reverseOutput(inverted);
		super.changeControlMode(CANTalon.ControlMode.Follower);
		super.set(master.getDeviceID());
	}
	
	public void setSpeed(double speed)
	{
		super.set(utils.motorBound(speed, motorBound));
	}
}
