package org.usfirst.frc.team766.robot;

public class Ports {
	
	//Drive
	public static final int PWM_Right_Drive = 0;
	public static final int PWM_Left_Drive = 1;
	
	//Arm
	public static final int PWM_ARM = 3;
	
	//Shooter
	public static final int PWM_Winch = 2;
	
	//Solenoids
	public static final int Sol_Fire = 0;
	public static final int Sol_Shifter = 1;
	
	//Encoders
	public static final int DIO_LDriveEncA = 0,
							DIO_LDriveEncB = 1,
							DIO_RDriveEncA = 8,
							DIO_RDriveEncB = 9;
	
	//Gyro
	public static final int GYRO = 0;
	
	//Hall Effect Sensor
	public static final int DIO_HallEffectSensorWinch = 10;
}
