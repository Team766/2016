package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class SetWheels extends CommandBase{

	public SetWheels(double speed){
		Intake.setWheels(speed);
	}
	
	protected void initialize() {
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
	}

}
