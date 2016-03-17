package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class MoveIntake extends CommandBase{

	public MoveIntake(double angle){
		Intake.setAngleSetpoint(angle);
	}
	
	protected void initialize() {	
	}
	
	protected void execute() {
	}

	protected void interrupted() {
	}
	
	protected void end() {
	}

	protected boolean isFinished() {
		return Intake.atAnglePosition();
	}

}
