package org.usfirst.frc.team766.robot;

import org.usfirst.frc.team766.lib.Looper;
import org.usfirst.frc.team766.robot.commands.CommandBase;
import org.usfirst.frc.team766.robot.commands.Camera.FindErrors;
import org.usfirst.frc.team766.robot.commands.Camera.TrackTarget;
import org.usfirst.frc.team766.robot.commands.Catapult.CatapultControl;
import org.usfirst.frc.team766.robot.commands.Drive.TankDrive;
import org.usfirst.frc.team766.robot.commands.Intake.IntakeControl;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public void robotInit() {
		CommandBase.init();
		
		new Thread(new Looper()).start();
		Looper.getInstance().add(new CatapultControl());
		Looper.getInstance().add(new IntakeControl());
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		new FindErrors().start();
		new TrackTarget().start();
		
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		//new FindErrors().start();
		//new TrackTarget().start();
		
		new TankDrive().start();
		//new MotorTester().start();
		
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
