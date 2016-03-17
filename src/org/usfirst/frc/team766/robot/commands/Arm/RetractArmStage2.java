package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RetractArmStage2 extends CommandBase{

	public RetractArmStage2(boolean retract){
		Arm.lock(true);
		
		if(retract)
			Arm.setStageTwo(Value.kReverse);
		else
			Arm.setStageTwo(Value.kForward);
		
		setTimeout(1.0);
	}
	
	protected void initialize() {
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return !Arm.secondStageExtended();
	}

	protected void end() {
		Arm.setStageTwo(Value.kOff);
		Arm.lock(false);
	}

	protected void interrupted() {
		end();
	}

}
