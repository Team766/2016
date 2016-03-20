package org.usfirst.frc.team766.robot.commands;

import org.usfirst.frc.team766.robot.OI;
import org.usfirst.frc.team766.robot.subsystems.Camera;
import org.usfirst.frc.team766.robot.subsystems.Catapult;
import org.usfirst.frc.team766.robot.subsystems.Drive;
import org.usfirst.frc.team766.robot.subsystems.Intake;
import org.usfirst.frc.team766.robot.subsystems.Arm;
import org.usfirst.frc.team766.lib.Looper;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static Drive Drive;
	public static Camera Camera;
	public static Intake Intake;
	public static Catapult Catapult;
	public static Arm Arm;
	public static OI OI;
	
	public static void init(){
		Drive = new Drive();
		//Camera = new Camera();
		Intake = new Intake();
		Catapult = new Catapult();
		Arm = new Arm();
		OI = new OI();
			
	}
}
