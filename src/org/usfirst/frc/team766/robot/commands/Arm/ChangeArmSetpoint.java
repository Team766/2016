package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ChangeArmSetpoint extends CommandBase{

	private double setPoint;
	
	public ChangeArmSetpoint(double point){
		setPoint = point;
	}
	
	protected void initialize() {
		Arm.setArmSetpoint(setPoint);
	}

	protected void execute() {
		System.out.println("Moving arm to position");
	}

	protected boolean isFinished() {
		return Arm.armAtPosition();
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
