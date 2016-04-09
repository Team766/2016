package org.usfirst.frc.team766.robot.commands.Autons;

import org.usfirst.frc.team766.lib.LogFactory;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonSelector extends CommandGroup{
	
	public AutonSelector(int mode){
		switch(RobotValues.Autons[mode]){
			case "Drive Obstical":
				System.out.println("Auton: Drive Obstical");
				LogFactory.getInstance("General").print("Auton: Drive Obstical");
				addSequential(new DriveObstical());
				break;
				
			case "Drive Ramparts":
				System.out.println("Auton: Drive Ramparts");
				LogFactory.getInstance("General").print("Auton: Drive Ramparts");
				addSequential(new DriveRamparts());
				break;
				
			case "Drive Low Bar":
				System.out.println("Auton: Drive Low Bar");
				LogFactory.getInstance("General").print("Auton: Drive Low Bar");
				addSequential(new DriveLowBar());
				break;
				
			case "High Goal Shot":
				System.out.println("Auton: High Goal Shot");
				LogFactory.getInstance("General").print("Auton: High Goal Shot");
				addSequential(new HighGoalAuton());
				break;
				
			case "None":
				System.out.println("Auton: None");
				LogFactory.getInstance("General").print("Auton: None");
				break;
		}
	}
}
