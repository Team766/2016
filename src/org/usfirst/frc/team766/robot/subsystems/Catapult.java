package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Subsystem for controlling the Catapult
 */
public class Catapult extends Subsystem {
    
	private boolean readyToFire = false;
	private RobotValues.RotationCounts position_ = RobotValues.RotationCounts.Bottom;
	
	Victor winchA = new Victor(Ports.PWM_Winch1);
	Victor winchB = new Victor(Ports.PWM_Winch2);
	Solenoid launch = new Solenoid(Ports.Sol_Fire);
	Encoder travelDistance = new Encoder(Ports.DIO_WinchA, Ports.DIO_WinchB);
	DigitalInput atTop = new DigitalInput(Ports.DIO_HallEffectSensorWinch); 
	
	
	public RobotValues.RotationCounts getStopPosition(){
		return position_;
	}
	
	public void setStopPosition(RobotValues.RotationCounts position){
		position_ = position;
	}
	
	public boolean getReadyToFire(){
		return readyToFire;
	}
	
	public void setReadyToFire(boolean x){
		readyToFire = x;
	}
	
	public double getRotations(){
		return travelDistance.get() / 256d;
	}
	
	public void goWinch(){
		winchA.set(RobotValues.WINCH_POWER);
		winchB.set(RobotValues.WINCH_POWER);
	}
	
	public void setWinch(double s){
		winchA.set(s);
		winchB.set(s);
	}
	
	public boolean atTop(){
		return atTop.get();
	}
	
	public void firePiston(boolean fire){
		launch.set(RobotValues.SOL_FIRE);
	}
	
    public void initDefaultCommand() {
    }
}

