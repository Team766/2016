package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class Pivot extends CommandBase{

	private PIDController PivotPID = new PIDController(RobotValues.DriveKp, RobotValues.DriveKi, RobotValues.DriveKd, 1, -1, RobotValues.DriveThreshold);
	
	protected void initialize() {
		Drive.resetGyro();
		PivotPID.setSetpoint(180);
	}

	protected void execute() {
		PivotPID.calculate(Drive.getGyroAngle(), false);
		Drive.setRightPower(PivotPID.getOutput());
		Drive.setLeftPower(-PivotPID.getOutput());
	}

	protected boolean isFinished() {
		return PivotPID.isDone();
	}
	
	protected void end() {
		Drive.setPower(0.0);
	}
	
	protected void interrupted() {
		end();
	}
}
