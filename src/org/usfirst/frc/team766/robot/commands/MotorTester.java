package org.usfirst.frc.team766.robot.commands;

public class MotorTester extends CommandBase{

	protected void execute() {
		//Drive.setPower(OI.getLeftY());
		//Drive.setLeftPower(OI.getLeftY());
		//Drive.setRightPower(OI.getLeftX());
		
		//Catapult.setWinch(OI.getLeftY());
		
		Intake.setRotationMotor(OI.getLeftY());
		//Intake.setWheels(OI.getLeftX());
	}

	protected void initialize() {
	}

	protected void interrupted() {
	}
	
	protected void end() {
	}

	protected boolean isFinished() {
		return false;
	}

}
