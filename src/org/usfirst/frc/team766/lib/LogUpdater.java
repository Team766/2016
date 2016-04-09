package org.usfirst.frc.team766.lib;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class LogUpdater extends CommandBase{
	
	private long startTime;
	private final long TIME_INTERVAL = (long)5000.0;

	protected void initialize() {
		startTime = System.currentTimeMillis();
	}

	protected void execute() {
		if(System.currentTimeMillis() - startTime >= TIME_INTERVAL){
			
			LogFactory.getInstance("General").print("Drive: Gyro Angle Degrees = " + Drive.getGyroAngle());
			LogFactory.getInstance("General").print("Drive: Gyro Angle Radians = " + Drive.getGyroAngleRadians());
			LogFactory.getInstance("General").print("Drive: Left Encoder = " + Drive.getLeftDistance());
			LogFactory.getInstance("General").print("Drive: Right Encoder = " + Drive.getRightDistance());
			LogFactory.getInstance("General").print("Drive: Left Velocity = " + Drive.getLeftVelocity());
			LogFactory.getInstance("General").print("Drive: Right Velocity = " + Drive.getRightVelocity());
			LogFactory.getInstance("General").print("Drive: Acceleration = " + Drive.getAccel());
			LogFactory.getInstance("General").print("Drive: Left Voltage = " + Drive.getLeftVoltage());
			LogFactory.getInstance("General").print("Drive: Right Voltage = " + Drive.getRightVoltage());

			LogFactory.getInstance("General").print("Intake: Angle Degrees = " + Intake.getAngle());
			LogFactory.getInstance("General").print("Intake: Angle Setpoint = " + Intake.getAngleSetpoint());
			LogFactory.getInstance("General").print("Intake: Height = " + Intake.getHeight());
			LogFactory.getInstance("General").print("Intake: Angle Error = " + Intake.getAngleError());
			LogFactory.getInstance("General").print("Intake: Velocity = " + Intake.getVelocity());

			LogFactory.getInstance("General").print("Catapult: Rotations = " + Catapult.getRotations());
			
			startTime = System.currentTimeMillis();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

}
