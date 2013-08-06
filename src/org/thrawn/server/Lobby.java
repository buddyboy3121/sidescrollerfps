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
	
	public static void main(String[] args) throws IOException {	
		
		server = new ServerSocket(27373);
		Socket socket;
		
		// Starts a server at the local network for now.
		System.out.println("Started the lobby @ 27374");
		
		while (true) {
			
			// The player is accepted into the lobby.
			socket = server.accept();
			input = new DataInputStream(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());
			
			// Print into the console that a client has joined the game.
			System.out.println(" - {CLIENT#CONNECTION:" + socket.getInetAddress().getHostAddress() + "}");
			
			@SuppressWarnings("deprecation")
			String readOne = input.readLine();
			String rOne = readOne.split("\\?")[0];
			String rTwo = readOne.split("\\?")[1];
			
			String ip_address;
			int id;
			
			ip_address = rOne.split("\\{")[1].split("\\}")[0].split("#")[0];
			id = Integer.parseInt(rOne.split("\\{")[1].split("\\}")[0].split("#")[1]);
			
			// Profile:
			String parsedTwo;
			String[] elements;
			
			String accountName;
			String firstName;
			String lastName;
			String description;
		
			String readTwo = rTwo;
			parsedTwo = readTwo.split("\\{")[1].split("\\}")[0].split(": ")[1];
			elements = parsedTwo.split(", ");
			
			accountName = elements[0];
			firstName = elements[1];
			lastName = elements[2];
			description = elements[3];
			
			output.write("{#MSG:" + welcomeMessage.replaceAll("($p)", accountName) + "}");
			output.flush();
			
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
