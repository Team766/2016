package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class WaitForWinch extends CommandBase{

	protected void initialize() {
	}

	protected void execute() {
		System.out.println("Catapult: " + Catapult.getReadyToFire());
	}

	protected boolean isFinished() {
		return Catapult.getReadyToFire();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
