package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

/*
 * Drive the robot into the correct distance using the camera to change the heading
 */
public class FollowTarget extends CommandBase{
	PIDController pidY = new PIDController(RobotValues.DriveKp, RobotValues.DriveKi, RobotValues.DriveKd, RobotValues.DriveThreshold);
	PIDController pidX = new PIDController(RobotValues.CameraKp, RobotValues.CameraKi, RobotValues.CameraKd, RobotValues.CameraThreshold);
	
	protected void initialize() {
		Drive.lock(true);
		
		pidY.setSetpoint(RobotValues.FIRE_DISTANCE);
		pidX.setSetpoint(0);
	}

	protected void execute() {
		pidY.calculate(Camera.getDistance(), false);
		pidX.calculate(Camera.getXError(), false);
		
		Drive.setLeftPower(pidY.getOutput() - pidX.getOutput());
		Drive.setRightPower(pidY.getOutput() + pidX.getOutput());
	}

	protected boolean isFinished() {
		return pidY.isDone() && pidX.isDone();
	}

	protected void end() {
		Drive.lock(false);
	}

	protected void interrupted() {
		end();
	}

}
