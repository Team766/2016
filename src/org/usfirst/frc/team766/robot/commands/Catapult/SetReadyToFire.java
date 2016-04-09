package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class SetReadyToFire extends CommandBase{
	
	private boolean readyToFire;
	
	public SetReadyToFire(boolean in){
		readyToFire = in;
	}
	
	protected void initialize() {
		Catapult.setReadyToFire(readyToFire);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Catapult.getReadyToFire() == readyToFire;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

}
