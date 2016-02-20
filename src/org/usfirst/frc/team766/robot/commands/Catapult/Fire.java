package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class Fire extends CommandBase{
	
	private boolean done;
	private int count;

	protected void initialize() {
		count = 0;
		done = false;
		//MoveIntake(RobotValues.INTAKE_STRAIGHTUP_ANGLE);
	}

	protected void execute() {
		if(Catapult.getReadyToFire()){
			Catapult.firePiston(true);
			if(count >= 100)
				done = true;
			count++;
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		Catapult.setReadyToFire(false);
	}

	protected void interrupted() {
		end();
	}
}
