package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class CheesyDrive extends CommandBase{

	public CheesyDrive(){
		requires(Drive);
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		Drive.setPower(OI.getLeftY());
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
