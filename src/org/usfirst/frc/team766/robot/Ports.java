package org.usfirst.frc.team766.robot;

public class Ports {
	
	//Motors
	public static final int PWM_Right_Drive = 0,
							PWM_Left_Drive = 1;
	public static final int PWM_Winch = 2;
	public static final int PWM_Servo = 3;
	public static final int PWM_IntakeWheels = 4,
							PWM_IntakeRotator = 5;
	
	//Solenoids
	public static final int Sol_Arm1 = 0,
							Sol_Arm2Up = 1,
							Sol_Arm2Down = 2,
							Sol_Arm3 = 3;
	public static final int Sol_RShifter = 4,
							Sol_LShifter = 5,
							Sol_Fire = 6;
	
	
	//Encoders
	public static final int DIO_LDriveEnc1 = 0,
							DIO_LDriveEnc2 = 1,
							DIO_RDriveEnc1 = 2,
							DIO_RDriveEnc2 = 3,
							DIO_ArmA = 4,
							DIO_ArmB = 5,
							DIO_IntakeEnc1 = 6,
							DIO_IntakeEnc2 = 7,
							DIO_WinchEnc1 = 8,
							DIO_WinchEnc2 = 9;
	
	//Gyro
	public static final int GYRO = 0;
	
	//Hall Effect Sensor
	public static final int DIO_HallEffectSensorWinch = 10;
	
}
