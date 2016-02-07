package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class TankDrive extends CommandBase{
	
	public TankDrive(){
		requires(Drive);
	}

	protected void initialize() {
	}

	protected void execute() {
		Drive.setLeftPower(OI.getLeftY());
		Drive.setRightPower(OI.getRightY());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}

}
