package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class Fire extends CommandBase{
	
	protected void initialize() {
		if(Catapult.getReadyToFire()){
			Catapult.firePiston(true);
		}
		else
			System.out.println("Fire: Catapult not ready to fire");
		setTimeout(1);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut(); //|| !Catapult.getReadyToFire();
	}

	protected void end() {
		Catapult.setReadyToFire(false);
	}

	protected void interrupted() {
		end();
	}
}
