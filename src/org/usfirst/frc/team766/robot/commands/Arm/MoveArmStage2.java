package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class MoveArmStage2 extends CommandBase{

	private final double THRESHOLD = 7;

	private int angle;
	
	private MoveArmStage2(int angle){
		this.angle = angle;
	}
	
	protected void initialize() {
		Arm.lock(true);
	}

	protected void execute() {
		if(!Arm.isRaised())
			return;
		
		drivePiston();
	}

	protected boolean isFinished() {
		return Math.abs(Arm.getStage2Angle() - angle) < THRESHOLD;
	}
	
	protected void end() {
		Arm.setStageTwo(Value.kOff);
		Arm.lock(false);
	}
	
	protected void interrupted() {
		end();
	}
	
	private void drivePiston(){
		if(Arm.getStage2Angle() - angle < 0)
			Arm.setStageTwo(Value.kForward);
		else if(Arm.getStage2Angle() - angle > 0)
			Arm.setStageTwo(Value.kReverse);
		else
			Arm.setStageTwo(Value.kOff);
	}
}
