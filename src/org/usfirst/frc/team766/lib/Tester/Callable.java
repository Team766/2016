/*package org.usfirst.frc.team766.lib.Tester;

import java.util.PriorityQueue;

public abstract class Callable {

	public PriorityQueue<Values> values = new PriorityQueue<Values>();
	
	public void addValue(double time, double value){
		addValue(new Values(time, value));
	}
	
	public void addValue(Values add){
		values.add(add);
		System.out.println(values.size());
	}
	
	public double getNextValue(){
		if(values.size() > 0)
			System.out.println("NEXT SIZE: " + values.size() + "\t" + values.peek().getTime() + "\t" + currTime());
		while(values.size() > 0 && values.peek().getTime() < currTime()){
			values.remove();
		}
		
		if(values.size() == 0)
			return 0.0;
		
		return values.peek().getValue();
	}
	
	public double currTime(){
		return (System.currentTimeMillis()/1000.0) - JUnit.getStartTime();
	}
	
	class Values implements Comparable<Values>{
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

		@Override
		public int compareTo(Values arg0) {
			Values in = (Values)arg0;
			if(time - in.time < 0)
				return -1;
			else if(time - in.time > 0)
				return 1;
			return 0;
		}
	}
}
*/