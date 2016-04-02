package org.usfirst.frc.team766.robot;

import org.usfirst.frc.team766.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotValues holds all the constants used in the robot code
 */
public class RobotValues {

	//All values in meters
	
	// Conversion constants
	public static final double INCHES_TO_METERS = 0.0254;
	
	//Auton
	public static final String[] Autons = {"Vision Drive", "22 Points"};
	public static final double DEAD_RECK_POWER = 1.0;
	
	//real values
	public static final double TAPE_WIDTH = 0.5207;
	public static final double TOWER_HEIGHT = 2.4638;
	public static final double FIRE_DISTANCE = 5.1816; //FIND REAL VALUE - may need to be an array of positions
	public static final double AUTON_LINE_TO_BACK_DEFENSES = 3.007868;
	
	//Vision Values
	public static final double PIXEL_WIDTH = 351;
	public static final double DISTANCE = 1.143;
	public static final double FOCAL_LENGTH = (PIXEL_WIDTH * DISTANCE) / TAPE_WIDTH;
	public static final int FOCAL_WIDTH = 1;
	public static final double TargetCenterHeight = 1; //How far off the ground the center of the targets are
	public static final double ROBOT_BASELINE = 1; //Height of camera off the ground
	
	//Cheesy drive
    public static final double sensitivityHigh = .85;
    public static final double sensitivityLow = .75;
	
	//Intake
	public static final double INTAKE_LENGTH = 0.354;
	public static final double BALL_COMPRESSION_HEIGHT = 0.2286;
	public static final double IntakeCollisionAngle = 190; //The angle where the intake will hit the catapult's arc
	
	//Winch
	public static final double WINCH_POWER = 0.7;
	public static final double Catapult_RotationsToStop = 4; //Need Real Value
	
	//Catapult
	public static final double INITIAL_LAUNCH_VELOCITY = 7.62,//	m/s
							   LAUNCH_ANGLE = 67, //	degrees
							   INITIAL_BALL_HEIGHT = 0.7366, //	meters
							   GRAVITATIONAL_STRENGTH = 9.8;  //	m/s^2
	
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
	public static final int ARM_MAX_MID_HEIGHT = 1,	//Need real values
							SecondStageThreshold = 45;//Need real value
	public static final int SALLYPORT_ANGLE = 1,
							DRAWBRIDGE_ANGLE = 1,
							STAGE2MAX_ANGLE = 1;
	
	//PID values
	public static final double ArmKp = 1;
	public static final double ArmKi = 0;
	public static final double ArmKd = 0;
	public static final double ArmThreshold = 0.05;
	
	public static final double DriveKp = SmartDashboard.getNumber("Drive P: ");
	public static final double DriveKi = SmartDashboard.getNumber("Drive I: ");;
	public static final double DriveKd = SmartDashboard.getNumber("Drive D: ");;
	public static final double DriveThreshold = 0.05;
	
	public static final double GyroKp = 0.01; //these values need to be tested
	public static final double GyroKi = 0.00;
	public static final double GyroKd = 0.03;
	public static final double GyroThreshold = 0.05;
	
	public static final double AngleKp = 0.35;
	public static final double AngleKi = 0;
	public static final double AngleKd = 0.15;
	public static final double AngleThreshold = 1;
	
	public static final double IntakeKp = 0.1;//SmartDashboard.getNumber("Intake P: ");
	public static final double IntakeKi = 0;//SmartDashboard.getNumber("Intake I: ");
	public static final double IntakeKd = 0.005;//SmartDashboard.getNumber("Intake D: ");
	public static final double IntakeThreshold = 1;
	
	public static final double CameraKp = 1;
	public static final double CameraKi = 0;
	public static final double CameraThreshold = 0.05;
	public static final double CameraKd = 0;
	
	//Intake
	public static final double INTAKE_BALL_ANGLE = Intake.getAngleFromHeight(BALL_COMPRESSION_HEIGHT),
							   INTAKE_FLOOR_ANGLE = Intake.getAngleFromHeight(0),
							   INTAKE_STRAIGHTUP_ANGLE = 180,
							   INTAKE_STORE_ANGLE = 210;
}