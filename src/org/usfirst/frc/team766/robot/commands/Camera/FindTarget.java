package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.robot.commands.Drive.FollowTarget;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FindTarget extends CommandGroup{
	public FindTarget(){
		addSequential(new CameraLights(true));
		
		addParallel(new FindErrors());
		addParallel(new TrackTarget());
		
		addSequential(new FollowTarget());
		
		addSequential(new CameraLights(false));
	}
}
