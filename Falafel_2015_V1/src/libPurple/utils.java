package libPurple;

public class utils
{
	
	// Takes two numbers and check if they are closer than dif
	public static boolean inRange(double x, double y, double dif)
	{
		assert dif > 0;
		return Math.abs(x - y) < dif;
	}
	//x is the joystic current
	//y is the joystick speed recives 
	// exe is the 
//	public static double accelimit(double x,double y,double exe)
//	{
//		if(x<y)
//		{
//			
//		}
//		
//		
//	}
	public static double accellimit(double current, double requested, double accellimit)
	{
		return + (Math.signum(requested - current) * Math.min(accellimit, Math.abs(current-requested)));
	}
	
	
}