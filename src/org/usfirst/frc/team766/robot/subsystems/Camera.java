package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.robot.Ports;
import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Camera extends Subsystem{
	
	Servo vertical;
	
	AxisCamera cam;
	
	private int pixelWidth;
	private double xError;
	private double yError;
	
	private double verticalAngle = 90;
	
	private double angleError;
	
	private double focalDistance;
	private int trackTarget;
	
	public Camera(){
		vertical = DeviceManager.getInstance().getVerticalServo();
		cam = DeviceManager.getInstance().getCam();
		
		pixelWidth = 0;
		angleError = focalDistance = 0;
		xError = yError = 0.0;
		trackTarget = 3;
	}
	
	/**
	 * @param point 0-2 with 0 being the far right point as seen when looking at the tower.  3 is for
	 * largest area, and 4 is for center;
	 */
	public void changeTrackPoint(int point){
		trackTarget = point;
	}
	
	public void setPixelWidth(int w){
		pixelWidth = w;
	}
			
	public int getPixelWidth(){
		return pixelWidth;
	}
	
	public double getAngleError(){
		return angleError;
	}
	
	public void setAngleError(double angle){
		angleError = angle;
	}
	
	public double getAngleDistance(){
		return (RobotValues.TargetCenterHeight - RobotValues.ROBOT_BASELINE) / Math.tan(vertical.getAngle());
	}
	
	public void setVerticalAngle(double degree){
		vertical.setAngle(degree);
		verticalAngle = degree;
	}
	
	public double getVerticalAngle(){
		return verticalAngle;
	}
	
	public void setFocalDistance(double distance){
		focalDistance = distance;
	}
	
	public double getFocalDistance(){
		return focalDistance;
	}
	
	public double getDistance(){
		return (getAngleDistance() + getFocalDistance()) / 2.0 ;
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
	
	public int getTrackPoint(){
		return trackTarget;
	}
	
	protected void initDefaultCommand() {
	}
}
