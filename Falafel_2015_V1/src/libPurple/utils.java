package libPurple;

public class utils
{
	
	// Takes two numbers and check if they are closer than dif
	public static boolean inRange(double x, double y, double dif)
	{
		assert dif > 0;
		return Math.abs(x - y) < dif;
	}
	
	public static double accellimit(double current, double requested, double accellimit)
	{
		return + (Math.signum(requested - current) * Math.min(accellimit, Math.abs(current - requested)));
	}
	
	public static double motorBound(double x, double MB)
    {
    	return Math.signum(x)* (Math.abs(x)-(MB*Math.abs(x))+MB);    	
	}
	
	
}