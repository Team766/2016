package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

/**
 * Waits for robot to be in the correct position for firing
 * 
 * @author blevenson
 *
 */

public class InFirePosition extends CommandBase{
	
	private final double THRESHOLD = 0.06;
	
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Math.abs(Camera.getDistance() - Catapult.firingDistances(Drive.getAccel())[0]) < THRESHOLD ||
			   Math.abs(Camera.getDistance() - Catapult.firingDistances(Drive.getAccel())[1]) < THRESHOLD ||
			   Math.abs(Camera.getDistance() - RobotValues.FIRE_DISTANCE) < THRESHOLD;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

}
