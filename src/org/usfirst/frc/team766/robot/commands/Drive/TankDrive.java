package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class TankDrive extends CommandBase{
	
	public TankDrive(){
		requires(Drive);
	}

	protected void initialize() {
	}

	protected void execute() {
		if(Drive.locked())
			return;
		
		Drive.setLeftPower(OI.getLeftY());
		Drive.setRightPower(OI.getRightY());
		
		Drive.setShifter(OI.getShifter());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Drive.setPower(0.0);
	}

	protected void interrupted() {
		end();
	}

}
