package org.usfirst.frc.team766.lib;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class DistLookup {
	
	private static DistLookup instance_;
	
	public HashMap<Double, Double[]> lookup = new HashMap<Double, Double[]>();
	
	private Scanner in;
	private String[] newLine;
	
	public static DistLookup getInstance(){
		if(instance_ == null)
			instance_ = new DistLookup();
		return instance_;
	}
	
	public DistLookup(){
		loadFile();
	}
	
	public void loadFile(){
		try{
			 in = new Scanner(new FileReader("tests/DistLookup.csv"));
			 while(in.hasNext()){
				 newLine = in.nextLine().split(",");
				 lookup.put(Double.parseDouble(newLine[0]), getValues(newLine));
			 }
		}catch(Exception e){
			System.out.println("Failed to read file! \n" + e.getMessage());
		}
	}
	
	public void printMap(){
		for(Double key : lookup.keySet()){
			System.out.println(key + "\t" + lookup.get(key)[0] + "\t" + lookup.get(key)[1]);
		}
	}
	
	public Double[] getValues(String[] in){
		Double[] out = new Double[2];

		for(int i = 1; i < in.length; i++)
			out[i-1] = Double.parseDouble(in[i]);
		
		return out;
	}
}
