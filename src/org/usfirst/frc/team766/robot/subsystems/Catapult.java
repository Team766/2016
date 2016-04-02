package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	
	Victor winchA;
	Victor winchB;
	
	DoubleSolenoid launch;
	Solenoid closeShot;
	
	Encoder travelDistance;
	DigitalInput atBottom; 
	
	private boolean winching;
	
	public Catapult(){
		winchA = (Victor)DeviceManager.getInstance().getWinchA();
		winchB = (Victor)DeviceManager.getInstance().getWinchB();
		
		launch = DeviceManager.getInstance().getLaunch();
		closeShot = DeviceManager.getInstance().getCloseShot();
		
		travelDistance = (Encoder)DeviceManager.getInstance().getWinchTravel();
		atBottom = DeviceManager.getInstance().getAtBottom();
		
		setWinching(false);
	}
	
	public RobotValues.RotationCounts getStopPosition(){
		return position_;
	}
	
	public void setStopPosition(RobotValues.RotationCounts position){
		position_ = position;
	}
	
	public boolean getReadyToFire(){
		return readyToFire && CommandBase.Intake.getAngle() < RobotValues.IntakeCollisionAngle;
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
		winchA.set(-s);
		winchB.set(-s);
	}
	
	public boolean atBottom(){
		return atBottom.get();
	}
	
	public void firePiston(boolean fire){
		if(!fire)
			launch.set(Value.kForward);
		else
			launch.set(Value.kReverse);
	}
	
	public void closeShot(boolean close){
		closeShot.set(close);
	}
	
    public void initDefaultCommand() {
    }

	public boolean isWinching() {
		return winching;
	}

	public void setWinching(boolean winching) {
		this.winching = winching;
	}
	
	public double[] firingDistances(double currVelocity){
		double[] out = new double[2];
		out[0] = ((RobotValues.INITIAL_LAUNCH_VELOCITY*Math.sin(Math.toRadians(RobotValues.LAUNCH_ANGLE)) + Math.sqrt(Math.pow(RobotValues.INITIAL_LAUNCH_VELOCITY*Math.sin(Math.toRadians(RobotValues.LAUNCH_ANGLE)),2) + 2*RobotValues.GRAVITATIONAL_STRENGTH*(RobotValues.INITIAL_BALL_HEIGHT-RobotValues.TOWER_HEIGHT)))*(RobotValues.INITIAL_LAUNCH_VELOCITY*Math.cos(Math.toRadians(RobotValues.LAUNCH_ANGLE))+currVelocity))/(-RobotValues.GRAVITATIONAL_STRENGTH);
		out[1] = ((RobotValues.INITIAL_LAUNCH_VELOCITY*Math.sin(Math.toRadians(RobotValues.LAUNCH_ANGLE)) - Math.sqrt(Math.pow(RobotValues.INITIAL_LAUNCH_VELOCITY*Math.sin(Math.toRadians(RobotValues.LAUNCH_ANGLE)),2) + 2*RobotValues.GRAVITATIONAL_STRENGTH*(RobotValues.INITIAL_BALL_HEIGHT-RobotValues.TOWER_HEIGHT)))*(RobotValues.INITIAL_LAUNCH_VELOCITY*Math.cos(Math.toRadians(RobotValues.LAUNCH_ANGLE))+currVelocity))/(-RobotValues.GRAVITATIONAL_STRENGTH);
		return out;
	}
	
	public double maxHeight(){
		return (Math.pow(RobotValues.INITIAL_LAUNCH_VELOCITY * Math.sin(Math.toRadians(RobotValues.LAUNCH_ANGLE)), 2)/(2*RobotValues.GRAVITATIONAL_STRENGTH))+RobotValues.INITIAL_LAUNCH_VELOCITY;
	}
	
	public double posOfMaxHeight(double currVelocity){
		return ((RobotValues.INITIAL_LAUNCH_VELOCITY*Math.cos(Math.toRadians(RobotValues.LAUNCH_ANGLE)) + currVelocity)*(RobotValues.INITIAL_LAUNCH_VELOCITY*Math.sin(Math.toRadians(RobotValues.LAUNCH_ANGLE))))/RobotValues.GRAVITATIONAL_STRENGTH;
	}
}

