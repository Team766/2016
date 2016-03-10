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
		DeviceManager.SIMULATOR = true;
		
		FileParser parser = new FileParser("tests");
		
		while(!parser.isDone()){
			System.out.println("Starting test: " + parser.readNextLine());
			while(parser.hasNextLine()){
				System.out.println(parser.readNextLine());
			}
		}
		
		DeviceManager.getInstance().getLeftVictor();
		DeviceManager.getInstance().getLeftVictor().set(1);
		System.out.println(DeviceManager.getInstance().getLeftVictor().get());
	}
}
