package libPurple;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PistonToggle extends Command {

	DoubleSolenoid mySol;
	boolean exe = false;
    public PistonToggle(DoubleSolenoid ds) {
        mySol = ds;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	mySol.set(mySol.get() == DoubleSolenoid.Value.kForward ? 
    			DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    	exe = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return exe;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
