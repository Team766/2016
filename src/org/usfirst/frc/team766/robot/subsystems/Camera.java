package org.usfirst.frc.team766.robot.subsystems;

import org.usfirst.frc.team766.robot.RobotValues;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem{
	
	//the 1 isn't real
	Servo vertical = new Servo(1);
	
	double angle = vertical.getAngle();
	int pixelWidth = 0;
			
	public void setPixelWidth(int w){
		
		pixelWidth = w;
	}
			
	public int getPixelWidth(){
		
		return pixelWidth;
	}
	
	public double getAngleDistance(){
		
		return (RobotValues.CAMERAHEIGHT - RobotValues.ROBOTBASELINE) / Math.tan(angle);
	}
	
	public double getFocalDistance(){
		return (RobotValues.TAPEWIDTH * RobotValues.FOCALLENGTH) / getPixelWidth();
	}
	
	public double getDistance(){
		return getAngleDistance() + getFocalDistance() / 2.0 ;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
