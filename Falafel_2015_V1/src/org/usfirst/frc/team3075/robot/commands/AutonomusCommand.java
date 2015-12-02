package org.usfirst.frc.team3075.robot.commands;

import org.usfirst.frc.team3075.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomusCommand extends CommandGroup {
    
    public  AutonomusCommand() {
     
    	addParallel(new Prepare2Shoot());
    	addSequential(new DriveTime(3.5));
    	
    	//addSequential(new MoveOneSlot());
    	//addSequential(new MoveOneSlot());

    
    
    }
}
