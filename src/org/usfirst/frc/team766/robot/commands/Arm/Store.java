package org.usfirst.frc.team766.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Store extends CommandGroup{
	public Store(){
		addParallel(new ExtendArmStage1(false));
		addParallel(new ExtendArmStage3(false));
		addSequential(new RetractArmStage2(true));
	}
}
