package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Subsystem used to control the drive train
 */
public class Drive extends Subsystem {
    
	private static final double WHEEL_DIAMETER = .09958, // meters
			PULSES_PER_ROTATION = 256,
			DISTANCE_PER_PULSE = (Math.PI * WHEEL_DIAMETER) / PULSES_PER_ROTATION;
	
	private Victor leftDrive = new Victor(Ports.PWM_Left_Drive);
	private Victor rightDrive = new Victor(Ports.PWM_Right_Drive);
	
	private Encoder rightEncoder = new Encoder(Ports.DIO_RDriveEncA,
			Ports.DIO_RDriveEncB, false, CounterBase.EncodingType.k4X);
	private Encoder leftEncoder = new Encoder(Ports.DIO_LDriveEncA,
			Ports.DIO_LDriveEncB, false, CounterBase.EncodingType.k4X);
	
	private Solenoid Shifter = new Solenoid(Ports.Sol_Shifter);

	private Gyro gyro = new Gyro(Ports.GYRO);
	
	private PowerDistributionPanel PDP = new PowerDistributionPanel();
	
	private boolean lock = false;
	private Command lockCommand = null;
	
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
}

