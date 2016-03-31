package org.usfirst.frc.team766.robot.commands.Intake;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 *	Takes an angle and moves the intake to the desired position
 * 
 * @author Andrew Y8s SWM
 *
 */

public class VelocityControl extends CommandBase {
	//I copied this from IntakeControl
	private PIDController IntakePID = new PIDController(RobotValues.IntakeKp, 
			RobotValues.IntakeKi, RobotValues.IntakeKd, RobotValues.IntakeThreshold);
	//these arent real numbers
	private final double aMax = 0;
	private final double vMax = 0;
	private final double stopThreshold = 1;
	//these actually can be!
	private double triangle, lastTime, velocity, angle, elapsedTime, goalVelocity, direction;
	private States state_;
	
	private enum States{
		SLOPE_UP, SLOPE_NOT, SLOPE_DOWN
	}
	
	public VelocityControl(double angle){
		triangle = angle;
		//if it has to go up or down
		direction = (angle - Intake.getAngle())/Math.abs(angle - Intake.getAngle());
	}
	
	protected void initialize() {
	}

	protected void execute() {
		//time stuff here
		 velocity = Intake.getVelocity();
		 angle = Intake.getAngle();
		 elapsedTime = Timer.getFPGATimestamp() - lastTime;
		
		
		if(rampDistance(velocity)<= triangle-angle ){
			state_ = States.SLOPE_DOWN;
		}
		
		//actual running here should be a switch and is
		switch(state_){
			case SLOPE_UP:
				if(velocity >= vMax)
					state_ = States.SLOPE_NOT;
				else
					goalVelocity += aMax * elapsedTime * direction;
				break; 
			case SLOPE_DOWN:
				goalVelocity -= aMax * elapsedTime * direction;
				break;
			case SLOPE_NOT:
				goalVelocity = vMax * direction;
				break;
			
		}
		
		IntakePID.setSetpoint(goalVelocity);
		IntakePID.calculate(velocity, false);
		Intake.setRotationMotor(IntakePID.getOutput());
		//figuring out how much time happened
		lastTime = Timer.getFPGATimestamp();
	}

	protected boolean isFinished() {
		return (Math.abs(Intake.getAngle() - triangle) <= stopThreshold);
	}
	
	protected void end() {
		Intake.setRotationMotor(0.0);
	}

	protected void interrupted() {
		end();
	}

	private double rampDistance(double velocity){
		return Math.pow(velocity, 2) / (2.0 * aMax);
	}
}
