package org.usfirst.frc.team766.robot.commands.Autons;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

public class DriveObstical extends CommandBase{
	
	private PIDController headingPID = new PIDController(RobotValues.GyroKp, RobotValues.GyroKi, RobotValues.GyroKd, RobotValues.GyroThreshold);
	
	private double count = 0;
	private double totalVelocity;
	private Timer timer = new Timer();
	
	protected void initialize() {
		timer.reset();
		
		headingPID.setSetpoint(Drive.getGyroAngle());
		timer.start();
	}

	protected void execute() {
		totalVelocity += Drive.getAccel();
		
		headingPID.calculate(Drive.getGyroAngle(), false);
		
		Drive.setLeftPower(RobotValues.DEAD_RECK_POWER - headingPID.getOutput());
		Drive.setRightPower(RobotValues.DEAD_RECK_POWER + headingPID.getOutput());
		
		count++;
	}

	protected boolean isFinished() {
		//If it hasn't started moving
		return (timer.get() >= 2.5 && Math.abs(totalVelocity/count) < .05) ||
				//Check if it has moved distance
				(((totalVelocity/count) * timer.get()) >= RobotValues.AUTON_LINE_TO_BACK_DEFENSES);
	}

	protected void end() {
		Drive.setPower(0.0);
	}

	protected void interrupted() {
		end();
	}

}
