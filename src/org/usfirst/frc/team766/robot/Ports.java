package org.usfirst.frc.team766.robot;

public class Ports {
	
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
	public static final int Sol_RightShifter = 4;
	public static final int Sol_LeftShifter = 5;
	public static final int Sol_Fire = 6;
	
	
	//Encoders
	public static final int DIO_LDriveEncA = 0,
							DIO_LDriveEncB = 1,
							DIO_RDriveEncA = 2,
							DIO_RDriveEncB = 3,
							DIO_ArmA = 4,
							DIO_ArmB = 5,
							DIO_IntakeA = 6,
							DIO_IntakeB = 7,
							DIO_WinchA = 8,
							DIO_WinchB = 9;
	
	//Hall Effect Sensor
	public static final int DIO_HallEffectSensorWinch = 10;

}
