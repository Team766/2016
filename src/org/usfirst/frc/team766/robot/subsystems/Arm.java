package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{
	
	private Encoder armEncoder = new Encoder(Ports.DIO_ArmA, Ports.DIO_ArmB);
	
	private Solenoid firstStage = new Solenoid(Ports.Sol_Arm1);
	private Solenoid secondStageUp = new Solenoid(Ports.Sol_Arm2Up);
	private Solenoid secondStageDown = new Solenoid(Ports.Sol_Arm2Down);
	private Solenoid thirdStage = new Solenoid(Ports.Sol_Arm3);
	
	private double heightSetpoint;
	private double heightError;
	
	protected void initDefaultCommand() {
	}
	
	public void setHeightError(double error){
		heightError = error;
	}
	
	public boolean armAtPosition(){
		return Math.abs(getHeightError()) < RobotValues.ARM_THRESHOLD;
	}
	
	public double getHeightError(){
		return heightError;
	}
	
	public double getAngleFromHeight(double h){
		return (h - RobotValues.HEIGHT_INITIAL)/RobotValues.ROTATION_TO_HEIGHT_RATIO;
	}

	public double getStage2Angle(){
		return armEncoder.get() * (256d/360d);
	}
	
	public double getArmSetpoint(){
		return heightSetpoint;
	}
	
	public void setArmSetpoint(double point){
		heightSetpoint = point;
	}
	
	public double getHeight(){
		return armEncoder.get() * RobotValues.ROTATIONS_PER_DEGREE + RobotValues.HEIGHT_INITIAL;
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
