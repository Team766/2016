package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.lib.Loopable;
import org.usfirst.frc.team766.lib.Looper;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;

public class CatapultControl extends Loopable{
	
	protected void initialize() {
	}

	protected void run() {
		if(DriverStation.getInstance().isDisabled())
			return;
		
		if(!CommandBase.Catapult.getReadyToFire() && 
			!CommandBase.Catapult.isWinching() && 
			CommandBase.Intake.getAngle() < RobotValues.IntakeCollisionAngle){
			
			Looper.getInstance().add(new Winch());
		}
		
	}

	protected void end() {
	}

	protected boolean isFinished() {
		return false;
	}

}
