package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class DriveDistance extends CommandBase{

	private double distance;
	private PIDController drivePID = new PIDController(RobotValues.DriveKp, RobotValues.DriveKi, RobotValues.ArmKd, -1, 1, RobotValues.DriveThreshold);
	
	public DriveDistance(int d){
		distance = d + (Drive.getLeftDistance() + Drive.getRightDistance())/2;
	}
	
	protected void initialize() {
		drivePID.setSetpoint(distance);
	}

	protected void execute() {
		drivePID.calculate((Drive.getLeftDistance() + Drive.getRightDistance())/2, false);
		Drive.setPower(drivePID.getOutput());
	}

	protected boolean isFinished() {
		return drivePID.isDone();
	}

	protected void end() {
		Drive.setLeftPower(0.0);
		Drive.setRightPower(0.0);
	}

	protected void interrupted() {
		end();
	}

}
