package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the Intake
 */
public class Intake extends Subsystem {
    
    private Victor wheels = new Victor(Ports.PWM_IntakeWheels);
    private Victor rotator = new Victor(Ports.PWM_IntakeRotator);

    private Encoder intakeAngle = new Encoder(Ports.DIO_IntakeA, Ports.DIO_IntakeB);
    
    private double angleSetpoint;
    private double angleError;
    
    private boolean lockRotation;
    
    public Intake(){
    	//Meters per pulse
    	intakeAngle.setDistancePerPulse(0.0087);
    	lockRotation = false;
    }
    
    public void initDefaultCommand() {	
    }
    
    public void setWheels(double s){
    	wheels.set(s);
    }

    public void setRotationMotor(double s){
    	if(getAngle() < 52.4){
    		s = 0;
    		System.out.println("Intake: Angle too low");
    	}
    	rotator.set(s);
    }

    public double getAngle(){
    	return (intakeAngle.get() * (360d/(256d*4d))) + 52.43;
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
		return .30 - .328*Math.cos(getAngle());
	}
	
	public double getAngleFromHeight(double height){
		return Math.toDegrees(Math.acos((.3 - height)/.328));
	}

	public double getAngleError() {
		return angleError;
	}

	public void setAngleError(double angleError) {
		this.angleError = angleError;
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
