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
	
	//real values
	public static final double TAPE_WIDTH = 0.5207;
	public static final double TOWER_HEIGHT = 2.4638;
	
	//Vision Values
	public static final double PIXEL_WIDTH = 351;
	public static final double DISTANCE = 1.143;
	public static final double FOCAL_LENGTH = (PIXEL_WIDTH * DISTANCE) / TAPE_WIDTH;
	public static final int FOCAL_WIDTH = 1;
	public static final double CAMERA_HEIGHT = 1;
	public static final double ROBOT_BASELINE = 1;
	
	//Intake
	 public static final double INTAKE_LENGTH = 0.5;			//REAL VALUE NEEDED
	 public static final double BALL_COMPRESSION_HEIGHT = 0.2286;
	
	//Winch
	public static final int WINCH_POWER = 1;
	public static final boolean PIST_OUT = true;
	
	//Arm
	public static final double ROTATION_TO_HEIGHT_RATIO = 1.0;
	public static final double HEIGHT_INITIAL = 1.0;
	public static final double ROTATIONS_PER_DEGREE = 1;
	
	//PID values
	public static final double ArmKp = 1;
	public static final double ArmKi = 0;
	public static final double ArmKd = 0;
	public static final double ArmThreshold = 0.05;
	
	public static final double DriveKp = 1;
	public static final double DriveKi = 0;
	public static final double DriveKd = 0;
	public static final double DriveThreshold = 0.05;
}
