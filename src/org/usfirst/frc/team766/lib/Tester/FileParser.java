package org.usfirst.frc.team766.lib.Tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {
	
	private ArrayList<File> files;
	private File currFile;
	
	private BufferedReader reader;
	private String in;
	private boolean done;
	
	public FileParser(String folderDirectory){
		files = new ArrayList<File>();

		addFiles(new File(folderDirectory).listFiles());
		
		done = false;
		
		 currFile = nextFile();

		 try {
			reader = new BufferedReader(new FileReader(currFile));
		} catch (FileNotFoundException e) {
			System.out.println("Failed to read initial file");
		}

		 in = "";
	}
	
	public File nextFile(){
		System.out.println("Size: " + files.size());
		if(files.size() < 1){
			done = true;
			return null;
		}
		
		try {
			reader = new BufferedReader(new FileReader(files.get(0)));
		} catch (FileNotFoundException e) {
			System.out.println("Failed to update reader");
		}
		
		return files.remove(0);
	}
	
	public boolean hasNextLine(){
		if(in == null){
			nextFile();
			return false;
		}
		return true;	
	}
	
	public String readNextLine(){
		try {
			in = reader.readLine();
		} catch (IOException e) {
			System.err.println("Failed to read line");
		}
		
		return in;
	}
	
	public boolean isDone(){
		return done;
	}
	
	public int fileSize(){
		return files.size();
	}
	
	private void addFiles(File[] f) {
	    for (File file : f) {
	        if (file.isDirectory())
	            addFiles(file.listFiles());
	        else
	            files.add(file);
	    }
	}
	
}
