package org.usfirst.frc.team766.lib;

import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class DeviceManager {
	//Motors
	private static Victor leftDrive = new Victor(Ports.PWM_Left_Drive);
	private static Victor rightDrive = new Victor(Ports.PWM_Right_Drive);
	
	private static Victor wheels = new Victor(Ports.PWM_IntakeWheels);
    private static Victor rotator = new Victor(Ports.PWM_IntakeRotator);
    
    private static Victor winchA = new Victor(Ports.PWM_Winch1);
	private static Victor winchB = new Victor(Ports.PWM_Winch2);
	
	private static Servo vertical = new Servo(Ports.PWM_Servo);
    
    //Encoders
	private static Encoder rightEncoder = new Encoder(Ports.DIO_RDriveEncA,
			Ports.DIO_RDriveEncB);
	private static Encoder leftEncoder = new Encoder(Ports.DIO_LDriveEncA,
			Ports.DIO_LDriveEncB);
	
    private static Encoder intakeAngle = new Encoder(Ports.DIO_IntakeA, Ports.DIO_IntakeB);
    
    private static Encoder travelDistance = new Encoder(Ports.DIO_WinchA, Ports.DIO_WinchB);
    
    //Solenoids
	private static Solenoid leftShifter = new Solenoid(Ports.PCM_REGULAR, Ports.Sol_LeftShifter);
	private static Solenoid rightShifter = new Solenoid(Ports.PCM_REGULAR, Ports.Sol_RightShifter);
	
    private static DoubleSolenoid launch = new DoubleSolenoid(Ports.PCM_REGULAR, Ports.Sol_Fire_A, Ports.Sol_Fire_B);

	private static ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

	private static DigitalInput atTop = new DigitalInput(Ports.DIO_HallEffectSensorWinch); 
	
	private static PowerDistributionPanel PDP = new PowerDistributionPanel();
	
	private static AxisCamera cam = new AxisCamera("169.254.2.2");
	
	private static boolean TEST_MODE = false;

	
	public static void setTestMode(boolean testMode){
		TEST_MODE = testMode;
	}
	
	//Drive
	public static Victor getLeftVictor(){
		return leftDrive;
	}
	public static Victor getRightVictor(){
		return rightDrive;
	}
	//Intake
	public static Victor getIntakeWheels(){
		return wheels;
	}
	public static Victor getRotatorWheels(){
		return rotator;
	}
	
	//Whinch
	public static Victor getWinchA(){
		return winchA;
	}
	public static Victor getWinchB(){
		return winchB;
	}
	
	public static Servo getVerticalServo(){
		return vertical;
	}
	
	public static Encoder getLeftEncoder(){
		return leftEncoder;
	}
	public static Encoder getRightEncoder(){
		return rightEncoder;
	}
	public static Encoder getIntakeAngle(){
		return intakeAngle;
	}
	public static Encoder getWhichTravel(){
		return travelDistance;
	}

	//Solenoid
	public static Solenoid getLeftShifter(){
		return leftShifter;
	}
	public static Solenoid getRightShifter(){
		return rightShifter;
	}
	public static DoubleSolenoid getLaunch(){
		return launch;
	}
	
	//Gyro
	public static ADXRS450_Gyro getGyro(){
		return gyro;
	}
	
	//Encoder
	public static DigitalInput getAtTop(){
		return atTop;
	}
	
	//PDP
	public static PowerDistributionPanel getPDP(){
		return PDP;
	}
	
	//Axis Camera
	public static AxisCamera getcam(){
		return cam;
	}
}
