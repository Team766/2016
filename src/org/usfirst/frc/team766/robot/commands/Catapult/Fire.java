package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class Fire extends CommandBase{
	
	private boolean done;
	private int count;

	protected void initialize() {
		count = 0;
		done = false;
		Intake.setAngleSetpoint(RobotValues.INTAKE_STRAIGHTUP_ANGLE);
	}

	protected void execute() {
		//Winched Back
		if(Catapult.getReadyToFire()){
			Catapult.firePiston(true);
//			if(count >= 100)
//				done = true;
//			count++;
		}
	}

	protected boolean isFinished() {
		return Catapult.atTop() || !Catapult.getReadyToFire();
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
