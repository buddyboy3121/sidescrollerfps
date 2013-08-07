package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Lobby {
	
	private static String welcomeMessage = "Welcome to this Lobby, ($p).";
	private static List<ConnectedPlayer> connectedClients;
	private static ServerSocket server;
	private static DataInputStream input;
	private static PrintWriter output;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {	
		
		server = new ServerSocket(27373);
		Socket socket;
		
		// Starts a server at the local network for now.
		System.out.println("Started the lobby @ 27374");
		
		while (true) {
			
			// The player is accepted into the lobby.
			socket = server.accept();
			
			// Initialize the streams to read and write data to the new Player.
			input = new DataInputStream(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());
			
			String src_one = input.readUTF();
			
			// Print into the console that a client has joined the game.
			System.out.println(" - {CLIENT#CONNECTION:" + socket.getInetAddress().getHostAddress() + "}");
			
			int id;
			String ip_address;
			String account_name;
			String first_name;
			String last_name;
			String description;
			Profile profile;
			
			String[] elements = src_one.split("#");
			ip_address = elements[0];
			id = Integer.parseInt(elements[1]);
			account_name = elements[2];
			first_name = elements[3];
			last_name = elements[4];
			description = elements[5].split("\"")[1].split("\"")[0];
			profile = new Profile(ip_address, account_name, first_name, last_name, description);
			
		}
		
	}

	public static DataInputStream getInputStream() {
		return input;
	}
	
	public static PrintWriter getOutputStream() {
		return output;
	}
	
	public static List<ConnectedPlayer> getConnectedClients() {
		return connectedClients;
	}
	
	public static ServerSocket getServer() {
		return server;
	}

}
