package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{
	
	private Encoder armEncoder;

	private Solenoid firstStage;
	private Solenoid thirdStage;
	
	private DoubleSolenoid secondStage;
	
	public Arm(){
		armEncoder = (Encoder)DeviceManager.getInstance().getArmEncoder();
		firstStage = DeviceManager.getInstance().getFirstStage();
		secondStage = DeviceManager.getInstance().getSecondStage();
		thirdStage = DeviceManager.getInstance().getThirdStage();
	}
	
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
