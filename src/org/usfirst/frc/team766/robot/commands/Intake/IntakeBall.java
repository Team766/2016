package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class IntakeBall extends CommandBase {

	protected void initialize() {
	}

	protected void execute() {
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
