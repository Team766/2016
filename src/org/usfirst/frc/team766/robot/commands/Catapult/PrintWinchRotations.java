package org.usfirst.frc.team766.robot.commands.Catapult;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class PrintWinchRotations extends CommandBase{

	protected void initialize() {
	}

	protected void execute() {
		System.out.println("Catapult Rotations:\t" + Catapult.getRotations());
		
		Catapult.setWinch(OI.getCatapultAxis());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Catapult.setWinch(0.0);
	}

	protected void interrupted() {
		end();
	}
	
}
