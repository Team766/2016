package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class TrackingLight extends CommandBase{
	private boolean state;
	public TrackingLight(boolean on){
		state = on;
//		setTimeout(1);
	}
	
	protected void initialize() {
		Camera.setTrackingLight(state);
		Camera.setCameraLights(state);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
//		return isTimedOut();
		return false;
	}

	protected void end() {
		Camera.setTrackingLight(!state);
		Camera.setCameraLights(!state);
	}

	protected void interrupted() {
		end();
	}

}
