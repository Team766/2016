package org.usfirst.frc.team766.lib;

import org.usfirst.frc.team766.lib.Tester.BearlyEncoder;
import org.usfirst.frc.team766.lib.Tester.BearlyVictor;
import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 * I like to think of myself as Woodrow Wilson, making the world safe for simulators
 * @author Blevenson
 *
 */

public class DeviceManager {
	//Motors
	private SpeedController leftDrive;
	private SpeedController rightDrive;
	
	private SpeedController wheels;
    private SpeedController rotator;
    
    private SpeedController winchA;
	private SpeedController winchB;
	
	private Servo vertical;
    
    //Encoders
	private CounterBase rightEncoder;
	private CounterBase leftEncoder;
	
	private CounterBase armEncoder;
	
    private CounterBase intakeAngle;
    
    private CounterBase travelDistance;
    
    //Solenoids
	private Solenoid leftShifter;
	private Solenoid rightShifter;
	
	private Solenoid firstStage;
	private Solenoid thirdStage;
	
	private DoubleSolenoid secondStage;
	
    private DoubleSolenoid launch;

	private ADXRS450_Gyro gyro;

	private DigitalInput atTop;
	
	private PowerDistributionPanel PDP;
	
	private AxisCamera cam;
	
	
	private static DeviceManager instance_;
	public static boolean SIMULATOR = false;
	
	public static DeviceManager getInstance(){
		if (instance_ == null){
			instance_ = (SIMULATOR)? new DeviceManager(true) : new DeviceManager(false);
		}
		return instance_;
	}
	
	public DeviceManager(){
		this(false);
	}
	
	public DeviceManager(boolean isSim){
		if(!isSim){
			leftDrive = new Victor(Ports.PWM_Left_Drive);
			rightDrive = new Victor(Ports.PWM_Right_Drive);
			
			wheels = new Victor(Ports.PWM_IntakeWheels);
		    rotator = new Victor(Ports.PWM_IntakeRotator);
		    
		    winchA = new Victor(Ports.PWM_Winch1);
			winchB = new Victor(Ports.PWM_Winch2);
			
			vertical = new Servo(Ports.PWM_Servo);
			
			rightEncoder = new Encoder(Ports.DIO_RDriveEncA, Ports.DIO_RDriveEncB);
			leftEncoder = new Encoder(Ports.DIO_LDriveEncA, Ports.DIO_LDriveEncB);
			
			armEncoder = new Encoder(Ports.DIO_ArmA, Ports.DIO_ArmB);
			
			intakeAngle = new Encoder(Ports.DIO_IntakeA, Ports.DIO_IntakeB);
			
			travelDistance = new Encoder(Ports.DIO_WinchA, Ports.DIO_WinchB);
			
			leftShifter = new Solenoid(Ports.PCM_REGULAR, Ports.Sol_LeftShifter);
			rightShifter = new Solenoid(Ports.PCM_REGULAR, Ports.Sol_RightShifter);
			
			firstStage = new Solenoid(Ports.PCM_ARM, Ports.Sol_ArmS1);
			thirdStage = new Solenoid(Ports.PCM_ARM, Ports.Sol_ArmS3);
			
			secondStage = new DoubleSolenoid(Ports.PCM_ARM, Ports.Sol_ArmS2_Up, Ports.Sol_ArmS2_Down);
			
		    launch = new DoubleSolenoid(Ports.PCM_REGULAR, Ports.Sol_Fire_A, Ports.Sol_Fire_B);

			gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

			atTop = new DigitalInput(Ports.DIO_HallEffectSensorWinch); 
			
			PDP = new PowerDistributionPanel();
			
			cam = new AxisCamera("169.254.2.2");
		}else{
			leftDrive = new BearlyVictor(Ports.PWM_Left_Drive);
			rightDrive = new BearlyVictor(Ports.PWM_Right_Drive);
			
			wheels = new BearlyVictor(Ports.PWM_IntakeWheels);
		    rotator = new BearlyVictor(Ports.PWM_IntakeRotator);
		    
		    winchA = new BearlyVictor(Ports.PWM_Winch1);
			winchB = new BearlyVictor(Ports.PWM_Winch2);
			
			rightEncoder = new BearlyEncoder(Ports.DIO_RDriveEncA, Ports.DIO_RDriveEncB);
			leftEncoder = new BearlyEncoder(Ports.DIO_LDriveEncA, Ports.DIO_LDriveEncB);
			
			armEncoder = new BearlyEncoder(Ports.DIO_ArmA, Ports.DIO_ArmB);
			
			intakeAngle = new BearlyEncoder(Ports.DIO_IntakeA, Ports.DIO_IntakeB);
			
			travelDistance = new BearlyEncoder(Ports.DIO_WinchA, Ports.DIO_WinchB);
		}
	}
	
	//Drive
	public SpeedController getLeftVictor(){
		return leftDrive;
	}

	public SpeedController getRightVictor(){
		return rightDrive;
	}
	//Intake
	public SpeedController getIntakeWheels(){
		return wheels;
	}
	public SpeedController getRotatorWheels(){
		return rotator;
	}
	
	//Winch
	public SpeedController getWinchA(){
		return winchA;
	}
	public SpeedController getWinchB(){
		return winchB;
	}
	
	public Servo getVerticalServo(){
		return vertical;
	}
	
	public CounterBase getLeftEncoder(){
		return leftEncoder;
	}
	public CounterBase getRightEncoder(){
		return rightEncoder;
	}
	public CounterBase getIntakeAngle(){
		return intakeAngle;
	}
	public CounterBase getWinchTravel(){
		return travelDistance;
	}

	//Solenoid
	public Solenoid getLeftShifter(){
		return leftShifter;
	}
	public Solenoid getRightShifter(){
		return rightShifter;
	}
	public Solenoid getFirstStage(){
		return firstStage;
	}
	public Solenoid getThirdStage(){
		return thirdStage;
	}
	public DoubleSolenoid getLaunch(){
		return launch;
	}
	public DoubleSolenoid getSecondStage(){
		return secondStage;
	}
	
	//Gyro
	public ADXRS450_Gyro getGyro(){
		return gyro;
	}
	
	//Encoder
	public DigitalInput getAtTop(){
		return atTop;
	}
	
	//PDP
	public PowerDistributionPanel getPDP(){
		return PDP;
	}
	
	public CounterBase getArmEncoder(){
		return armEncoder;
	}
	
	//Axis Camera
	public AxisCamera getCam(){
		return cam;
	}
}
