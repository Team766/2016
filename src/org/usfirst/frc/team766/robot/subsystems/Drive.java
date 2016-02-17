package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Subsystem used to control the drive train
 */
public class Drive extends Subsystem {
    
	private static final double WHEEL_DIAMETER = 0.2032, // meters, 8 in
			PULSES_PER_ROTATION = 256,
			DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER) / PULSES_PER_ROTATION;
	
	private Victor leftDrive1 = new Victor(Ports.PWM_Left_Drive);
	private Victor leftDrive2 = new Victor(Ports.PWM_Left_Drive);
	private Victor rightDrive1 = new Victor(Ports.PWM_Right_Drive); 
	private Victor rightDrive2 = new Victor(Ports.PWM_Right_Drive); 
	
	private Encoder rightEncoder = new Encoder(Ports.DIO_RDriveEnc1,
			Ports.DIO_RDriveEnc2, false, CounterBase.EncodingType.k4X);
	private Encoder leftEncoder = new Encoder(Ports.DIO_LDriveEnc1,
			Ports.DIO_LDriveEnc2, false, CounterBase.EncodingType.k4X);
	
	private Solenoid shifter = new Solenoid(Ports.Sol_Shifter);

	private GyroBase gyro = new AnalogGyro(Ports.GYRO);
	
	private PowerDistributionPanel PDP = new PowerDistributionPanel();
	
	private boolean lock = false;
	private Command lockCommand = null;
	
	/*
	 * Todo:
	 * 1.  Reset Commands
	 * 2.  Power commands
	 */
	
	public void lock(Command command){
		lock = true;
		lockCommand = command;
	}
	
	public void unlock(){
		lock = false;
		lockCommand = null;
	}
	
    public void initDefaultCommand() {
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
    public double getGyroAngle(){
    	return gyro.getAngle();
    }
    
    public void resetRightEncoder(){
    	rightEncoder.reset();
    }
    
    public void resetLeftEncoder(){
    	leftEncoder.reset();
    }
    
    public void resetEncoders(){
    	resetRightEncoder();
    	resetLeftEncoder();
    }
    
    public void setLeftPower(double s){
    	leftDrive1.set(s);
    	leftDrive2.set(s);
    }
    
    public void setRightPower(double s){
    	rightDrive1.set(s);
    	rightDrive2.set(s);
    }
    
    public void setPower(double s){
    	setLeftPower(s);
    	setRightPower(s);
    }
    
    public double getLeftDistance(){
    	return leftEncoder.get() * DISTANCE_PER_PULSE;
    }
    
    public double getRightDistance(){
    	return rightEncoder.get() * DISTANCE_PER_PULSE;
    }
}

