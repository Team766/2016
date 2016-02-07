package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.commands.CommandBase;


public class Winch extends CommandBase{

	protected void initialize() {
	}
	
	protected void execute() {
		if(!Catapult.getReadyToFire())
			Catapult.goWinch();
	}

	protected boolean isFinished() {
		return Catapult.sensorDown();
	}

	protected void end() {
		Catapult.setWinch(0.0);
		Catapult.setReadyToFire(true);
	}

	protected void interrupted() {
		Catapult.setWinch(0.0);
		Catapult.setReadyToFire(false);
	}
}
