package org.thrawn.logging;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public final class LogEngine {

	private static List<Log> logs = new ArrayList<Log>();
	
	/**
	 * Log a message to the logs.
	 * @param log The full log to add.
	 */
	public static final void log(Log log) {
		logs.add(log);
	}
	
	/**
	 * Log a message to the logs.
	 * @param log The full log to add.
	 */
	public static final void log(String log) {
		log(new Log(log));
	}
	
	/**
	 * Returns all the tags in the engine by the specified tag.
	 * @param tag The tag to search for.
	 * @return the results.
	 */
	public static final List<Log> getByTag(String tag) {
		List<Log> resultLogs = new ArrayList<Log>();
		for (Log log: logs) {
			if (log.containsTag(tag)) {
				resultLogs.add(log);
			}
		}
		return resultLogs;
	}
	
	public static final List<Log> getByTags(String[] tag) {
		List<Log> resultLogs = new ArrayList<Log>();
		for (Log log: logs) {
			for (int i = 0; i < tag.length; i++) {
				if (log.containsTag(tag[i])) {
					resultLogs.add(log);
				}
			}
		}
		return resultLogs;
	}
	
	/**
	 * Save the log to the specified existing/non-existing file.
	 * @param fileName The filename of the new/existing file.
	 * @throws IOException
	 */
	public static final void save(String fileName) throws IOException {
		
		FileOutputStream f = new FileOutputStream(fileName);
		DataOutputStream file = new DataOutputStream(f);
		
		for (Log log: logs) {
			file.writeUTF(log.getSource() + "\n");
			file.flush();
		}
		
		file.close();
		
	}
	
}
