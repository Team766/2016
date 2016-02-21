package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.lib.Loopable;
import org.usfirst.frc.team766.lib.Looper;
import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class IntakeControl extends Loopable{

	private PIDController IntakePID = new PIDController(RobotValues.IntakeKp, 
			RobotValues.IntakeKi, RobotValues.IntakeKd, RobotValues.IntakeThreshold);
	
	private double SETPOINT_THRESHOLD = 5d;
	
	protected void initilize() {
		IntakePID.setSetpoint(CommandBase.Intake.getAngleSetpoint());
	}
	
	protected void run() {
		if(Math.abs(CommandBase.Intake.getAngleSetpoint() - IntakePID.getSetpoint()) < SETPOINT_THRESHOLD)
			IntakePID.setSetpoint(CommandBase.Intake.getAngleSetpoint());
		
		IntakePID.calculate(CommandBase.Intake.getAngle(), false);
		
		CommandBase.Intake.setRotationMotor(IntakePID.getOutput());
		
		CommandBase.Intake.setAngleError(IntakePID.getError());
	}

	protected boolean isFinished() {
		return false;
	}
	
	protected void interrupted() {
		end();
	}
	
	protected void end() {
		CommandBase.Intake.setRotationMotor(0.0);
	}

}
