package org.usfirst.frc.team766.lib.scripts;

public class GenerateLookUpTable {
	
	//Paramaters
	private final int ANGLE_RESOLUTION = 2;
	private final double DELTA_DISTANCE = 0.1;
	
	private final int MIN_ANGLE = 0;
	private final int MAX_ANGLE = 90;
	
	private final double MIN_DIST = 0;
	private final double MAX_DIST = 6;
	
	//Constants
	private final double g = 9.8;
	private final double deltaHeight = 2.46;  //Height of tower - height to launcher
	
	//Local variables
	private double lowestVelocity, newVelocity, newAngle;
	
	public void calculate(){
		for(double dist = MIN_DIST; dist < MAX_DIST; dist += DELTA_DISTANCE){
			lowestVelocity = Double.MAX_VALUE;
			for(int angle = MIN_ANGLE; angle < MAX_ANGLE; angle += ANGLE_RESOLUTION){
				newVelocity = (1.0/Math.cos(Math.toRadians(angle)))*Math.sqrt((-g*Math.pow(dist,2))/(2 * (deltaHeight - dist*Math.tan(Math.toRadians(angle)))));
				//System.out.println(dist + "\t" + angle + "\t" + (1.0/Math.cos(Math.toRadians(angle)))*Math.sqrt((-g*Math.pow(dist,2))/(2 * (deltaHeight - dist*Math.tan(Math.toRadians(angle))))));
				if(lowestVelocity > newVelocity){
					lowestVelocity = newVelocity;
					newAngle = angle;
				}
			}
			//Print to file
			System.out.println(dist + "\t" + newAngle + "\t" + lowestVelocity);
		}
	}
	
	public static void main(String[] args){
		new GenerateLookUpTable().calculate();
	}
}
