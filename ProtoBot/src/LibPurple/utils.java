package LibPurple;

public class utils
{
	
	// Takes two numbers and check if they are closer than dif
	public static boolean inRange(double value, double y, double dif)
	{
		assert dif > 0;
		return Math.abs(value - y) < dif;
	}
	
	public static double deadband(double value, double deadband)
	{
		return Math.abs(value) < deadband ? 0 : Math.signum(value) * (Math.abs(value) - deadband) / (1 - deadband);
	}
	
	public static double accellimit(double currentValue, double lastValue, double accellimit)
	{
		return + (Math.signum(lastValue - currentValue) * Math.min(accellimit, Math.abs(currentValue - lastValue)));
	}
	
	public static double motorBound(double value, double motorBound)
    {
    	return Math.signum(value) * (Math.abs(value) - (motorBound * Math.abs(value)) + motorBound);    	
	}
	
}