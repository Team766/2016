package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{
	
	private Encoder armEncoder = new Encoder(Ports.DIO_ArmA, Ports.DIO_ArmB);

	Solenoid firstStage = new Solenoid(Ports.Sol_ArmS1);
	Solenoid thirdStage = new Solenoid(Ports.Sol_ArmS3);
	
	Solenoid secondStageUp = new Solenoid(Ports.Sol_ArmS2_Up);
	Solenoid secondStageDown = new Solenoid(Ports.Sol_ArmS2_Down);
	
	protected void initDefaultCommand() {
	}
	
	public double getStage2Angle(){
		return armEncoder.get() * (256d/360d);
	}
	
	public void extendStage1(boolean a){
		if(armEncoder.get() > RobotValues.ARM_THRESHOLD && armEncoder.get() < RobotValues.ARM_MAX_MID_HEIGHT)
			firstStage.set(a);
	}
	
	public boolean getStage1Extended(){
		return firstStage.get();
	}
	
	public void extendStage3(boolean a){
		if(firstStage.get() && getSecondStage())
			thirdStage.set(a);
	}
	
	public boolean getStage3Extended(){
		return thirdStage.get();
	}
	
	public void moveStage2(int a){
		if(a < armEncoder.get()){
			secondStageUp.set(true);
			secondStageDown.set(false);
		}
		else if(a > armEncoder.get()){
			secondStageUp.set(false);
			secondStageDown.set(true);
		}
	}
	
	public void holdStage2(){
		secondStageUp.set(false);
		secondStageDown.set(false);
	}
	
	public boolean getSecondStage(){
		return armEncoder.get() > RobotValues.ARM_THRESHOLD;
	}
	
	public void extendArm(){
		moveStage2(RobotValues.SALLYPORT_ANGLE);
		firstStage.set(true);
		moveStage2(RobotValues.STAGE2MAX_ANGLE);
		thirdStage.set(true);
	}
	
	public void collapseArm(){
		thirdStage.set(false);
		moveStage2(RobotValues.SALLYPORT_ANGLE);
		firstStage.set(false);
		moveStage2(0);
	}
}
