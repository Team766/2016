package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class IntakeHolder extends CommandBase{

	private PIDController IntakePID = new PIDController(RobotValues.IntakeKp, 
			RobotValues.IntakeKi, RobotValues.IntakeKd, RobotValues.IntakeThreshold);
	
	private double SETPOINT_THRESHOLD = 5d;
	
	protected void initialize() {
		IntakePID.setSetpoint(Intake.getAngleSetpoint());
	}
	
	protected void execute() {
		if(Math.abs(Intake.getAngleSetpoint() - IntakePID.getSetpoint()) < SETPOINT_THRESHOLD)
			IntakePID.setSetpoint(Intake.getAngleSetpoint());
		
		IntakePID.calculate(Intake.getAngle(), false);
		
		Intake.setRotationMotor(IntakePID.getOutput());
		
		Intake.setAngleError(IntakePID.getError());
	}

	protected boolean isFinished() {
		return false;
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Intake.setRotationMotor(0.0);
	}

}
