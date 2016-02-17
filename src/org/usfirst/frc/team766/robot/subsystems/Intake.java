package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem for the Intake
 */
public class Intake extends Subsystem {
    
    //motor for spinning things
    private Victor wheels = new Victor(Ports.PWM_IntakeWheels);

    //motor for rotating whole mechanism
    private Victor rotator = new Victor(Ports.PWM_IntakeRotator);

    //encoder on rotator
    private Encoder intakeAngle = new Encoder(Ports.DIO_IntakeA, Ports.DIO_IntakeB);

    public void initDefaultCommand() {	
    }
    
    public void setWheels(double s){
    	wheels.set(s);
    }

    public void setMechanismMotor(double s){
    	rotator.set(s);
    }

    public double getIntakeAngle(){
    	return intakeAngle.get() * (256d/360d);
    }
}

