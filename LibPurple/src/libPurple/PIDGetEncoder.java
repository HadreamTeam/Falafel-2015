package libPurple;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;

public class PIDGetEncoder implements PIDSource{

	private Encoder3075 encoder;
	private boolean returnRate;
	
	public PIDGetEncoder(Encoder3075 e, boolean returnRate)
	{
		encoder = e;
		this.returnRate = returnRate;
	}
	
	@Override
	public double pidGet() {
		
		return returnRate ? encoder.getRate() : encoder.getDistance();
	}
	
	
}
