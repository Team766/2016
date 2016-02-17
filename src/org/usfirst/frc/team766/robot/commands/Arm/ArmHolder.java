package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

public class ArmHolder extends CommandBase{

	private PIDController ArmPID = new PIDController(RobotValues.ArmKp,
			RobotValues.ArmKi, RobotValues.ArmKd,-1, 1,RobotValues.ArmThreshold);
	
	private double SETPOINT_THRESHOLD = 5d;
	
	protected void initialize() {
		ArmPID.setSetpoint(Arm.getArmSetpoint());
	}
	
	protected void execute() {
		if(Math.abs(Arm.getArmSetpoint() - ArmPID.getSetpoint()) < SETPOINT_THRESHOLD)
			ArmPID.setSetpoint(Arm.getArmSetpoint());
		
		ArmPID.calculate(Arm.getHeight(), false);
	
		//Arm.setArmPower(ArmPID.getOutput());
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		//Arm.setArmPower(0);
	}

	protected void interrupted() {
		end();
	}
}
