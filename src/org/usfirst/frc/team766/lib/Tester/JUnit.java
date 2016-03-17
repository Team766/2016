/*package org.usfirst.frc.team766.lib.Tester;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.lib.Looper;
import org.usfirst.frc.team766.robot.commands.CommandBase;
import org.usfirst.frc.team766.robot.commands.Catapult.CatapultControl;
import org.usfirst.frc.team766.robot.commands.Intake.IntakeControl;

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
	 *
	
	private static double startTime;
	private static String test;
	
	static{
		DeviceManager.SIMULATOR = true;
	}
	
	private static Callable[] devices = {(Callable)DeviceManager.getInstance().getLeftVictor(),
										 (Callable)DeviceManager.getInstance().getRightVictor(),
										 (Callable)DeviceManager.getInstance().getRotatorWheels(),
										 (Callable)DeviceManager.getInstance().getIntakeWheels(),
										 (Callable)DeviceManager.getInstance().getWinchA(),
										 (Callable)DeviceManager.getInstance().getWinchB(),
										 (Callable)DeviceManager.getInstance().getLeftEncoder(),
										 (Callable)DeviceManager.getInstance().getRightEncoder(),
										 (Callable)DeviceManager.getInstance().getArmEncoder(),
										 (Callable)DeviceManager.getInstance().getIntakeAngle(),
										 (Callable)DeviceManager.getInstance().getWinchTravel()};
	
	public static void main(String[] args){
		FileParser parser = new FileParser("tests");
		String curr;
		
		while(!parser.isDone()){
			startTime = System.currentTimeMillis()/1000.0;
			test = parser.readNextLine();
			System.out.println(startTime + "\tStarting test: " + test);
			while(parser.hasNextLine()){
				curr = parser.readNextLine();
				if(curr == null)
					continue;
				//System.out.println(curr);
				switch(curr.substring(curr.indexOf('-') + 1, curr.indexOf(':'))){
					case "LeftDrive":
						devices[0].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "RightDrive":
						devices[1].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "IntakeRotator":
						devices[2].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "IntakeWheels":
						devices[3].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "WinchA":
						devices[4].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "WinchB":
						devices[5].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "LeftEnc":
						devices[6].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "RightEnc":
						devices[7].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "ArmEnc":
						devices[8].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "IntakeEnc":
						devices[9].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					case "WinchEnc":
						devices[10].addValue(asDouble(curr.split("\t"))[0], asDouble(curr.split("\t"))[1]);
						break;
					default:
						System.err.println("Invalid System");
						break;
				}	
			}
			//Tests
			switch(test){
				case "DriveMotorDirections":
					break;
				case "TestTests":
					break;
				case "MinDegree":
					CommandBase.init();
					new Thread(new Looper()).start();
					Looper.getInstance().add(new IntakeControl());
					System.out.println("BRett is Super Cool!!");
					break;
				default:
					System.err.println("Not a valid test!");
					break;
			}
			
			//Lock while the tests are running
			while(valuesLeft()){
				DeviceManager.getInstance().getLeftVictor().get();
				DeviceManager.getInstance().getRightVictor().get();
				try{
				Thread.sleep(100);
				}catch(Exception e){}			
			}
			System.out.println("\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\nNEXT!!!!\n\n\n\n\n");
		}
		
	}
	
	private static double[] asDouble(String[] vals){
		double[] values = new double[2];
		//Ignore first value
		for(int i = 1; i < vals.length; i++){
			values[i-1] = Double.parseDouble(vals[i]);
		}
		return values;
	}
	
	public static double getStartTime(){
		return startTime;
	}
	
	private static boolean valuesLeft(){
		for(Callable device: devices){
			if(device.values.size() != 0)
				return true;
		}
		return false;
	}
}
*/