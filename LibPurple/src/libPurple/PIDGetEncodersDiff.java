package libPurple;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;

public class PIDGetEncodersDiff implements PIDSource{

	private PIDController left;
	private PIDController right;
	
	double distanceLeft;
	double distanceRight;
	
	public PIDGetEncodersDiff(PIDController left, PIDController right)
	{
		this.left = left;
		this.right = right;
		distanceLeft = -left.getError();
		distanceRight = -right.getError();
	}
	
	@Override
	public double pidGet() {
		
		return left.getError()/distanceLeft - right.getError()/distanceRight;
	}
	
	
}
