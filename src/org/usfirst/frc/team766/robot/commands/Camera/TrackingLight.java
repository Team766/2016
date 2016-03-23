package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class TrackingLight extends CommandBase{
	private boolean state;
	public TrackingLight(boolean on){
		state = on;
	}
	
	protected void initialize() {
		Camera.setTrackingLight(state);
//		setTimeout(1);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
//		return isTimedOut();
	}

	protected void end() {
		Camera.setTrackingLight(!state);
	}

	protected void interrupted() {
		end();
	}

}
