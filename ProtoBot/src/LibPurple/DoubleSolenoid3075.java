package LibPurple;

import org.usfirst.frc.team3075.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;


public class DoubleSolenoid3075 extends DoubleSolenoid{

	public DoubleSolenoid3075(int forwardChannel, int reverseChannel) {
		super(forwardChannel, reverseChannel);
		// TODO Auto-generated constructor stub
	}
	
	public Command ToggleCommand()
	{
		return new Toggle(this);
	}
	
	public Command OpenCommand()
	{
		return new OpenClose(this, true);
	}
	
	public Command CloseCommand()
	{
		return new OpenClose(this, false);
	}

}



class Toggle extends Command {

	DoubleSolenoid solenoid;
	
	public Toggle(DoubleSolenoid ds)
	{
		solenoid = ds;
	}

    protected void initialize() {
    }

    protected void execute() {
    	solenoid.set(solenoid.get() == DoubleSolenoid.Value.kForward ? 
    			DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

class OpenClose extends Command {

	DoubleSolenoid solenoid;
	boolean open;
	
    public OpenClose(DoubleSolenoid doubleSolenoid, boolean open) {
    	solenoid = doubleSolenoid;
    	this.open = open;
    }

    protected void initialize() {
    }

    protected void execute() {
    	solenoid.set(open ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}