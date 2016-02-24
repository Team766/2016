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
	public static final double INTAKE_LENGTH = 0.354;
	public static final double BALL_COMPRESSION_HEIGHT = 0.2286;
	
	//Winch
	public static final int WINCH_POWER = 1;
	public static final boolean SOL_FIRE = true;
	public static final double Catapult_RotationsToStop = 2; //Need Real Value
	
	//Find real values
	public enum RotationCounts{
	    Bottom(7), Middle(3.5);

	    private double numVal;

	    RotationCounts(double numVal) {
	        this.numVal = numVal;
	    }

	    public double getNumVal() {
	        return numVal;
	    }
	}
	
	//Arm
	public static final double ROTATION_TO_HEIGHT_RATIO = 1.0;
	public static final double HEIGHT_INITIAL = 1.0;
	public static final double ROTATIONS_PER_DEGREE = 1;
	public static final int ARM_THRESHOLD = 1,
							ARM_MAX_MID_HEIGHT = 1;
	public static final int SALLYPORT_ANGLE = 1,
							DRAWBRIDGE_ANGLE = 1,
							STAGE2MAX_ANGLE = 1;
	
	//PID values
	public static final double ArmKp = 1;
	public static final double ArmKi = 0;
	public static final double ArmKd = 0;
	public static final double ArmThreshold = 0.05;
	
	public static final double DriveKp = 1;
	public static final double DriveKi = 0;
	public static final double DriveKd = 0;
	public static final double DriveThreshold = 0.05;
	
	public static final double AngleKp = 1;
	public static final double AngleKi = 0;
	public static final double AngleKd = 0;
	public static final double AngleThreshold = 1;
	
	public static final double IntakeKp = 1;
	public static final double IntakeKi = 0;
	public static final double IntakeKd = 0;
	public static final double IntakeThreshold = 0.05;
	
	//Intake
	public static final double INTAKE_BALL_ANGLE = 1,
							   BALL_COMPRESSION_ANGLE = 1,
							   INTAKE_STARTING_ANGLE = 1,
							   INTAKE_STRAIGHTUP_ANGLE = 1,
							   DEFAULT_ANGLE = 1;
}
