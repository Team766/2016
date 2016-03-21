package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
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
			PULSES_PER_ROTATION = 360,
			DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER)
					/ PULSES_PER_ROTATION;

	private Victor leftDrive;
	private Victor rightDrive;

	private Encoder rightEncoder;
	private Encoder leftEncoder;

	private Solenoid driveShifter;

	private ADXRS450_Gyro gyro;

	private PowerDistributionPanel PDP;
	private BuiltInAccelerometer accel;
	
	private boolean locked = false;

	public Drive(){
		leftDrive = (Victor)DeviceManager.getInstance().getLeftVictor();
		rightDrive = (Victor)DeviceManager.getInstance().getRightVictor();
	
		rightEncoder = (Encoder)DeviceManager.getInstance().getRightEncoder();
		leftEncoder = (Encoder)DeviceManager.getInstance().getLeftEncoder();
		
		driveShifter = DeviceManager.getInstance().getDriveShifter();
		
		gyro = DeviceManager.getInstance().getGyro();
		
		PDP = DeviceManager.getInstance().getPDP();
		accel = DeviceManager.getInstance().getAccel();
	}
	
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
		rightDrive.set(-s);
	}

	public void setPower(double s) {
		setLeftPower(s);
		setRightPower(s);
	}

	public double getLeftDistance() {
		return leftEncoder.get() * DISTANCE_PER_PULSE;
	}

	public double getRightDistance() {
		return -rightEncoder.get() * DISTANCE_PER_PULSE;
	}

	public void setShifter(boolean on) {
		driveShifter.set(on);
	}

	public double getLeftVelocity() {
		return leftEncoder.getRate();
	}

	public double getRightVelocity() {
		return rightEncoder.getRate();
	}
	
	public double getAccel(){
		return accel.getX();
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