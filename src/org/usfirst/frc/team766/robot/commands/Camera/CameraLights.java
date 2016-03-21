package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class CameraLights extends CommandBase{

	private boolean state;
	public CameraLights(boolean on){
	}
	
	protected void initialize() {
		Camera.setCameraLights(state);
		setTimeout(1);
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
