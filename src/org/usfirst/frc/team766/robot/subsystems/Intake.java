package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the Intake
 */
public class Intake extends Subsystem {
    
	private final double REDUCTION = 3.0;
	private final double startingAngle = 180.0;//getAngleFromHeight(0);
	
    private Victor wheels;
    private VictorSP rotator;

    private Encoder intakeAngle;
    
    private double angleSetpoint;
    
    private boolean lockRotation;
    
    public Intake(){
    	wheels = (Victor)DeviceManager.getInstance().getIntakeWheels();
    	rotator = (VictorSP)DeviceManager.getInstance().getRotatorWheels();
    	
    	intakeAngle = (Encoder)DeviceManager.getInstance().getIntakeAngle();
    	
    	//Meters per pulse
    	intakeAngle.setDistancePerPulse(0.0087);
    	lockRotation = false;
    	
    	setAngleSetpoint(180.0);
    	//setAngleSetpoint(getAngleFromHeight(0));
    }
    
    public void initDefaultCommand() {	
    }
    
    public void setWheels(double s){
    	wheels.set(s);
    }

    public void setRotationMotor(double s){
    	if(getAngle() < getAngleFromHeight(0) && s < 0 && !lockRotation){
    		s = 0;
    		System.out.println("Intake: Angle too low");
    	}
    	
    	//Clamp speed for Intake
    	if(s > 0.5)
    		s = 0.5;
    	else if(s < -0.5)
    		s = -0.5;
    	    	
    	setRawRotationMotor(s);
    }
    
    public void setRawRotationMotor(double s){
    	rotator.set(-s);
    }

    public double getAngle(){
    	return (intakeAngle.get() * (360d/(1024.0*REDUCTION))) + startingAngle;
    }

	public double getAngleSetpoint() {
		return angleSetpoint;
	}

	public void setAngleSetpoint(double angleSetpoint) {
		this.angleSetpoint = angleSetpoint;
	}
	
	public boolean atAnglePosition(){
		return Math.abs(getAngleError()) < RobotValues.IntakeThreshold;
	}
	
	//Meters off the ground
	public double getHeight(){
		return .289 - .314*Math.cos(getAngle());
	}
	
	public static double getAngleFromHeight(double height){
		return Math.toDegrees(Math.acos((.3 - height)/.314));
	}

	public double getAngleError() {
		return angleSetpoint - getAngle();
	}

	public void resetEncoder(){
		intakeAngle.reset();
	}

	public double getVelocity() {
		return intakeAngle.getRate();
	}
	
	public void lockRotation(boolean lock){
		lockRotation = lock;
	}
	
	public boolean isLocked(){
		return lockRotation;
	}
}
