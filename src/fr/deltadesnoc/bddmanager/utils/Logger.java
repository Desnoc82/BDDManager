package fr.deltadesnoc.bddmanager.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	private final String name;
	
	public Logger(String name){
		this.name = name;
	}
	
	public void log(String s, String... format){
		Color.sendConsoleColorMessage(Color.CYAN, genPrefix() + "[INFO] " + String.format(s, format));
	}
	
	public void warn(String s, String... format){
		Color.sendConsoleColorMessage(Color.RED, genPrefix() + "[WARN] " + String.format(s, format));
	}
	
	private String genPrefix(){
		
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(this.name).append("]");
		
		String datePattern = "dd/MM/YYYY HH:mm:ss";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		String date = dateFormat.format(new Date(System.currentTimeMillis()));
		
		builder.append(" [").append(date).append("] ");
		return builder.toString();
	}
	
	public String getName() {
		return name;
	}
	
}
