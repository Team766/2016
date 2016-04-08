package org.usfirst.frc.team766.robot.commands.Autons;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveObstical extends CommandBase{
	
	private PIDController headingPID = new PIDController(RobotValues.GyroKp, RobotValues.GyroKi, RobotValues.GyroKd, RobotValues.GyroThreshold);
	
	private double count = 0;
	private double totalVelocity;
	private Timer timer = new Timer();
	
	private double heading;
	private boolean timerStarted;
	private boolean doneWinching;
	
	protected void initialize() {
		headingPID.setConstants(RobotValues.GyroKp, RobotValues.GyroKi, RobotValues.GyroKd);
		timer.reset();
		
		heading = Drive.getGyroAngle();
		
		headingPID.setSetpoint(heading);
//		timer.start();
		timerStarted = false;
		doneWinching = false;
		Catapult.setReadyToFire(false);
	}

	protected void execute() {
		
		if(Catapult.getReadyToFire()){
			Intake.setAngleSetpoint(RobotValues.INTAKE_STORE_ANGLE);
			doneWinching = true;
		}
		
		if(Catapult.getReadyToFire() && Intake.atAnglePosition()){
			if(!timerStarted){
				timer.start();
				timerStarted = true;
			}
			
			totalVelocity += Drive.getAccel();
			
			SmartDashboard.putNumber("HeadingError", heading - Drive.getGyroAngle());
			
			headingPID.calculate(Drive.getGyroAngle(), false);
			
			Drive.setLeftPower(RobotValues.DEAD_RECK_POWER - headingPID.getOutput());
			Drive.setRightPower(RobotValues.DEAD_RECK_POWER + headingPID.getOutput());
	
			count++;
		}
	}

	protected boolean isFinished() {
		//If it hasn't started moving
		return //(timer.get() >= 2.5 && Math.abs(totalVelocity/count) < .05) ||
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
