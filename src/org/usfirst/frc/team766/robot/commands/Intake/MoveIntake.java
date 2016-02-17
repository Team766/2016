package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class MoveIntake extends CommandBase{

	private double angle;
	private PIDController IntakePID = new PIDController(RobotValues.IntakeKp, RobotValues.IntakeKi, RobotValues.IntakeKd, 1, -1, RobotValues.IntakeThreshold);
	
	private MoveIntake(double angle){
		this.angle = angle;
	}
	
	protected void initialize() {
		IntakePID.setSetpoint(angle);
	}

	protected void execute() {
		IntakePID.calculate(Intake.getIntakeAngle(), false);
		Intake.setMechanismMotor(IntakePID.getOutput());
	}

	protected boolean isFinished() {
		return IntakePID.isDone();
	}
	
	protected void end() {
		Intake.setMechanismMotor(0);
	}
	
	protected void interrupted() {
		end();
	}
}
