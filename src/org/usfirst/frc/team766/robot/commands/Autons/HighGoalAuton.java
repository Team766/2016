package org.usfirst.frc.team766.robot.commands.Autons;

import org.usfirst.frc.team766.robot.commands.Catapult.Fire;
import org.usfirst.frc.team766.robot.commands.Catapult.SetReadyToFire;
import org.usfirst.frc.team766.robot.commands.Catapult.WaitForWinch;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HighGoalAuton extends CommandGroup{

	public HighGoalAuton(){
		addSequential(new SetReadyToFire(false));
		addSequential(new WaitForWinch());
		addSequential(new Fire());
	}
}
