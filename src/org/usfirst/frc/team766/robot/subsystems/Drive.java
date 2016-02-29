package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Subsystem used to control the drive train
 */
public class Drive extends Subsystem {

	private static final double WHEEL_DIAMETER = 0.2032, // meters, 8 in
			PULSES_PER_ROTATION = 256,
			DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER)
					/ PULSES_PER_ROTATION;

	private Victor leftDrive = new Victor(Ports.PWM_Left_Drive);
	private Victor rightDrive = new Victor(Ports.PWM_Right_Drive);

	private Encoder rightEncoder = new Encoder(Ports.DIO_RDriveEncA,
			Ports.DIO_RDriveEncB);
	private Encoder leftEncoder = new Encoder(Ports.DIO_LDriveEncA,
			Ports.DIO_LDriveEncB);

	private Solenoid leftShifter = new Solenoid(Ports.PCM_REGULAR, Ports.Sol_LeftShifter);
	private Solenoid rightShifter = new Solenoid(Ports.PCM_REGULAR, Ports.Sol_RightShifter);

	private ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

	private PowerDistributionPanel PDP = new PowerDistributionPanel();
	
	private boolean locked = false;

	public void initDefaultCommand() {
	}

	public void calibrateGyro() {
		gyro.calibrate();
	}

	public void resetGyro() {
		gyro.reset();
	}

	public double getGyroAngle() {
		return gyro.getAngle();
	}

	public double getGyroAngleRadians() {
		return gyro.getAngle() * (Math.PI / 180);
	}

	public void resetRightEncoder() {
		rightEncoder.reset();
	}

	public void resetLeftEncoder() {
		leftEncoder.reset();
	}

	public void resetEncoders() {
		resetRightEncoder();
		resetLeftEncoder();
	}

	public void setLeftPower(double s) {
		leftDrive.set(s);
	}

	public void setRightPower(double s) {
		rightDrive.set(s);
	}

	public void setPower(double s) {
		setLeftPower(s);
		setRightPower(s);
	}

	public double getLeftDistance() {
		return leftEncoder.get() * DISTANCE_PER_PULSE;
	}

	public double getRightDistance() {
		return rightEncoder.get() * DISTANCE_PER_PULSE;
	}

	public void setShifter(boolean on) {
		setLeftShifter(on);
		setRightShifter(on);
	}

	private void setLeftShifter(boolean on) {
		leftShifter.set(on);
	}

	private void setRightShifter(boolean on) {
		rightShifter.set(on);
	}

	public double getLeftVelocity() {
		return leftEncoder.getRate();
	}

	public double getRightVelocity() {
		return rightEncoder.getRate();
	}
	
	public double getLeftVoltage(){
		return (PDP.getCurrent(2) + PDP.getCurrent(3))/2.0; 
	}
	
	public double getRightVoltage(){
		return (PDP.getCurrent(0) + PDP.getCurrent(1))/2.0; 
	}
	
	public boolean locked(){
		return locked;
	}
	public void lock(boolean lock){
		locked = lock;
	}

}