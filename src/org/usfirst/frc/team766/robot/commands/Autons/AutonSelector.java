package org.usfirst.frc.team766.robot.commands.Autons;

import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonSelector extends CommandGroup{
	
	public AutonSelector(int mode){
		switch(RobotValues.Autons[mode]){
			case "Drive Obstical":
				System.out.println("Auton: Drive Obstical");
				addSequential(new DriveObstical());
				break;
				
			case "Drive Ramparts":
				System.out.println("Auton: Drive Ramparts");
				addSequential(new DriveRamparts());
				break;
				
			case "None":
				System.out.println("Auton: None");
				break;
		}
	}
}
