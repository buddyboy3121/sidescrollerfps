package org.thrawn.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.thrawn.server.Profile;

public final class CommandFormat {

	public static class TargetElement {
		
		private String name;
		private String value;
		
		public TargetElement(String name, String value) {
			this.name = name;
			this.value = value;
		}
		
		public final String getName() {
			return name;
		}
		public final void setName(String name) {
			this.name = name;
		}
		public final String getValue() {
			return value;
		}
		public final void setValue(String value) {
			this.value = value;
		}
		
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
	
	 public static StackTraceElement getCurrentMethod(){
	     try{
	         throw new Exception();
	     }catch(Exception e){
	         return e.getStackTrace()[0];
	     }
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
	
	public static String getCommandListenerString(String state) {
		return "{COMMAND#LISTENER:" + state + "}";
	}
	
	public static String getCloseString(String responsible) {
		return "{SERVER#CLOSE@" + responsible + "}";
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
	
	/**
	 * The log shown when the {@link Profile} of a client has been parsed successfully.<br>
	 * Client's {@link Profile} is only parsed once the {@link Client} has connected.
	 * @param profile The {@link Profile} of the new {@link Client}.
	 * @param ipAddress The IP address of the new {@link Client}.
	 * @return the full-built log.
	 */
	public static String getLogProfileParsed(Profile profile, String ipAddress) {
		return getCommand(new String[]{"CLIENT", "EVENT", "PROFILE_PARSED"}, new String[]{profile.getAccountName(), ipAddress});
	}
	
	/**
	 * The log shown when the {@link Client} has been accepted into a {@link Lobby}.
	 * @param ipAddress The IP address of the new {@link Client}.
	 * @return the full-built log.
	 */
	public static String getLogClientAccepted(String ipAddress) {
		return getCommand(new String[]{"CLIENT", "EVENT", "ACCEPTED"}, new String[]{ipAddress});
	}
	
	public static String getLogClientConnected(String ipAddress) {
		return getCommand(new String[]{"CLIENT", "EVENT", "CONNECTED"}, new String[]{ipAddress});
	}
	
	
	/**
	 * Returns the command representing a close of a {@link Lobby}.<br>
	 * his command is built using the {@link #getTargetCommand(String[], String, String[])} method.<br>
	 * Always be sure to use that method when you make your own commands.<br>
	 * That way, you can be sure everything is parsed correctly, and no errors will occur unless anything is wrong.
	 * @param responsible The responsible individual of this action.<br>
	 * This is used to see whether the responsible had the permissions to send this command.
	 * @param reason The reason for the closing of the server.<br>
	 * This is the message clients will see when they get kicked from the server.
	 * @return the fully-built command.
	 */
	public static String getCloseServerCommand(String responsible, String reason) {
		return getTargetCommand(new String[]{"SERVER#CLOSE"}, responsible, new String[]{reason});
	}
	
	/**
	 * Returns the command representing a restart of a {@link Lobby}.<br>
	 * This command is built using the {@link #getTargetCommand(String[], String, String[])} method.<br>
	 * Always be sure to use that method when you make your own commands.<br>
	 * That way, you can be sure everything is parsed correctly, and no errors will occur unless anything is wrong.
	 * @param responsible The responsible individual of this action.<br>
	 * This is used to see whether the responsible had the permissions to send this command.
	 * @param reason The reason for the restart of the server.<br>
	 * This is the message clients will see when they get kicked from the server.
	 * @return the fully-built command.
	 */
	public static String getRestartServerCommand(String responsible, String reason) {
		return getTargetCommand(new String[]{"SERVER#RESTART"}, responsible, new String[]{reason});
	}
	
	/**
	 * Returns the command representing a broadcast message on a {@link Lobby}.<br>
	 * This command is built using the {@link #getTargetCommand(String[], String, String[])} method.<br>
	 * Always be sure to use that method when you make your own commands.<br>
	 * That way, you can be sure everything is parsed correctly, and no errors will occur unless anything is wrong.
	 * @param responsible The responsible individual of this action.<br>
	 * This is used to see whether the responsible had the permissions to send this command.
	 * @param message The message of the broadcast to the server.<br>
	 * No special-characters are allowed to be used in this message.
	 * @return the fully-built command.
	 */
	public static String getBroadcastCommand(String responsible, String message) {
		return getTargetCommand(new String[]{"SERVER#BROADCAST"}, responsible, new String[]{message});
	}
	
	

	/**
	 * Returns the tags of the {@link String} formatted command.<br>
	 * The tags are used for finding the sent commands in a log.<br>
	 * A tag can be named after what it does, and where it's located.
	 * @param cmd The {@link String} formatted command to parse.
	 * @return the tags of the {@link String} formatted command.
	 */
	public static String[] getTargetTags(String cmd) {
		return cmd.split("\\{")[1].split("\\}")[0].split(":")[0].split("@")[0].split("#");
	}
	
	/**
	 * Returns the elements of the {@link String} formatted command.<br>
	 * There must be at least one element to use this function.
	 * @param cmd The {@link String} format of the command to parse.
	 * @return the elements of the {@link String} formatted command.
	 */
	public static TargetElement[] getTargetElements(String cmd) {
		// {SERVER#KICK@"":id=elementOne&name=elementTwo}
		TargetElement[] elements = new TargetElement[]{};
		for (String str: cmd.split("\\{")[1].split("\\}")[0].split(":")[1].split("&")) {
			elements[elements.length - 1] = new TargetElement(str.split("=")[0], str.split("=")[1]);
		}
		return elements;
	}
	
	/**
	 * Returns the responsible command sender of a specified command.<br>
	 * @param cmd The command in {@link String} format, to parse and find the responsible of.
	 * @return The responsible command sender of the specified command.
	 */
	public static String getTargetResponsible(String cmd) {
		return cmd.split("\\{")[1].split("\\}")[0].split(":")[0].split("@\"")[1].split("\"")[0];
	}
	
	/**
	 * Create a new command structure.<br>
	 * The only parameter that can be left to <b>null</b> is the elements.<br>
	 * Tags can be named after what the command does, and in what section of the program.
	 * @param tags The tags of the command used for finding logs in the {@link LogEngine}.
	 * @param responsible The responsible name of the person that performed the action.
	 * @param elements The elements of the command, used for getting values/arguments out of the command.
	 * @return the new command-structure as a {@link String}.
	 */
	public static String getTargetCommand(String[] tags, String responsible, String[] elements) {
		
		String finalCommand = "";
		finalCommand += "{";
		
		for (int i = 0; i < tags.length; i++) {
			if (i < tags.length - 1) {
				finalCommand += tags[i] + "#";
			} else {
				finalCommand += tags[i];
			}
		}
		
		finalCommand += "@\"";
		finalCommand += responsible + "\":";
		
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
	
}
