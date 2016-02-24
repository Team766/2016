package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeBall extends CommandGroup {
	public IntakeBall(){
		addParallel(new SetWheels(1.0));
		addParallel(new MoveArm(CommandBase.Intake.getAngleFromHeight(RobotValues.BALL_COMPRESSION_HEIGHT)));
	}
}
