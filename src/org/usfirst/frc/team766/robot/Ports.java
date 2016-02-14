package org.usfirst.frc.team766.robot;

public class Ports {
	
	//Drive
	public static final int PWM_Right_Drive = 0;
	public static final int PWM_Left_Drive = 3;
	
	//Arm
	public static final int PWM_ARM = 1;
	
	//Shooter
	public static final int PWM_Winch = 2;
	
	//Solenoids
	public static final int Sol_Fire = 0;
	public static final int Sol_Shifter = 1;
	public static final int Sol_ArmS1 = 2;
	
	//Encoders
	public static final int DIO_LDriveEncA = 0,
							DIO_LDriveEncB = 1,
							DIO_ArmA = 2,
							DIO_ArmB = 3,
							DIO_RDriveEncA = 8,
							DIO_RDriveEncB = 9;
	
	//Gyro
	public static final int GYRO = 0;
	
	//Hall Effect Sensor
	public static final int DIO_HallEffectSensorWinch = 10;
	
	//intake
	public static final int PWM_Intake = 0,
			PWM_Rotator = 0; //find real port
	public static final int DIO_IntakeA = 0,
			DIO_IntakeB = 0; //not real port
}
