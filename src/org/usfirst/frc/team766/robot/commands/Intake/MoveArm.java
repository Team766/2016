package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class MoveArm extends CommandBase{

	public MoveArm(double angle){
		Intake.setAngleSetpoint(angle);
	}
	
	protected void initialize() {	
	}
	
	protected void execute() {
	}

	protected void interrupted() {
		Intake.setAngleSetpoint(RobotValues.DEFAULT_ANGLE);
	}
	
	protected void end() {
	}

	protected boolean isFinished() {
		return Intake.atAnglePosition();
	}

}
