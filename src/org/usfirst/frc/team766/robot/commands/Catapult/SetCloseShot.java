package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class SetCloseShot extends CommandBase{
	
	private boolean state;
	
	public SetCloseShot(boolean close){
		state = close;
	}
	
	protected void initialize() {
		if(!state)
			Camera.setVerticalAngle(80);//130
		else
			Camera.setVerticalAngle(165);
		Catapult.closeShot(state);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Catapult.closeShot(!state);
	}

	protected void interrupted() {
		end();
	}

}
