package org.usfirst.frc.team766.robot.commands;

public class MoveArmToHeight extends CommandBase{

	double height;
	
	protected void initialize() {
	}
	
	public MoveArmToHeight(double h){
		height = h;
	}

	protected void execute() {
		if(Arm.getHeight() != height)
			Arm.setArmPower(1);
	}

	protected boolean isFinished() {
		return Arm.getHeight() == height;
	}

	protected void end() {
		Arm.setArmPower(0);
	}

	protected void interrupted() {
		end();
	}
}
