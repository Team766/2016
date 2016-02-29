package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{
	
	private Encoder armEncoder = new Encoder(Ports.DIO_ArmA, Ports.DIO_ArmB);

	private Solenoid firstStage = new Solenoid(Ports.PCM_ARM, Ports.Sol_ArmS1);
	private Solenoid thirdStage = new Solenoid(Ports.PCM_ARM, Ports.Sol_ArmS3);
	
	private DoubleSolenoid secondStage = new DoubleSolenoid(Ports.PCM_ARM, Ports.Sol_ArmS2_Up, Ports.Sol_ArmS2_Down);
	
	protected void initDefaultCommand() {
	}
	
	public void resetEncoder(){
		armEncoder.reset();
	}
	
	public double getStage2Angle(){
		return armEncoder.get() * (256d/360d);
	}
	
	public void extendStage1(boolean a){
		if(secondStageExtended() && armEncoder.get() < RobotValues.ARM_MAX_MID_HEIGHT)
			firstStage.set(a);
	}
	
	public boolean getStage1Extended(){
		return firstStage.get();
	}
	
	public void extendStage3(boolean a){
		if(firstStage.get() && secondStageExtended())
			thirdStage.set(a);
	}
	
	public boolean getStage3Extended(){
		return thirdStage.get();
	}
	
	public void setStageTwo(Value value){
		secondStage.set(value);
	}
	
	public boolean secondStageExtended(){
		return getStage2Angle() > RobotValues.SecondStageThreshold;  
	}
}
