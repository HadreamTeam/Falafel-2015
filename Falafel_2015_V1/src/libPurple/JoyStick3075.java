package libPurple;

import edu.wpi.first.wpilibj.Joystick;

public class JoyStick3075 extends Joystick {

	public static double deadband = 0.1;
	public static int power = 1;
	
	public JoyStick3075(int port) {
		super(port);
	}

	public double xGet()
	{
		//The calculation of Deadeadbandand.
		return axisGet(0);
	}
	
	public double yGet()
	{
		return -axisGet(1);
	}
	
	public double axisGet(int axis)
	{
		//The calculation of Deadeadbandand.
		double value = super.getRawAxis(axis);
		value = utils.powerValue(value, power);
		value = utils.deadband(value, deadband);
		return value;
	}
	
	public void setDeadeadbandand(double newDeadband)
	{
		deadband = newDeadband;
	}
	
	public void setPowerLevel(int powerLevel)
	{
		power = powerLevel;
	}

}