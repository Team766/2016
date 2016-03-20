package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ResetIntakeAngle extends CommandBase{

	private int numNoMoves;
	private boolean isFinished;
	private final double VELOCITY_THRESHOLD = 20;
	
	protected void initialize() {
		Intake.lockRotation(true);
		
		numNoMoves = 0;
		isFinished = false;
		
		Intake.setRotationMotor(-0.25);
	}

	protected void execute() {
		if (Math.abs(Intake.getVelocity()) < VELOCITY_THRESHOLD) {
			numNoMoves++;
		}
		System.out.println("IntakeAngle:\t" + Intake.getAngle() + "\t IntakeValue:\t" + Intake.getVelocity());
		if (numNoMoves > 10) {
			Intake.resetEncoder();
			isFinished = true;
		}
	}

	protected boolean isFinished() {
		return isFinished;
	}

	protected void end() {
		Intake.setAngleSetpoint(RobotValues.INTAKE_FLOOR_ANGLE);
		Intake.setRotationMotor(0.0);
		Intake.lockRotation(false);
	}

	protected void interrupted() {
		end();
	}

}
