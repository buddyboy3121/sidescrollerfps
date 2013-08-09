package org.thrawn.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.thrawn.server.Profile;

public final class CommandFormat {

	 public static StackTraceElement getCurrentMethod(){
	     try{
	         throw new Exception();
	     }catch(Exception e){
	         return e.getStackTrace()[0];
	     }
	 }
	
	public static boolean isTargetCommandFormat(String cmd) {
		return cmd.matches("\\{(.*?)#(.*?)@(.*?):(.*?)\\}");
	}
	
	public static String getConnectionString(Profile profile) {
		return getCommand(new String[]{"SERVER", "EVENT", "NEW_CLIENT"}, new String[]{profile.getAccountName(), profile.getFirstName(), profile.getLastName(), profile.getDescription()});
	}
	
	public static String getLogMessage(String type, String log) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return getCommand(new String[]{"LOG", type}, new String[]{dateFormat.format(date), "\"" + log + "\""});
	}
	
	public static String getCautionMessage(String log) {
		return getLogMessage("!CAUTION!", log);
	}
	
	public static String getCurrentMethodError(String type, String message) {
		StackTraceElement search = getCurrentMethod();
		return getSpecificMessage(message, type, search.getMethodName(), search.getLineNumber(), search.getClassName());
	}
	
	public static String getSpecificMessage(String message, String type, String method, int line, String className) {
		return getLogMessage(type, message + "@\"" + method + "\":" + line + " - (" + className + ")");
	}
	
	public static String getErrorMessage(String log) {
		return getLogMessage("!ERROR!", log);
	}
	
	public static String getInternalMessage(String log) {
		return getLogMessage("INTERNAL", log);
	}
	
	public static String getWarningMessage(String log) {
		return getLogMessage("WARNING", log);
	}
	
	public static String getInformationalLogMessage(String log) {
		return getLogMessage("INFO", log);
	}
	
	public static String getCommand(String[] tags, String[] elements) {
		String finalCommand = "";
		finalCommand += "{";
		for (int i = 0; i < tags.length; i++) {
			if (i < tags.length - 1) {
				finalCommand += tags[i] + "#";
			} else {
				finalCommand += tags[i];
			}
		}
		finalCommand += ":";
		for (int i = 0; i < elements.length; i++) {
			if (i < elements.length - 1) {
				finalCommand += elements[i] + "&";
			} else {
				finalCommand += elements[i];
			}
		}
		finalCommand += "}";
		return finalCommand;
	}
	
	/**
	 * Returns all the values in a command.
	 * @param conString The command.
	 * @return the values of the command.
	 */
	public static String[] getValues(String conString) {
		return conString.split("\\{")[1].split("\\}")[0].split(":")[1].split("&");
	}
	
	/**
	 * Returns all the tags in a command.
	 * @param cmd The command to return the tags from.
	 * @return the tags of the command.
	 */
	public static String[] getTags(String cmd) {
		return cmd.split("\\{")[1].split("\\}")[0].split(":")[0].split("#");
	}
	
	public static String getLogProfileParsed(Profile profile, String ipAddress) {
		return getCommand(new String[]{"CLIENT", "EVENT", "PROFILE_PARSED"}, new String[]{profile.getAccountName(), ipAddress});
	}
	
	public static String getLogClientAccepted(String ipAddress) {
		return getCommand(new String[]{"CLIENT", "EVENT", "ACCEPTED"}, new String[]{ipAddress});
	}
	
	public static String getLogClientConnected(String ipAddress) {
		return getCommand(new String[]{"CLIENT", "EVENT", "CONNECTED"}, new String[]{ipAddress});
	}
	
	public static String getKickString(String responsible, String name, String reason) {
		return "{CLIENT#KICK@" + responsible + ":" + name + "&" + reason + "}";
	}

	public static String getBanString(String responsible, String name, String reason) {
		return "{CLIENT#BAN@" + responsible + ":" + name + "&" + reason + "}";
	}
	
	public static String getPrivateMessageString(String responsible, String name, String message) {
		return "{CLIENT#P_MSG@" + responsible + ":" + name + "&" + message + "}";
	}
	
	public static String getClientCommandString(String cmd) {
		return "{CLIENT#COMMAND:" + cmd + "}";
	}
	
	public static String getBroadcastString(String responsible, String message) {
		return "{SERVER#BROADCAST@" + responsible + ":" + message + "}";
	}
	
	public static String getMessageString(String responsible, String receiver, String message) {
		return "{CLIENT#MSG@" + responsible + ":" + receiver + "&" + message + "}";
	}
	
	public static String getResponsible(String cmd) {
		if (cmd.contains(":")) {
			return cmd.split("\\{")[1].split("\\}")[0].split(":")[0].split("@")[1];
		} else {
			return cmd.split("\\{")[1].split("\\}")[0].split("@")[1];
		}
	}
	
	public static String[] getTargetValues(String cmd) {
		if (cmd.matches("\\{.*?#.*?@.*?\\}")) {
			return null;
		} else if (cmd.matches("\\{(.*?)#(.*?)@(.*?):(.*?)\\}")) {
			return cmd.split("\\{")[1].split("\\}")[0].split(":")[1].split("&");
		} else {
			return null;
		}
	}
	
	public static String getCommandListenerString(String state) {
		return "{COMMAND#LISTENER:" + state + "}";
	}
	
	public static String getCloseString(String responsible) {
		return "{SERVER#CLOSE@" + responsible + "}";
	}
	
}
