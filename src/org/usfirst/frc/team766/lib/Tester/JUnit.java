package org.usfirst.frc.team766.lib.Tester;

import org.usfirst.frc.team766.lib.DeviceManager;

public class JUnit {
	/**
	 * Text file format:
	 * 		TestName
	 * 		Device-part: time(seconds after start)	value
	 * 
	 * Example:
	 * 		IntakeCatapultCollisionTest:
	 * 		Encoder-Arm:	1	0.0
	 * 		Victor-LeftDrive:	2	0.5
	 */
	
	private double startTime;
	
	public static void main(String[] args){
		DeviceManager.setTestMode(true);
		DeviceManager.getLeftVictor();
	}
}
