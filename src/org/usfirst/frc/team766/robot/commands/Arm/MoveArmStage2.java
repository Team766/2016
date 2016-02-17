package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class MoveArmStage2 extends CommandBase{

	private int angle;
	
	private MoveArmStage2(int angle){
		this.angle = angle;
	}
	
	protected void initialize() {
		Arm.moveStage2(angle); //0 degrees is straight down, 90 is straight out, goes almost to 180(straight up)
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return Math.abs(Arm.getStage2Angle() - angle) < RobotValues.ARM_THRESHOLD;
	}
	
	protected void end() {
		Arm.holdStage2();
	}
	
	protected void interrupted() {
		end();
	}
}
