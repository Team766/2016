package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class MoveIntake extends CommandBase{
	
	private double angle;
	
	public MoveIntake(double angle){
		this.angle = angle;
	}
	
	protected void initialize() {	
		Intake.lockRotation(false);
		Intake.setAngleSetpoint(angle);
	}
	
	protected void execute() {
	}

	protected void interrupted() {
		end();
	}
	
	protected void end() {
	}

	protected boolean isFinished() {
		return Intake.atAnglePosition();
	}

}
