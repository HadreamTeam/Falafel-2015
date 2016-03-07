package org.usfirst.frc.team3075.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class TripleSolenoid extends DoubleSolenoid{
	int position = 0;

	public TripleSolenoid(int forwardChannel, int reverseChannel) {
		super(forwardChannel, reverseChannel);
		// TODO Auto-generated constructor stub
	}
	
	public TripleSolenoid(int moduleNum, int forwardChannel, int reverseChannel) {
		super(moduleNum, forwardChannel, reverseChannel);
		// TODO Auto-generated constructor stub
	}
	
	public Command ForwardCommand()
	{
		return new OpenClose(this, true);
	}
	
	public Command BackwardCommand()
	{
		return new OpenClose(this, false);
	}
	
	public void goTo(int pos)
	{
		if(pos >= position)
		{
			for(int i = position; i < pos; i++)
				set(Value.kForward);
		}
		else for(int i = pos; i < position; i--)
			set(Value.kReverse);
	}
	
	@Override
	public void set(Value value)
	{
		if(value == Value.kForward)
			position++;
		else if(value == Value.kReverse)
			position--;
		super.set(value);
		Timer.delay(0.005);
		super.set(Value.kOff);
	}
}


//class OpenClose extends Command {
//
//	DoubleSolenoid mySol;
//	boolean open;
//	
//    public OpenClose(DoubleSolenoid ds, boolean open) {
//    	mySol = ds;
//    	this.open = open;
//    }
//
//    protected void initialize() {
//    }
//
//    protected void execute() {
//    	mySol.set(open ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
////    	mySol.set(DoubleSolenoid.Value.kOff);
//    }
//
//    protected boolean isFinished() {
//        return true;
//    }
//
//    protected void end() {
//    }
//
//    protected void interrupted() {
//    }
//}