package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.lib.Loopable;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;


public class Winch extends Loopable{

	private final double WINCHING_TIME = 6.75; //seconds
	
	private final double MIN_ACCEL = -0.5;
	private final double DECELERATION = -.05;
	private final double MIN_POWER = 0.3;
	private final double STOP_THRESHOLD = 2;
	
	private double power = 1.0;
	private boolean done = false;
	private long startTime = 0;
	
	protected void initialize() {
		if(CommandBase.Catapult.getReadyToFire())
			done = true;
		
		startTime = System.currentTimeMillis();
		
		CommandBase.Catapult.firePiston(false);
		
		CommandBase.Catapult.setWinching(true);
	}
	
	protected void run() {
//		if(readyToRampDown())
//			power += DECELERATION;
//		else
//			power = 1.0;
//		
//		if(power <= MIN_POWER)
//			power = MIN_POWER;
		
		CommandBase.Catapult.setWinch(RobotValues.WINCH_POWER);
	}

	protected boolean isFinished() {
		return (System.currentTimeMillis() - startTime) / 1000d >= WINCHING_TIME; //in seconds
		//return done || Math.abs(CommandBase.Catapult.getStopPosition().getNumVal() - CommandBase.Catapult.getRotations()) < STOP_THRESHOLD;
	}

	protected void end() {
		CommandBase.Catapult.setWinch(0.0);
		CommandBase.Catapult.setReadyToFire(true);
		CommandBase.Catapult.setWinching(false);
	}

	protected void interrupted() {
		CommandBase.Catapult.setWinch(0.0);
		CommandBase.Catapult.setReadyToFire(false);
		CommandBase.Catapult.setWinching(false);
	}
	
	private double getDistanceToStop(double velocity){
		return Math.pow(velocity, 2) / (-2.0 * MIN_ACCEL);
	}
	
	private boolean readyToRampDown(){
		return CommandBase.Catapult.getStopPosition().getNumVal() - CommandBase.Catapult.getRotations() < RobotValues.Catapult_RotationsToStop;
	}

}
