package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomusCommand extends CommandGroup {
    
    public  AutonomusCommand() {
     
//    	addSequential(new OpenShifter());
    	addParallel(new Prepare2Shoot(Constants.WheelsSpeed));
    	addParallel(new DriveDistance(Constants.autonomusDistancetoLine, Constants.autonomusDistancetoLine));
    	addSequential(new Wait(), 4.7);
    	
    	addSequential(new MoveOneSlotTime());
    	addSequential(new Wait(), 0.2);
    	
    	addSequential(new MoveOneSlotTime());
    	addSequential(new Wait(), 0.2);

    	addSequential(new MoveOneSlotTime());
    	addSequential(new Wait(), 0.2);

    	addSequential(new MoveOneSlotTime());
    	addSequential(new Wait(), 0.2);
    	
    	addSequential(new MoveOneSlotTime());
    	
    	addSequential(new Prepare2Shoot(0));
    	


    
    
    }
}
