package org.usfirst.frc.team3075.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class EncoderDIO3075 extends Encoder implements Encoder3075{

	private boolean pidGetRate = true;
	public static EncodingType k4x = EncodingType.k4X;
	
	public EncoderDIO3075(int aChannel, int bChannel, boolean reverseDirection, EncodingType encodingType) {
		
		super(aChannel, bChannel, reverseDirection, encodingType);
	}
	
	@Override
	public double pidGet()
	{
		return pidGetRate ? super.getRate():super.getDistance();
	}

	public boolean isPidGetRate() {
		return pidGetRate;
	}

	public void setPidGetRate(boolean pidGetRate) {
		this.pidGetRate = pidGetRate;
	}

	@Override
	public void invert(boolean inverted) {
		// TODO Auto-generated method stub
		super.setReverseDirection(inverted);
		
	}

	
}
