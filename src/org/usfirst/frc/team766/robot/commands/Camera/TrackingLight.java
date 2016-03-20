package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class TrackingLight extends CommandBase{

	public TrackingLight(boolean on){
		Camera.setTrackingLight(on);
		setTimeout(1);
	}
	
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

}
