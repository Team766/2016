package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ManualWinchBack extends CommandBase{

	protected void initialize() {
		Catapult.firePiston(false);
		Catapult.setWinch(RobotValues.WINCH_POWER);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Catapult.setWinch(0.0);
		Catapult.setReadyToFire(true);
	}

	protected void interrupted() {
		end();
	}

}
