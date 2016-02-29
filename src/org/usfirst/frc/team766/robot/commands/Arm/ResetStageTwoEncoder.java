package org.usfirst.frc.team766.robot.commands.Arm;

import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ResetStageTwoEncoder extends CommandBase{

	private boolean done;
	protected void initialize() {
		done = false;
		Arm.setStageTwo(Value.kReverse);
		
		try{
			Thread.sleep(1500);
		}catch(Exception e){}
		
		Arm.resetEncoder();
		done = true;
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		Arm.setStageTwo(Value.kOff);
	}

	protected void interrupted() {
		end();
	}

}
