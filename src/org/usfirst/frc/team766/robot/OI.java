package org.usfirst.frc.team766.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	
	public Joystick jLeft = new Joystick(0),
			jRight = new Joystick(1);
	
	public OI(){
		
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
}

