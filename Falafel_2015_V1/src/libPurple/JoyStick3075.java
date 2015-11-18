package libPurple;

import edu.wpi.first.wpilibj.Joystick;

public class JoyStick3075 extends Joystick {

	public static double db=0.1;
	public JoyStick3075(int port) {
		super(port);
	}

	public double xGet()
	{
		//The calculation of Deadband.
		double x = super.getX(); 
		return Math.abs(x)<db ? 0 : Math.signum(x)*(Math.abs(x) - db) / (1- db);
	}
	
	public double yGet()
	{
		//The calculation of Deadband.
		double y = super.getY(); 
		return Math.abs(y)<db ? 0 : Math.signum(y)*(Math.abs(y) - db) / (1- db);
	}
	
	public double axisGet(int axis)
	{
		//The calculation of Deadband.
		double value = super.getRawAxis(axis);
		return Math.abs(value)<db ? 0 : Math.signum(value)*(Math.abs(value) - db) / (1- db);
	}
	

}