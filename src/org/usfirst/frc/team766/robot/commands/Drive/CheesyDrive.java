package org.usfirst.frc.team766.robot.commands.Drive;

import org.usfirst.frc.team766.lib.PIDController;
import org.usfirst.frc.team766.robot.OI;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;
import org.usfirst.frc.team766.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Controls the robot drive train using the standard Team 254 scheme.
 *
 *(modified a bit for use of Team 766)
 * @author richard@team254.com (Richard Lin)
 * 
 */
public class CheesyDrive extends CommandBase {
	
	private boolean HEADING__CONTROL = true;
	
  private double oldWheel = 0.0;
  private double quickStopAccumulator;
  private double throttleDeadband = 0.02;
  private double wheelDeadband = 0.02;

  private PIDController headingPID = new PIDController(RobotValues.GyroKp,
			RobotValues.GyroKi, RobotValues.GyroKd,
			RobotValues.GyroThreshold);
  
  public CheesyDrive() {
	  requires(Drive);
  }

  protected void initialize() {
	  headingPID.setSetpoint(Drive.getGyroAngle());
  }

  protected void execute() {
	if(Drive.locked())
			return;
    if (DriverStation.getInstance().isAutonomous()) {
      return;
    }
    boolean isQuickTurn = OI.getQuickTurn();
    boolean isHighGear = !OI.getShifter();

    double wheelNonLinearity;

    double wheel = handleDeadband(OI.getSteer(), wheelDeadband);
    double throttle = handleDeadband(OI.getThrottle(), throttleDeadband);

    double negInertia = wheel - oldWheel;
    oldWheel = wheel;

    if (isHighGear) {
      wheelNonLinearity = 0.6;
      // Apply a sin function that's scaled to make it feel better.
      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
          Math.sin(Math.PI / 2.0 * wheelNonLinearity);
      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
          Math.sin(Math.PI / 2.0 * wheelNonLinearity);
    } else {
      wheelNonLinearity = 0.5;
      // Apply a sin function that's scaled to make it feel better.
      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
          Math.sin(Math.PI / 2.0 * wheelNonLinearity);
      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
          Math.sin(Math.PI / 2.0 * wheelNonLinearity);
      wheel = Math.sin(Math.PI / 2.0 * wheelNonLinearity * wheel) /
          Math.sin(Math.PI / 2.0 * wheelNonLinearity);
    }

    double leftPwm, rightPwm, overPower;
    double sensitivity = 1.7;

    double angularPower;
    double linearPower;

    // Negative inertia!
    double negInertiaAccumulator = 0.0;
    double negInertiaScalar;
    if (isHighGear) {
      negInertiaScalar = 5.0;
      sensitivity = RobotValues.sensitivityHigh;
    } else {
      if (wheel * negInertia > 0) {
        negInertiaScalar = 2.5;
      } else {
        if (Math.abs(wheel) > 0.65) {
          negInertiaScalar = 5.0;
        } else {
          negInertiaScalar = 3.0;
        }
      }
      sensitivity = RobotValues.sensitivityLow;

      if (Math.abs(throttle) > 0.1) {
       // sensitivity = 1.0 - (1.0 - sensitivity) / Math.abs(throttle);
      }
    }
    double negInertiaPower = negInertia * negInertiaScalar;
    negInertiaAccumulator += negInertiaPower;

    wheel = wheel + negInertiaAccumulator;
    if (negInertiaAccumulator > 1) {
      negInertiaAccumulator -= 1;
    } else if (negInertiaAccumulator < -1) {
      negInertiaAccumulator += 1;
    } else {
      negInertiaAccumulator = 0;
    }
    linearPower = throttle;

    // Quickturn!
    if (isQuickTurn) {
      if (Math.abs(linearPower) < 0.2) {
        double alpha = 0.1;
        quickStopAccumulator = (1 - alpha) * quickStopAccumulator + alpha *
            limit(wheel, 1.0) * 5;
      }
      overPower = 1.0;
      if (isHighGear) {
        sensitivity = 1.0;
      } else {
        sensitivity = 1.0;
      }
      angularPower = wheel;
    } else {
      overPower = 0.0;
      angularPower = Math.abs(throttle) * wheel * sensitivity - quickStopAccumulator;
      if (quickStopAccumulator > 1) {
        quickStopAccumulator -= 1;
      } else if (quickStopAccumulator < -1) {
        quickStopAccumulator += 1;
      } else {
        quickStopAccumulator = 0.0;
      }
    }

    rightPwm = leftPwm = linearPower;
    leftPwm += angularPower;
    rightPwm -= angularPower;

    if (leftPwm > 1.0) {
      rightPwm -= overPower * (leftPwm - 1.0);
      leftPwm = 1.0;
    } else if (rightPwm > 1.0) {
      leftPwm -= overPower * (rightPwm - 1.0);
      rightPwm = 1.0;
    } else if (leftPwm < -1.0) {
      rightPwm += overPower * (-1.0 - leftPwm);
      leftPwm = -1.0;
    } else if (rightPwm < -1.0) {
      leftPwm += overPower * (-1.0 - rightPwm);
      rightPwm = -1.0;
    }


    Drive.setShifter(isHighGear);
    
    if(HEADING__CONTROL && !isQuickTurn && Math.abs(OI.getSteer()) < 0.02 && Math.abs(OI.getThrottle()) > 0){
    	headingPID.calculate(Drive.getGyroAngle(), false);
    	
    	Drive.setLeftPower(leftPwm - headingPID.getOutput());
	    Drive.setRightPower(rightPwm + headingPID.getOutput());
    }else{
	    Drive.setLeftPower(leftPwm);
	    Drive.setRightPower(rightPwm);
	    
	    headingPID.setSetpoint(Drive.getGyroAngle());
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }

  public double handleDeadband(double val, double deadband) {
    return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
  }
  public static double limit(double v, double limit) {
	return (Math.abs(v) < limit) ? v : limit * (v < 0 ? -1 : 1);
  }
}