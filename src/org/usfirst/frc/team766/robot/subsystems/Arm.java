package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{

	Victor arm = new Victor(Ports.PWM_ARM);
	
	Encoder armEncoder = new Encoder(Ports.DIO_ArmA, Ports.DIO_ArmB);
	
	Solenoid firstStage = new Solenoid(Ports.Sol_ArmS1);
	
	private double heightSetpoint;
	private double heightError;
	
	protected void initDefaultCommand() {
	}
	
	public void setHeightError(double error){
		heightError = error;
	}
	
	public boolean armAtPosition(){
		return Math.abs(getHeightError()) < RobotValues.ArmThreshold;
	}
	
	public double getHeightError(){
		return heightError;
	}
	
	public double getAngleFromHeight(double h){
		return (h - RobotValues.HEIGHT_INITIAL)/RobotValues.ROTATION_TO_HEIGHT_RATIO;
	}

	public double getAngle(){
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
	
	public void setArmPower(double power){
		if(getStage1Extended())
			arm.set(power);
		else
			System.out.println("Arm: Extend stage 1 before moving arm");
	}
	
	public void extendStage1(boolean a){
		firstStage.set(a);
	}
	
	public boolean getStage1Extended(){
		return firstStage.get();
	}
}