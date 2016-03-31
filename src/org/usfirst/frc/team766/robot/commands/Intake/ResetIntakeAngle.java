package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ResetIntakeAngle extends CommandBase{

	/**
	 * Intake should start above ground
	 * 	otherwise use ZeroIntakeAngle
	 */
	
	private int numNoMoves;
	private boolean isFinished;
	private final double VELOCITY_THRESHOLD = 0.4;
	private boolean hasMoved;
	
	protected void initialize() {
		Intake.lockRotation(true);
		
		numNoMoves = 0;
		isFinished = false;
		hasMoved = false;

		Intake.setRawRotationMotor(-0.5);
	}

	protected void execute() {
		
		if(Intake.getVelocity() > VELOCITY_THRESHOLD && !hasMoved)
			hasMoved = true;
		
		if(Math.abs(Intake.getVelocity()) < VELOCITY_THRESHOLD && hasMoved) 
			numNoMoves++;
			
		System.out.println("IntakeAngle:\t" + Intake.getAngle() + "\tIntakeValue:\t" + Intake.getVelocity() + "\tHas Moved:t" + hasMoved);
		
		if (numNoMoves > 25) {
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
