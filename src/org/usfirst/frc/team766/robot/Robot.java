package org.usfirst.frc.team766.robot;

import org.usfirst.frc.team766.lib.Looper;
import org.usfirst.frc.team766.robot.commands.CommandBase;
import org.usfirst.frc.team766.robot.commands.Drive.CheesyDrive;
import org.usfirst.frc.team766.robot.commands.Drive.DriveDistance;
import org.usfirst.frc.team766.robot.commands.Intake.IntakeControl;
import org.usfirst.frc.team766.robot.commands.Intake.ManualIntakeControl;
import org.usfirst.frc.team766.robot.commands.Intake.MoveIntake;
import org.usfirst.frc.team766.robot.commands.Intake.ResetIntakeAngle;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public void robotInit() {
		CommandBase.init();
		
		//Test Commands
		SmartDashboard.putData(new ResetIntakeAngle());
		SmartDashboard.putData(new DriveDistance(2));
		SmartDashboard.putData(new MoveIntake(90));
		
		//PIDS
		SmartDashboard.putNumber("Intake P: ", RobotValues.IntakeKp);
		SmartDashboard.putNumber("Intake I: ", RobotValues.IntakeKi);
		SmartDashboard.putNumber("Intake D: ", RobotValues.IntakeKd);
		
		SmartDashboard.putNumber("Drive P: ", RobotValues.DriveKp);
		SmartDashboard.putNumber("Drive I: ", RobotValues.DriveKi);
		SmartDashboard.putNumber("Drive D: ", RobotValues.DriveKd);
		
//		Looper.getInstance().add(new CatapultControl());
		Looper.getInstance().add(new IntakeControl());
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		//new FindTarget().start();
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		//new FindErrors().start();
		//new TrackTarget().start();
	
//		new ManualAdjustment().start();
		new ManualIntakeControl().start();
		new CheesyDrive().start();
//		new MotorTester().start();
//		new PrintWinchRotations().start();
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	public void disabledInit() {
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
