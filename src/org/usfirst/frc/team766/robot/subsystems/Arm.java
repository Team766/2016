package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem{

	//Motor
	Victor arm = new Victor(Ports.PWM_ARM);
	
	//Encoder
	Encoder armEncoder = new Encoder(0, 0);
	
	protected void initDefaultCommand() {
	}
	
	public double getAngleFromHeight(double h){
		return (h - RobotValues.HEIGHT_INITIAL)/RobotValues.ROTATION_TO_HEIGHT_RATIO;
	}

	public double getAngle(){
		return armEncoder.get() * (256d/360d);
	}
	
	public double getHeight(){
		return armEncoder.get() * RobotValues.ROTATIONS_PER_DEGREE + RobotValues.HEIGHT_INITIAL;
	}
	
	public void setArmPower(double power){
		arm.set(power);
	}
}
