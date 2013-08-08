package org.thrawn.format;

import org.thrawn.server.Profile;

public final class CommandFormat {

	public static boolean isCommandFormat(String cmd) {
		return cmd.matches("{(.*?)#(.*?)@(.*?):(.*?)}");
	}
	
	public static String getConnectionString(Profile profile) {
		return "{SERVER#EVENT#NEW_CLIENT:" + profile.getAccountName() + "&" + profile.getFirstName() + "&" + profile.getLastName() + "&" + profile.getIPAddress() + "&\"" + profile.getDescription() + "\"}";
	}
	
	/**
	 * Returns all the values in a connection-string.
	 * @param conString The connection-string.
	 * @return the values of the string.
	 */
	public static String[] getConnectionValues(String conString) {
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
		return "{CLIENT#EVENT#PROFILE_PARSED:" + profile.getAccountName() + "&" + ipAddress + "}";
	}
	
	public static String getLogClientAccepted(String ipAddress) {
		return "{CLIENT#EVENT#ACCEPTED:" + ipAddress + "}";
	}
	
	public static String getLogClientConnected(String ipAddress) {
		return "{CLIENT#EVENT#CONNECT:" + ipAddress + "}";
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
	
	public static String[] getValues(String cmd) {
		if (cmd.matches("{.*?#.*?@.*?}")) {
			return null;
		} else if (cmd.matches("{(.*?)#(.*?)@(.*?):(.*?)}")) {
			return cmd.split("\\{")[1].split("\\}")[0].split(":")[1].split("&");
		} else {
			return null;
		}
	}
	
	public static String getCloseString(String responsible) {
		return "{SERVER#CLOSE@" + responsible + "}";
	}
	
}
