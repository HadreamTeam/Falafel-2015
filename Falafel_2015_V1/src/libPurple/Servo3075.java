package libPurple;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;

public class Servo3075 extends Servo{

	public Servo3075(int channel) {
		super(channel);
		// TODO Auto-generated constructor stub
	}
	
	public Command goToAngle(double angle)
	{
		return new goToAngleCommand(this, angle);
	}
	
	public Command angleToggle(double offAngle, double onAngle)
	{
		return new angleToggleCommand(this, offAngle, onAngle);
	}

}

class angleToggleCommand extends Command
{

	private Servo3075 myServo;
	private double offAngle;
	private double onAngle;
	
	public angleToggleCommand(Servo3075 servo, double offAngle, double onAngle) {
		// TODO Auto-generated constructor stub
		myServo = servo;
		this.offAngle = offAngle;
		this.onAngle = onAngle;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		myServo.setAngle(onAngle);
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		myServo.setAngle(offAngle);
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}

//name because i'm afraid that the goToAngle method had the
//same name as the command
class goToAngleCommand extends Command
{

	private Servo3075 myServo;
	private double wantedAngle;
	
	public goToAngleCommand(Servo3075 servo, double angle) {
		// TODO Auto-generated constructor stub
		myServo = servo;
		wantedAngle = angle;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		myServo.setAngle(wantedAngle);
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return utils.inRange(wantedAngle, myServo.getAngle(), 5);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	
}
