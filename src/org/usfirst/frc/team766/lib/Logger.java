package org.usfirst.frc.team766.lib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.wpi.first.wpilibj.Timer;

public class Logger {

	private PrintWriter pw;
	private Timer timer = new Timer();
	private boolean INDENT = false;
	private String name;
	
	private boolean htmlOnly;
	
	private String LogFolder = getLogFolderName();

	private String html = "<head><meta http-equiv=\"refresh\" content=\"1\"></head><body style=\"background-color:rgba(180, 28, 28, 0.8)\">";
	
	public Logger(){
		htmlOnly = true;
		html += "<h2 style = \"color: white\">" + name + "</h2>  <p style = \"color: #fc4\">";
		timer.start();
	}
	
	public Logger(String fileName) throws IOException {
		name = fileName;
		try {
			System.out.println(new File("/media/sda1/" + LogFolder).mkdir());
			pw = new PrintWriter(new FileWriter("/media/sda1/" + LogFolder + "/" + name + ".txt"));
			timer.start();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Something went wrong in the log's constructor");
			timer.stop();
			throw e;
		}
		html += "<h2 style = \"color: white\">" + name + "</h2>  <p style = \"color: #fc4\">";
		htmlOnly = false;
	}

	public void print(String message) {
		if(htmlOnly){
			if(INDENT)
				html += getHtmlTime() + "\t\t" + message + "<br>";
			else
				html += getHtmlTime() + "\t\t" + message + "<br>";
		}else{
			try {
				if (INDENT) {
					pw.println(getTime() + "\t\t" + message);
					html += getHtmlTime() + "\t\t" + message + "<br>";
				} else {
					pw.println(getTime() + "\t" + message);
					html += getHtmlTime() + "\t\t" + message + "<br>";
				}
			} catch (NullPointerException e) {
				System.out.println("Null Pointer alert!");
			}
		}
	}

	public void printRaw(String in) {
		if(htmlOnly)
			html += in + "<br>";
		else{
			try {
				pw.println(in);
				html += in + "<br>";
			} catch (NullPointerException e) {
				System.out.println("Can't print raw value: " + in);
			}
		}
	}

	public void print(String message, int value) {
		if(htmlOnly){
			if(INDENT)
				html += getHtmlTime() + "\t\t" + message + value + "<br>";
			else
				html += getHtmlTime() + "\t" + message + value + "<br>";
		}else{
			try {
				if (INDENT) {
					pw.println(getTime() + "\t\t" + message + value);
					html += getHtmlTime() + "\t\t" + message + value + "<br>";
				}
	
				else {
					pw.println(getTime() + "\t" + message + value);
					html += getHtmlTime() + "\t" + message + value + "<br>";
				}
			} catch (NullPointerException e) {
				System.out.println("Can't save log!");
			}
		}
	}

	public void closeFile() {
		timer.stop();

		try {
			pw.close();
		} catch (NullPointerException e) {
			System.out.println("Can't save log!");
		}
	}

	private String getTime() {
		int totalSeconds = (int) (timer.get());
		int seconds = totalSeconds % 60;
		int minutes = (totalSeconds / 60) % 60;
		int hours = totalSeconds / 3600;
		return hours + ":" + minutes + ":" + seconds;
	}
	
	private String getHtmlTime(){
		return "<p1 style = \"color: white\">" + getTime() + "</p1>";
	}

	public boolean isIndent() {
		return INDENT;
	}

	public void setIndent(boolean iNDENT) {
		INDENT = iNDENT;
	}

	public String getName() {
		return name;
	}

	public String getHTML() {
		return html;
	}
	
	public void clearHTML(){
		html = "<head><meta http-equiv=\"refresh\" content=\"1\"></head><body style=\"background-color:rgba(180, 28, 28, 0.8)\">";
		html += "<h2 style = \"color: white\">" + name + "</h2>  <p style = \"color: #fc4\">";
		print("Sucessfully cleared HTML log");
	}
	
	@SuppressWarnings("deprecation")
	private String getLogFolderName(){
		Date date = new Date(System.currentTimeMillis());
		return new SimpleDateFormat("dd-MM-yyyy").format(date) + "_" + date.getHours() + "~" + date.getMinutes() + "~" + date.getSeconds();
	}
}
