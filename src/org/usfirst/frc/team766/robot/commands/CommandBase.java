package org.usfirst.frc.team766.robot.commands;

import org.usfirst.frc.team766.robot.OI;
import org.usfirst.frc.team766.robot.subsystems.Camera;
import org.usfirst.frc.team766.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static OI OI;
	public static Drive Drive;
	public static Camera Camera;
	
	public static void init(){
		OI = new OI();
		Drive = new Drive();
		Camera = new Camera();
	}
}
