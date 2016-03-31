package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ZeroIntakeAngle extends CommandBase{
	
	private double intakeAngle;

	protected void initialize() {
		intakeAngle = Intake.getAngle();
		Intake.resetEncoder();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Intake.getAngle() != intakeAngle;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}

}
