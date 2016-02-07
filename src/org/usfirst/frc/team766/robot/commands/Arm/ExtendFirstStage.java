package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ExtendFirstStage extends CommandBase{

	private boolean extend;
	
	public ExtendFirstStage(boolean extend){
		this.extend = extend;
	}
	
	protected void initialize() {
		Arm.extendStage1(extend);
		setTimeout(1.0);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
