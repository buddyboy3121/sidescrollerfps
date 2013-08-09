package org.thrawn.logging;

import org.thrawn.format.CommandFormat;

public class Log {

	private String fullLog;
	
	public Log(String fullLog) {
		this.fullLog = fullLog;
	}
	
	public String getSource() {
		return CommandFormat.getCommand(getTags(), getValues());
	}
	
	public String[] getValues() {
		return CommandFormat.getValues(fullLog);
	}
	
	public String[] getTags() {
		return CommandFormat.getTags(fullLog);
	}
	
	public boolean containsTag(String tag) {
		for (int i = 0; i < getTags().length; i++) {
			if (getTags()[i].equalsIgnoreCase(tag)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
}
