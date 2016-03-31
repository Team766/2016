package org.usfirst.frc.team766.lib;

import java.util.HashMap;

public class LogFactory {
	private static HashMap<String, Logger> logs = new HashMap<String, Logger>();
	
	public static Logger getInstance(String key){
		return logs.get(key);
	}
	
	public static void createInstance(String key){
		logs.put(key, new Logger(key));
	}
	
	public static void closeFile(String key){
		logs.get(key).closeFile();
		logs.remove(key);
	}
	
	public static void closeFiles(){
		for(String log : logs.keySet()){
			closeFile(log);
		}
	}
	
	public static HashMap<String, Logger> getLogs(){
		return logs;
	}
}
