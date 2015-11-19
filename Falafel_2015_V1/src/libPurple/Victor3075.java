package libPurple;

import edu.wpi.first.wpilibj.Victor;

public class Victor3075 extends Victor {
    private int inverted = 1;
    private final double MB = 0.1;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

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
    	super.set(utils.motorBound(speed, MB) * inverted);
    }
    
    public void setInverted(boolean isInverted)
    {
    	this.inverted = isInverted ? -1 : 1;
    }
    
   
}
