package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ManualAdjustment extends CommandBase{

	private final double THRESHOLD = 0.5;
	
	protected void initialize() {
	}

	protected void execute() {
		if(Arm.isLocked() || !Arm.isRaised())
			return;
		
		if(OI.getArmJoystick() > THRESHOLD)
			Arm.setStageTwo(Value.kForward);
		else if(OI.getArmJoystick() < -THRESHOLD)
			Arm.setStageTwo(Value.kReverse);
		else
			Arm.setStageTwo(Value.kOff);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Arm.setStageTwo(Value.kOff);
	}

	protected void interrupted() {
		end();
	}

}
