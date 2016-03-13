package org.usfirst.frc.team766.robot;

public class Ports {
	
	//PCMS
	public static final int PCM_REGULAR = 0;
	public static final int PCM_ARM = 1;
	
	//Drive
	public static final int PWM_Right_Drive = 0;
	public static final int PWM_Left_Drive = 1;
	
	//Intake
	public static final int PWM_IntakeWheels = 4;
	public static final int PWM_IntakeRotator = 5;
	
	//Shooter
	public static final int PWM_Winch1 = 2;
	public static final int PWM_Winch2 = 3;
	
	//Camera
	public static final int PWM_Servo = 6;

	public static final int Sol_ArmS1 = 0;
	public static final int Sol_ArmS2_Up = 1;
	public static final int Sol_ArmS2_Down = 2;
	public static final int Sol_ArmS3 = 3;
	public static final int Sol_RightShifter = 0;
	public static final int Sol_LeftShifter = 1;
	public static final int Sol_Fire_A = 2;
	public static final int Sol_Fire_B = 3;
	
	
	//Encoders
	public static final int DIO_LDriveEncA = 16,
							DIO_LDriveEncB = 17,
							DIO_RDriveEncA = 14,
							DIO_RDriveEncB = 15,
							DIO_ArmA = 18,
							DIO_ArmB = 19,
							DIO_IntakeA = 12,
							DIO_IntakeB = 13,
							DIO_WinchA = 10,
							DIO_WinchB = 11;
	
	//Hall Effect Sensor
	public static final int DIO_HallEffectSensorWinch = 0;

}
