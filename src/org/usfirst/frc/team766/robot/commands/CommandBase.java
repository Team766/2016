package org.usfirst.frc.team766.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team766.robot.*;

public abstract class CommandBase extends Command {
	
	public static OI OI;
	
	public static void init(){
		OI = new OI();
	}
}
