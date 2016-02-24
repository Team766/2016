package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;


public class Winch extends CommandBase{

	private final double MIN_ACCEL = -0.5;
	private final double DECELERATION = -.05;
	private final double MIN_POWER = 0.3;
	private final double STOP_THRESHOLD = 2;
	
	private double power = 1.0;
	private boolean done = false;
	
	protected void initialize() {
		if(Catapult.getReadyToFire())
			done = true;
		
		Catapult.firePiston(false);
	}
	
	protected void execute() {
		if(readyToRampDown())
			power += DECELERATION;
		else
			power = 1.0;
		
		if(power <= MIN_POWER)
			power = MIN_POWER;
		
		Catapult.setWinch(power);
	}

	protected boolean isFinished() {
		return done || Math.abs(Catapult.getStopPosition().getNumVal() - Catapult.getRotations()) < STOP_THRESHOLD;
	}

	protected void end() {
		Catapult.setWinch(0.0);
		Catapult.setReadyToFire(true);
	}

	protected void interrupted() {
		Catapult.setWinch(0.0);
		Catapult.setReadyToFire(false);
	}
	
	private double getDistanceToStop(double velocity){
		return Math.pow(velocity, 2) / (-2.0 * MIN_ACCEL);
	}
	
	private boolean readyToRampDown(){
		return Catapult.getStopPosition().getNumVal() - Catapult.getRotations() < RobotValues.Catapult_RotationsToStop;
	}
}
