package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class DriveDistance extends CommandBase{

	private double distance;
	private PIDController drivePID = new PIDController(RobotValues.DriveKp, RobotValues.DriveKi, RobotValues.DriveKd, -1, 1, RobotValues.DriveThreshold);
	
	private PIDController AnglePID = new PIDController(RobotValues.GyroKp,
			RobotValues.GyroKi, RobotValues.GyroKd,
			RobotValues.GyroThreshold);
	
	public DriveDistance(int d){
		distance = d + (Drive.getLeftDistance() + Drive.getRightDistance())/2;
		AnglePID.setSetpoint(Drive.getGyroAngle());
	}
	
	protected void initialize() {
		drivePID.setSetpoint(distance);
		Drive.setShifter(false);
	}

	protected void execute() {
		drivePID.calculate((Drive.getLeftDistance() + Drive.getRightDistance())/2, false);
		AnglePID.calculate(Drive.getGyroAngle(), false);
		
		Drive.setLeftPower(drivePID.getOutput() + AnglePID.getOutput());
		Drive.setRightPower(drivePID.getOutput() - AnglePID.getOutput());
	}

	protected boolean isFinished() {
		return drivePID.isDone();
	}

	protected void end() {
		Drive.setPower(0.0);
	}

	protected void interrupted() {
		end();
	}

}
