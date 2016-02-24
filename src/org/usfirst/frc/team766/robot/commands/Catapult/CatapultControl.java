package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.lib.Loopable;
import org.usfirst.frc.team766.lib.Looper;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class CatapultControl extends Loopable{

	protected void initilize() {
		
	}

	protected void run() {
		if(CommandBase.Catapult.atTop()){
			CommandBase.Catapult.setReadyToFire(false);
		}
		
		if(CommandBase.Catapult.getReadyToFire()){
			Looper.getInstance().add(new Winch());
		}
		
	}

	protected void end() {
	}

	protected boolean isFinished() {
		return false;
	}

}
