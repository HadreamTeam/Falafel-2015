package libPurple;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Victor3075 extends Victor {
    private int inverted = 1;
    private double motorBound = 0.05;
    private double accellimit = 1;
    private double deaccellimit = 1;
    private double lastValue = 0;
    
    

    public Victor3075(int channel, boolean inverted) {
		super(channel);
		
		this.inverted = inverted ? -1 : 1;
		// TODO Auto-generated constructor stub
	}
    
    public Victor3075(int channel) {
		super(channel);

		// TODO Auto-generated constructor stub
	}
    
    @Override
    public double get() {
    	// TODO Auto-generated method stub
    	return super.get() * inverted; 
    	
    }
    
    @Override
    public void set(double speed) {
    	// TODO Auto-generated method stub
    	
    	speed = utils.motorBound(speed, motorBound) * inverted;
//    	speed = utils.accellimit(speed, lastValue, accellimit);
    	super.set(speed);
    	lastValue = speed;
    }
    
    public void setInverted(boolean isInverted)
    {
    	this.inverted = isInverted ? -1 : 1;
    }
    
    public void setMotorBound(double newMotorBound)
    {
    	motorBound = newMotorBound;
    }
    
    public void setAccellimit(double newAccellimit)
    {
    	accellimit = newAccellimit;
    }
    

}
