package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.Ports;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Subsystem for controlling the catapult
 */
public class Shooter extends Subsystem {
    
	public State state_;
	
	public enum State {
		WINCHING,
		FIRING,
		READY_TO_FIRE,
		WAITING_TO_WINCH
	};
	
	Victor winch = new Victor(Ports.PWM_Winch);
	//Sensor for when it is winched down
	//Motor controller for winch motor
	//Pnumatic piston for launching the catapult
	
    public void initDefaultCommand() {
    }
}

