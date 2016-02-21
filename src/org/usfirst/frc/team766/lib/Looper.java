package org.usfirst.frc.team766.lib;

import edu.wpi.first.wpilibj.DriverStation;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Looper implements Runnable{

	private static Looper instance_;
	
	ArrayList<Loopable> commands = new ArrayList<Loopable>();
	protected boolean locked = false;

	public static Looper getInstance() {
		if (instance_ == null)
			instance_ = new Looper();
		return instance_;
	}
	
	
	public void run() {
		while(DriverStation.getInstance().isEnabled()){
			if(!locked){
				for(Loopable i : commands){
					i.run();
					
					if(i.isFinished())
						remove(i);
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
			i = getName(i);
			i.end();
			commands.remove(i);
		}
		locked = false;
	}
	
	public Loopable getName(Loopable in){
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
