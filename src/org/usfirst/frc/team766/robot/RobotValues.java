package org.usfirst.frc.team766.robot;
/**
 * The RobotValues holds all the constants used in the robot code
 */
public class RobotValues {

	//All values in meters
	
	// Conversion constants
	public static final double INCHES_TO_METERS = 0.0254;
	
	//Auton
	public static final String[] Autons = {"Vision Drive", "22 Points"};
	
	//Vision Values
	public static final int FOCAL_LENGTH = 1;
	public static final int FOCAL_WIDTH = 1;
	public static final double CAMERA_HEIGHT = 1;
	public static final double ROBOT_BASELINE = 1;
	//real values
	public static final double TAPE_WIDTH = 0.508; //with 2 in height tape
	public static final double TOWER_HEIGHT = 2.4638;
	
	//Winch
	public static final int WINCH_POWER = 1;
	public static final boolean PIST_OUT = true;
	
	//Arm
	public static final double ROTATION_TO_HEIGHT_RATIO = 1.0;
	public static final double HEIGHT_INITIAL = 1.0;
	public static final double ROTATIONS_PER_DEGREE = 1;
}
