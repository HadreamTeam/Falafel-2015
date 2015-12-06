package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomusCommand extends CommandGroup {
    
    public  AutonomusCommand() {
     
//    	addSequential(new OpenShifter());
    	addParallel(new Prepare2Shoot());
    	addParallel(new DriveDistance(Constants.autonomusDistancetoLine, Constants.autonomusDistancetoLine));
    	addSequential(new Wait(), 4.5);
    	
    	addSequential(new MoveOneSlot());
    	addSequential(new Wait(), 1);
    	
    	addSequential(new MoveOneSlot());
    	addSequential(new Wait(), 1);

    	addSequential(new MoveOneSlot());
    	addSequential(new Wait(), 1);
    	
    	addSequential(new MoveOneSlot());
    	addSequential(new Wait(), 1);
    	
    	addSequential(new MoveOneSlot());



    
    
    }
}
