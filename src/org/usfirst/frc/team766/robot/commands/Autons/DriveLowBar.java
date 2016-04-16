package org.usfirst.frc.team766.robot.commands.Autons;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveLowBar extends CommandBase{
	
	private PIDController headingPID = new PIDController(RobotValues.GyroKp, RobotValues.GyroKi, RobotValues.GyroKd, RobotValues.GyroThreshold);
	
	private double count = 0;
	private double totalDistance;
	private Timer timer = new Timer();
	
	private double heading;
	private boolean timerStarted;
	private boolean doneWinching;
	
	private double lastTime;
	
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
		
		if(doneWinching && Intake.atAnglePosition()){
			if(!timerStarted){
				timer.start();
				timerStarted = true;
				lastTime = timer.get();
			}
			
			double currTime = timer.get();
			totalDistance += Drive.getAccel() * (0.5 * Math.pow(currTime - lastTime, 2));
			lastTime = currTime;
			
			SmartDashboard.putNumber("HeadingError", heading - Drive.getGyroAngle());
			
			headingPID.calculate(Drive.getGyroAngle(), false);
			
			Drive.setLeftPower(RobotValues.DEAD_RECK_POWER + headingPID.getOutput());
			Drive.setRightPower(RobotValues.DEAD_RECK_POWER - headingPID.getOutput());
			
//			System.out.println("DRIVING!" + ((totalDistance/count) * timer.get()));

			System.out.println(totalDistance);
			count++;
		}
	}

	protected boolean isFinished() {
		//If it hasn't started moving
		return //(timer.get() >= 2.5 && Math.abs(totalDistance/count) < .05) ||
				//Check if it has moved distance
//				(totalDistance >= RobotValues.AUTON_LINE_TO_BACK_DEFENSES);
				(timerStarted && totalDistance*1000 >= 3.5);
	}

	protected void end() {
		Drive.setPower(0.0);
	}

	protected void interrupted() {
		end();
	}

}
