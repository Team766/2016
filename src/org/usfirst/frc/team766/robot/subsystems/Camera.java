package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Camera extends Subsystem{
	
	Servo vertical = new Servo(1);
	
	AxisCamera cam = new AxisCamera("169.254.2.2");
	
	private int pixelWidth = 0;
	private double xError = 0.0;
	private double yError = 0.0;
			
	public void setPixelWidth(int w){
		pixelWidth = w;
	}
			
	public int getPixelWidth(){
		return pixelWidth;
	}
	
	public double getAngleDistance(){
		return (RobotValues.CAMERA_HEIGHT - RobotValues.ROBOT_BASELINE) / Math.tan(vertical.getAngle());
	}
	
	public double getFocalDistance(){
		return (RobotValues.TAPE_WIDTH * RobotValues.FOCAL_LENGTH) / getPixelWidth();
	}
	
	public double getDistance(){
		return (getAngleDistance() + getFocalDistance()) / 2.0 ;
	}

	protected void initDefaultCommand() {
	}

	public double getXError() {
		return xError;
	}

	public void setXError(double xError) {
		this.xError = xError;
	}

	public double getYError() {
		return yError;
	}

	public void setYError(double yError) {
		this.yError = yError;
	}	
}
