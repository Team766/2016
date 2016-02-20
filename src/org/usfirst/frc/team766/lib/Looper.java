package org.usfirst.frc.team766.lib;

import edu.wpi.first.wpilibj.DriverStation;
import java.util.ArrayList;

public class Looper implements Runnable{

	ArrayList<Loopable> commands = new ArrayList<Loopable>();
	protected boolean locked = false;

	public void run() {
		while(DriverStation.getInstance().isEnabled()){
			if(!locked){
				for(Loopable i : commands){
					i.run();
				}
			}
		}
	}
	
	public void add(Loopable i){
		locked = true;
		if(!contains(i)){
			i.initilize();
			commands.add(i);
		}
		locked = false;
	}
	
	public void remove(Loopable i){
		locked = true;
		if(contains(i)){
			i = getInstance(i);
			i.end();
			commands.remove(i);
		}
		locked = false;
	}
	
	public Loopable getInstance(Loopable in){
		for(Loopable i : commands){
			if(i.getClass().getName() == in.getClass().getName())
				return i;
		}
		return null;
	}
	
	public boolean contains(Loopable in){
		for(Loopable i : commands){
			if(i.getClass().getName() == in.getClass().getName()){
				return true;
			}
		}
		return false;
	}
}
