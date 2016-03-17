package org.usfirst.frc.team766.robot;

import org.usfirst.frc.team766.lib.trajectory.Path;
import org.usfirst.frc.team766.robot.commands.Arm.ExtendArmStage1;
import org.usfirst.frc.team766.robot.commands.Arm.Store;
import org.usfirst.frc.team766.robot.commands.Catapult.Fire;
import org.usfirst.frc.team766.robot.commands.Drive.FollowTarget;
import org.usfirst.frc.team766.robot.commands.Intake.MoveIntake;
import org.usfirst.frc.team766.robot.commands.Intake.SetWheels;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{
	
	public Joystick jLeft = new Joystick(0),
			jRight = new Joystick(1),
			jBox = new Joystick(2);
	
	public Button
		buttonDriverShoot = new JoystickButton(jRight, Buttons.DRIVER_FIRE),
		buttonQuickTurn = new JoystickButton(jRight, Buttons.QUICKTURN),
		buttonShifter = new JoystickButton(jLeft, Buttons.SHIFTER),
		buttonAutoAllign = new JoystickButton(jLeft, Buttons.AUTOALLIGN),
		
		//Box Op
		buttonIntakeUp = new JoystickButton(jBox, Buttons.INTAKE_UP),
		buttonIntakeDown = new JoystickButton(jBox, Buttons.INTAKE_DOWN),
		buttonIntakeCollect = new JoystickButton(jBox, Buttons.INTAKE_COLLECT),
		buttonIntakeStore = new JoystickButton(jBox, Buttons.INTAKE_STORE),
		
		buttonBoxOpShoot = new JoystickButton(jBox, Buttons.BOXOP_FIRE),
		
		buttonArmToggle = new JoystickButton(jBox, Buttons.ARM_TOGGLE),
	
		buttonIntakeIn = new JoystickButton(jBox, Buttons.INTAKE_WHEELS_IN),
		buttonIntakeOut = new JoystickButton(jBox, Buttons.INTAKE_WHEELS_OUT);
		
	
	public Path path = null;
	
	public OI(){
		Fire fire = new Fire();
		buttonAutoAllign.whileHeld(new FollowTarget());
		buttonDriverShoot.whenPressed(fire);
		
		//Box OP
		buttonIntakeUp.whenPressed(new MoveIntake(RobotValues.INTAKE_STRAIGHTUP_ANGLE));
		buttonIntakeDown.whenPressed(new MoveIntake(RobotValues.INTAKE_FLOOR_ANGLE));
		buttonIntakeCollect.whenPressed(new MoveIntake(RobotValues.INTAKE_BALL_ANGLE));
		buttonIntakeStore.whenPressed(new MoveIntake(RobotValues.INTAKE_STORE_ANGLE));
		
		buttonBoxOpShoot.whenPressed(fire);
		
		buttonArmToggle.whenReleased(new Store());
		buttonArmToggle.whenPressed(new ExtendArmStage1(true));
		
		buttonIntakeIn.whileHeld(new SetWheels(1.0));
		buttonIntakeOut.whileHeld(new SetWheels(-1.0));
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
		return -jRight.getX();
	}

	public double getThrottle() {
		return -jLeft.getY();
	}
	
	public double getIntakeJoystick(){
		return jBox.getRawAxis(Buttons.JOYSTICK_INTAKE);
	}
	
	public double getArmJoystick(){
		return jBox.getRawAxis(Buttons.JOYSTICK_ARM);
	}
	
	//TEST -- DELETE AFTER TESTING!!!!!!!!
	public double getCatapultAxis(){
		return jBox.getY();
	}
}

