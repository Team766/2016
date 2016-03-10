package org.usfirst.frc.team766.lib.Tester;

import java.util.PriorityQueue;

public abstract class Callable {

	public PriorityQueue<Values> values = new PriorityQueue<Values>();
	private double startTime = 0;
	
	public void addValue(double time, double value){
		addValue(new Values(time, value));
	}
	
	public void addValue(Values add){
		values.add(add);
	}
	
	public double getNextValue(){
		while(values.size() > 1 && values.peek().getTime() <= currTime())
			values.poll();
		if(values.size() == 0)
			return 0.0;
		return values.poll().getValue();
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
