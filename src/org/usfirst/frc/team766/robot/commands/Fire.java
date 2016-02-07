package org.usfirst.frc.team766.robot.commands;

public class Fire extends CommandBase{
	
	private boolean done;
	private int count;

	protected void initialize() {
		count = 0;
		done = false;
	}

	protected void execute() {
		if(Catapult.getReadyToFire()){
			Catapult.releasePiston();
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
