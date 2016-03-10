package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Subsystem for controlling the Catapult
 */
public class Catapult extends Subsystem {
    
	private boolean readyToFire = false;
	private RobotValues.RotationCounts position_ = RobotValues.RotationCounts.Bottom;
	
	Victor winchA;
	Victor winchB;
	
	DoubleSolenoid launch;
	
	Encoder travelDistance;
	DigitalInput atTop; 
	
	public Catapult(){
		winchA = (Victor)DeviceManager.getInstance().getWinchA();
		winchB = (Victor)DeviceManager.getInstance().getWinchB();
		
		launch = DeviceManager.getInstance().getLaunch();
		
		travelDistance = DeviceManager.getInstance().getWhichTravel();
		atTop = DeviceManager.getInstance().getAtTop();
	}
	
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
		return (travelDistance.get() / 256d) * 5.95 * 3.0 * (40.0/35.0);
	}
	
	public void goWinch(){
		setWinch(RobotValues.WINCH_POWER);
	}
	
	public void setWinch(double s){
		winchA.set(s);
		winchB.set(s);
	}
	
	public boolean atTop(){
		return atTop.get();
	}
	
	public void firePiston(boolean fire){
		if(fire)
			launch.set(Value.kForward);
		else
			launch.set(Value.kReverse);
	}
	
    public void initDefaultCommand() {
    }
}

