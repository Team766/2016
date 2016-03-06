package org.usfirst.frc.team766.lib.Tester;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Victor;

public abstract class CallableVictor extends Victor{
	public CallableVictor(int channel) {
		super(channel);
	}

	public ArrayList<Values> values = new ArrayList<Values>();
	private double startTime = 0;
	
	public void addValue(double time, double value){
		addValue(new Values(time, value));
	}
	
	public void addValue(Values add){
		for(int i = 0; i < values.size(); i++){
			if(values.get(i).getTime() > add.getTime()){
				values.add(i, add);
				return;
			}
		}
	}
	
	public boolean readyForNext(){
		return values.get(0).getTime() <= currTime();
	}
	
	public double getNextValue(){
		return values.remove(0).getValue();
	}
	
	public double currTime(){
		return (System.currentTimeMillis()/1000.0) - startTime;
	}
	
	public void setStartTime(double seconds){
		startTime = seconds;
	}
	
	class Values{
		private double time;
		private double value;
		
		public Values(double t, double v){
			time = t;
			value = v;
		}
		
		public double getTime(){
			return time;
		}
		public double getValue(){
			return value;
		}
	}
}
