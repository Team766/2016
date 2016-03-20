package org.usfirst.frc.team766.lib;

import java.util.ArrayList;

public class Looper implements Runnable{

	private static Looper instance_;
	
	ArrayList<Loopable> commands = new ArrayList<Loopable>();
	protected boolean locked = false;

	public static Looper getInstance() {
		if (instance_ == null){
			instance_ = new Looper();
			new Thread(instance_).start();
		}
		return instance_;
	}
	
	
	public void run() {
		int size;
		while(true){
			if(!locked){
				size = commands.size();
				for(int i = 0; i < size; i++){
					commands.get(i).run();
					
					if(commands.get(i).isFinished())
						remove(commands.get(i));
				}
			}
		}
	}
	
	public void add(Loopable i){
		locked = true;
		if(!contains(i)){
			i.initialize();
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
