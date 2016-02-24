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
    
    public void initDefaultCommand() {	
    }
    
    public void setWheels(double s){
    	wheels.set(s);
    }

    public void setRotationMotor(double s){
    	rotator.set(s);
    }

    public double getAngle(){
    	return intakeAngle.get() * (360d/256d);
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

	public double getAngleError() {
		return angleError;
	}

	public void setAngleError(double angleError) {
		this.angleError = angleError;
	}
}
