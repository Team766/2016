package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.lib.Loopable;
import org.usfirst.frc.team766.lib.Looper;
import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeControl extends Loopable{

	private PIDController IntakePID = new PIDController(RobotValues.IntakeKp, 
			RobotValues.IntakeKi, RobotValues.IntakeKd, RobotValues.IntakeThreshold);
	
	private double SETPOINT_THRESHOLD = 5d;
	
	protected void initialize() {
		//CommandBase.Intake.resetEncoder();
		IntakePID.setSetpoint(CommandBase.Intake.getAngleSetpoint());
	}
	
	protected void run() {
		IntakePID.setConstants(SmartDashboard.getNumber("Intake P: "), SmartDashboard.getNumber("Intake I: "), SmartDashboard.getNumber("Intake D: "));
		if(CommandBase.Intake.isLocked() || DriverStation.getInstance().isDisabled())
			return;
		
		if(Math.abs(CommandBase.Intake.getAngleSetpoint() - IntakePID.getSetpoint()) > SETPOINT_THRESHOLD)
			IntakePID.setSetpoint(CommandBase.Intake.getAngleSetpoint());
		
		IntakePID.calculate(CommandBase.Intake.getAngle(), false);
		
		CommandBase.Intake.setRotationMotor(IntakePID.getOutput());
		
//		System.out.println("Intake Controller: " + "SetPoint: " + IntakePID.getSetpoint() + "\tAngle: " + CommandBase.Intake.getAngle() + "\tOutput: " + IntakePID.getOutput() + "\tError: " + (CommandBase.Intake.getAngleSetpoint() - CommandBase.Intake.getAngle()));
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
