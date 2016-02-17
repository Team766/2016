package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ExtendArmStage1 extends CommandBase{
	
	private boolean lift;

	private ExtendArmStage1(boolean lift){
		this.lift = lift;
	}
	
	protected void initialize() {
		Arm.extendStage1(lift);
	}
	
	protected void execute() {
	
	}

	protected boolean isFinished() {
		return lift == Arm.getStage1Extended();
	}
	
	protected void end() {
		
	}
	
	protected void interrupted() {
		end();
	}
}
