package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.thrawn.format.CommandFormat;

public abstract class Lobby {
	
	private static List<String> operators = new ArrayList<String>();
	private static String welcomeMessage = "Welcome to this Lobby, ($p).";
	private static List<ConnectedPlayer> connectedClients = new ArrayList<ConnectedPlayer>();
	
	private static ServerSocket server;
	private static Socket serverSocket;
	
	private static DataInputStream serverInput;
	private static PrintWriter serverOutput;
	
	private static DataInputStream input;
	private static PrintWriter output;
	
	public static void main(String[] args) throws IOException {	
		
		server = new ServerSocket(27373);
		//serverSocket = new Socket(server.getInetAddress().getHostAddress(), 27373);
		
		//serverInput = new DataInputStream(serverSocket.getInputStream());
		//serverOutput = new PrintWriter(serverSocket.getOutputStream());
		
		Socket socket;
		
		// Starts a server at the local network for now.
		System.out.println("Started the lobby @ 27373");
		
		while (true) {
			
			// listener();
			
			// The player is accepted into the lobby.
			socket = server.accept();
			System.out.println(" - " + CommandFormat.getLogClientAccepted(socket.getInetAddress().getHostAddress()));
			
			// Initialize the streams to read and write data to the new Player.
			input = new DataInputStream(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());

			String src_one = input.readUTF();
			// if (socket.isConnected()) {
				
				System.out.println(" - " + CommandFormat.getLogClientConnected(socket.getInetAddress().getHostAddress()));
				
				int id;
				String account_name;
				String first_name;
				String last_name;
				String description;
				Profile profile;
				
				String[] elements = CommandFormat.getConnectionValues(src_one);
				id = new Random(System.currentTimeMillis()).nextInt(1000);
				account_name = elements[0];
				first_name = elements[1];
				last_name = elements[2];
				description = elements[4].split("\"")[1].split("\"")[0];		
				
				profile = new Profile(socket, account_name, first_name, last_name, description);
				
				connectedClients.add(new ConnectedPlayer(server, socket, id, profile));			
				System.out.println(" - " + CommandFormat.getLogProfileParsed(profile, socket.getInetAddress().getHostAddress()) + "\n");
				
			// }
		
		}
		
	}

	private static void listener() throws IOException {
		
			String latestString = serverInput.readUTF();
			
			if (CommandFormat.isCommandFormat(latestString)) {
				String responsible = CommandFormat.getResponsible(latestString);
				String[] values = CommandFormat.getValues(latestString);
				
				// Check whether the sender is an operator.
				if (operators.contains(responsible)) {
					
					if (latestString == CommandFormat.getCloseString(responsible)) {
						if (!server.isClosed()) {
							server.close();
						}
					} else if (latestString == CommandFormat.getBroadcastString(responsible, values[0])) {
						// Send a broadcast message.
					} else if (latestString == CommandFormat.getKickString(responsible, values[0], values[1])) {
						
						for (ConnectedPlayer player: connectedClients) {
							if (player.getProfile().getAccountName().equalsIgnoreCase(values[0])) {
								// Kick the player.
							}
						}
						
					} else if (latestString == CommandFormat.getPrivateMessageString(responsible, values[0], values[1])){
						
						String res = responsible;
						String receiver = values[0];
						String message = values[1];
						
						for (ConnectedPlayer player: connectedClients) {
							if (player.getProfile().getAccountName().equalsIgnoreCase(receiver)) {
								player.writeData(CommandFormat.getMessageString(res, receiver, message));
							}
						}
						
					}
					
				}
			}
			
	}
	
	/**
	 * Occurs when a client joins the lobby.<br>
	 * The client must be connected to fire this event.
	 * @param socket The socket of the client.
	 */
	public abstract void onClientJoined(Socket socket);
	
	public static DataInputStream getInputStream() {
		return serverInput;
	}
	
	public static PrintWriter getOutputStream() {
		return serverOutput;
	}
	
	public static List<ConnectedPlayer> getConnectedClients() {
		return connectedClients;
	}
	
	public static ServerSocket getServer() {
		return server;
	}

}
