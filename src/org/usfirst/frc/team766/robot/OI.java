package org.usfirst.frc.team766.robot;

import org.usfirst.frc.team766.lib.trajectory.Path;
import org.usfirst.frc.team766.robot.commands.Drive.FollowTarget;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	
	public Joystick jLeft = new Joystick(0),
			jRight = new Joystick(1);
	
	public Button
		buttonQuickTurn = new JoystickButton(jRight, Buttons.QUICKTURN),
		buttonShifter = new JoystickButton(jLeft, Buttons.SHIFTER),
		buttonAutoAllign = new JoystickButton(jLeft, Buttons.AUTOALLIGN);
	
	public Path path = null;
	
	public OI(){
		buttonAutoAllign.whileHeld(new FollowTarget());
	}
	
	public double getLeftX(){
		return jLeft.getX();
	}
	
	public double getLeftY(){
		return jLeft.getY();
	}
	
	public double getRightX(){
		return jRight.getX();
	}
	
	public double getRightY(){
		return jRight.getY();
	}

	public boolean getQuickTurn() {
		return buttonQuickTurn.get();
	}

	public boolean getShifter() {
		return buttonShifter.get();
	}

	public double getSteer() {
		return jRight.getX();
	}

	public double getThrottle() {
		return jRight.getY();
	}
}

