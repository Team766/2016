package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class TrackTarget extends CommandBase{
	
	private PIDController yPID;
	
	private double verticalAngle = 90;
	
	private double lastAngle = 0;

	protected void initialize() {
		 yPID = new PIDController(.01,0,0,-180, 180, 5);
		 
		 yPID.setSetpoint(0.0);
		 
		 Camera.setVerticalAngle(verticalAngle);
	}

	protected void execute() {
		yPID.calculate(Camera.getYError(), false);
		
		if(Math.abs(Camera.getAngleError()) > 2 && Math.abs(lastAngle - Camera.getAngleError()) > 5){
			Camera.setVerticalAngle(Camera.getVerticalAngle() + Camera.getAngleError());
//			System.out.println("Angle: " + Camera.getVerticalAngle() + " + " + Camera.getAngleError());
			lastAngle = Camera.getAngleError();
		}else
			Camera.setVerticalAngle(Camera.getVerticalAngle() - yPID.getOutput());
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}