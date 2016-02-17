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
	
	Victor winch = new Victor(Ports.PWM_Winch);
	Solenoid launch = new Solenoid(Ports.Sol_Fire);
	Encoder travelDistance = new Encoder(Ports.DIO_WinchA, Ports.DIO_WinchB);
	DigitalInput sensor = new DigitalInput(Ports.DIO_HallEffectSensorWinch); 
	
	public boolean getReadyToFire(){
		return readyToFire;
	}
	
	public void setReadyToFire(boolean x){
		readyToFire = x;
	}
	
	public void goWinch(){
		winch.set(RobotValues.WINCH_POWER);
	}
	
	public void setWinch(double s){
		winch.set(s);
	}
	
	public boolean sensorDown(){
		return sensor.get();
	}
	
	public void releasePiston(){
		launch.set(RobotValues.PIST_OUT);
	}
	
    public void initDefaultCommand() {
    }
}

