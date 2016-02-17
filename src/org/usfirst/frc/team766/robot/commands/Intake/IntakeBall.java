package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class IntakeBall extends CommandBase{

	protected void initialize() {
		MoveIntake(RobotValues.INTAKE_BALL_ANGLE);
	}

	protected void execute() {
		Intake.setWheels();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Intake.setWheels(0.0);
	}

	protected void interrupted() {
		end();
	}

}
