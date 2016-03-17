package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ManualIntakeControl extends CommandBase{
	
	private final double JOYSTICK_TO_ANGLE = 1.0;
	
	protected void initialize() {
	}

	protected void execute() {
		Intake.setAngleSetpoint(Intake.getAngleSetpoint() + (OI.getIntakeJoystick() * JOYSTICK_TO_ANGLE));
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

}
