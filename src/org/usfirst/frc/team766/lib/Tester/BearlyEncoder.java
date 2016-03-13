package org.usfirst.frc.team766.lib.Tester;

import edu.wpi.first.wpilibj.CounterBase;

public class BearlyEncoder extends Callable implements CounterBase{
	private int resetValue = 0;
	
	public BearlyEncoder(int a, int b){
		
	}
	
	public int get() {
		return (int)getNextValue() - resetValue;
	}

	public void reset() {
		resetValue = get();
	}

	public double getPeriod() {
		return 0;
	}

	public void setMaxPeriod(double maxPeriod) {
	}

	public boolean getStopped() {
		int past = get();
		
		try{Thread.sleep(10);}catch(Exception e){}
		
		return get() == past;
	}

	public boolean getDirection() {
		int past = get();
		
		try{Thread.sleep(10);}catch(Exception e){}
		
		return (get() - past < 0)? false : true;
	}

}
