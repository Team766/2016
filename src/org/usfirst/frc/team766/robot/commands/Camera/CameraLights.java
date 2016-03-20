package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class CameraLights extends CommandBase{

	public CameraLights(boolean on){
		Camera.setCameraLights(on);
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
