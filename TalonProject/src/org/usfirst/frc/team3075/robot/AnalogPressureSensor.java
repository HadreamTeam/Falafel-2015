package org.usfirst.frc.team3075.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DriverStation;

public class AnalogPressureSensor {
	
	AnalogInput input;
	double VCC = 5; // The given voltage.
	
	public AnalogPressureSensor(int channel)
	{
		input = new AnalogInput(channel);
	}
	
	public double readPressure()
	{
		double Vout = input.getVoltage();
//		DriverStation.reportError("Voltage is " +  Vout + "\n", false);
		double p = 275 * (Vout / VCC) - 27.5;
		return p;
	}

}
