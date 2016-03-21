package org.usfirst.frc.team766.robot.commands.Autons;

import org.usfirst.frc.team766.robot.commands.Camera.FindTarget;
import org.usfirst.frc.team766.robot.commands.Catapult.Fire;
import org.usfirst.frc.team766.robot.commands.Drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OneBallAuton extends CommandGroup{
	public OneBallAuton(){
		addSequential(new DriveObstical());
		addSequential(new TurnAngle(30));
		addSequential(new FindTarget());
		addSequential(new Fire());
	}

}
