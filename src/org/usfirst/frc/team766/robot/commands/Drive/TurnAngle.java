package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class TurnAngle extends CommandBase{

	private PIDController anglePID = new PIDController(RobotValues.AngleKp, 
			RobotValues.AngleKi, RobotValues.AngleKd, RobotValues.AngleThreshold);

	public TurnAngle(double angle){
		anglePID.setSetpoint(Drive.getGyroAngle() + angle);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		anglePID.calculate(Drive.getGyroAngle(), false);
		Drive.setLeftPower(anglePID.getOutput());
		Drive.setRightPower(-anglePID.getOutput());
	}

	protected void interrupted() {
		end();
	}
	
	protected void end() {
		Drive.setPower(0.0);
	}

	protected boolean isFinished() {
		return anglePID.isDone();
	}

}
