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
import org.thrawn.format.LogType;

public class Lobby {
	
	private List<String> operators = new ArrayList<String>();
	private String welcomeMessage = "Welcome to this Lobby, ($p).";
	private List<ConnectedPlayer> connectedClients = new ArrayList<ConnectedPlayer>();
	
	private ServerSocket server;
	private Socket serverSocket;
	
	private LobbyListener lobbyListener;
	private CommandListener commandListener;
	
	public Lobby(String host, int port) throws IOException {
		
		// Initialize the Lobby/Server.
		this.server = new ServerSocket(port);
		this.serverSocket = new Socket(host, port);
		this.server.accept();
		
		System.out.println("Started the lobby @ " + port);	
		
		lobbyListener = new LobbyListener(this);
		commandListener = new CommandListener(this);
		
		new Thread(lobbyListener).start();
		new Thread(commandListener).start();
		
	}
	
	private class CommandListener implements Runnable {

		private Lobby lobby;
		
		public CommandListener(Lobby lobby) {
			this.lobby = lobby;
		}
		
		public Lobby getLobby() {
			return this.lobby;
		}
		
		@Override
		public void run() {
			
			DataInputStream cmdInput;
			System.out.println(CommandFormat.getCommandListenerString("Initialized"));
			
			try {
				
				cmdInput = new DataInputStream(lobby.getSocket().getInputStream());
				
				while (true) {
					
					String line = cmdInput.readUTF();
					String resp = CommandFormat.getResponsible(line);
					
					if (line.equals(CommandFormat.getCloseString(resp))) {
						this.lobby.getServer().close();
						this.lobby.getSocket().close();
					}
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
	
		}
		
	}
	
	private class LobbyListener implements Runnable {

		private Lobby lobby;
		
		public LobbyListener(Lobby lobby) {
			this.lobby = lobby;
		}
		
		public final Lobby getLobby() {
			return this.lobby;
		}
		
		@Override
		public void run() {
			
			DataInputStream sinput;
			PrintWriter soutput;
			
			while (true) {
				try {
					
					Socket clientSocket;
					clientSocket = lobby.server.accept();
					System.out.println(" - " + CommandFormat.getLogClientAccepted(clientSocket.getInetAddress().getHostAddress()));
					
					sinput = new DataInputStream(clientSocket.getInputStream());
					soutput = new PrintWriter(clientSocket.getOutputStream());
					
					String sout = sinput.readUTF();
					if (clientSocket.isConnected()) {
						
						System.out.println(" - " + CommandFormat.getLogClientConnected(clientSocket.getInetAddress().getHostAddress()));
						
						int id;
						String account_name;
						String first_name;
						String last_name;
						String description;
						Profile profile;
						
						String[] elements = CommandFormat.getValues(sout);
						id = new Random(System.currentTimeMillis()).nextInt(1000);
						account_name = elements[0];
						first_name = elements[1];
						last_name = elements[2];
						description = elements[4];
						
						profile = new Profile(clientSocket, account_name, first_name, last_name, description);				
						lobby.getConnectedClients().add(new ConnectedPlayer(lobby.getServer(), clientSocket, id, profile));
						System.out.println(" - " + CommandFormat.getLogProfileParsed(profile, clientSocket.getInetAddress().getHostAddress()) + "\n");
						
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
		}
		
	}
	
	/*public static void main(String[] args) throws IOException {	
		
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
			if (socket.isConnected()) {
				
				System.out.println(" - " + CommandFormat.getLogClientConnected(socket.getInetAddress().getHostAddress()));
				
				int id;
				String account_name;
				String first_name;
				String last_name;
				String description;
				Profile profile;
				
				String[] elements = CommandFormat.getValues(src_one);
				id = new Random(System.currentTimeMillis()).nextInt(1000);
				account_name = elements[0];
				first_name = elements[1];
				last_name = elements[2];
				description = elements[4];	
				
				profile = new Profile(socket, account_name, first_name, last_name, description);
				
				connectedClients.add(new ConnectedPlayer(server, socket, id, profile));			
				System.out.println(" - " + CommandFormat.getLogProfileParsed(profile, socket.getInetAddress().getHostAddress()) + "\n");
				
			}
		
		}
		
	}*/
	
	public final void setWelcomeMessage(String arg1) {
		welcomeMessage = arg1;
	}
	
	/**
	 * Send a log-message to the Lobby.
	 * @param log The log to send to the Lobby.
	 * @param type The type of log to send to the Lobby.
	 */
	public final void log(String log, LogType type) {
		switch (type) {
		case WARNING: 
			System.out.println("LOBBY - " + CommandFormat.getWarningMessage(log));
		case CAUTION:
			System.out.println("LOBBY - " + CommandFormat.getCautionMessage(log));
		case INFORMATIONAL:
			System.out.println("LOBBY - " + CommandFormat.getInformationalLogMessage(log));
		case ERROR:
			System.out.println("LOBBY - " + CommandFormat.getErrorMessage(log));
		}
	}
	
	public final List<ConnectedPlayer> getConnectedClients() {
		return this.connectedClients;
	}
	
	public final Socket getSocket() {
		return this.serverSocket;
	}
	
	public final ServerSocket getServer() {
		return this.server;
	}

}
