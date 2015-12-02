package libPurple;

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
		return  lastValue + (Math.signum(currentValue - lastValue) * Math.min(accellimit, Math.abs(currentValue - lastValue)));
	}
	
	public static double motorBound(double value, double motorBound)
    {
    	return Math.signum(value) * (Math.abs(value) - (motorBound * Math.abs(value)) + motorBound);    	
	}
	
	public static double[] arcadeDrive(double y, double x)
	{
		double[] arr = new double[2];
		double max = Math.max(Math.abs(y), Math.abs(x));
		double sum = y + x;
		double dif = y - x;
		if(y >= 0)
		{
			if(x >= 0)
			{
				arr[0] = max;
				arr[1] = dif;
			}
			else
			{
				arr[0] = sum;
				arr[1] = max;
			}
		}
		else
		{
			if(x >= 0)
			{
				arr[0] = sum;
				arr[1] = -max;
			}
			else
			{
				arr[0] = -max;
				arr[1] = dif;
			}
		}
		max = 0;
		sum = 0;
		dif = 0;
		return arr;
	}
	
	public static double[] arcadeDrive(double y, double x, double turnSensitivity)
	{
		return arcadeDrive(y, x*turnSensitivity);
	}
	
	public static double powerValue(double value, int power)
	{
		return Math.signum(value)*Math.abs(Math.pow(value, power));
	}
}