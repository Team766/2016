package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ExtendArmStage3 extends CommandBase{
	
	private boolean lift;
	
	private ExtendArmStage3(boolean lift){
		this.lift = lift;
	}
	
	protected void initialize() {
		Arm.extendStage3(lift);
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return lift == Arm.getStage3Extended();
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		end();
	}
}
