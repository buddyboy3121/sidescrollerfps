package org.thrawn.server;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JList;

import org.thrawn.format.CommandFormat;
import org.thrawn.format.CommandFormat.TargetElement;
import org.thrawn.format.LogType;

public class Lobby implements Runnable {
	
	private List<String> operators = new ArrayList<String>();
	private String welcomeMessage = "Welcome to this Lobby, ($p).";
	private List<Profile> connectedClients = new ArrayList<Profile>();
	
	private ServerSocket server;
	private Socket serverSocket;
	
	private LobbyListener lobbyListener;
	private CommandListener commandListener;
	
	public Lobby(String host, int port) throws IOException {
		
		// Initialize the Lobby/Server.
		this.server = new ServerSocket(port);
		
		this.serverSocket = new Socket(host, port);
		this.server.accept();
		
		lobbyListener = new LobbyListener(this);
		commandListener = new CommandListener(this);
		
		new Thread(lobbyListener).start();
		new Thread(commandListener).start();
		
		System.out.println(CommandFormat.getCommand(new String[]{"LOBBY"}, new String[]{"Initialized"}));
		
	}
	
	private class CommandListener implements Runnable {

		private Lobby lobby;
		private DataInputStream input;
		private DataOutputStream output;
		
		public CommandListener(Lobby lobby) {
			this.lobby = lobby;
		}
		
		public DataInputStream getInput() {
			return this.input;
		}
		
		public DataOutputStream getOutput() {
			return this.output;
		}
		
		public Lobby getLobby() {
			return this.lobby;
		}
		
		@Override
		public void run() {
			
			System.out.println(CommandFormat.getCommandListenerString("Initialized"));
			
			try {
				
				input = new DataInputStream(lobby.getSocket().getInputStream());
				output = new DataOutputStream(lobby.getSocket().getOutputStream());
				
				while (true) {
					
					String line = input.readUTF();
					TargetElement[] values = CommandFormat.getTargetElements(line);
					String resp = CommandFormat.getTargetResponsible(line);
					
					if (line.equals(CommandFormat.getCloseString(resp))) {
						
						// Close all the open connections.
						this.output.close();
						this.input.close();
						this.lobby.getSocket().close();
						this.lobby.getServer().close();
						
						System.out.println("The server closed.");
				
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
			
			System.out.println(CommandFormat.getCommand(new String[]{"LOBBY", "LISTENER"}, new String[]{"Initialized"}));
			
			while (true) {		
				try {
					
					Socket clientSocket;
					clientSocket = lobby.server.accept();				
					
					DataInputStream inputClientStream = new DataInputStream(clientSocket.getInputStream());
					ObjectOutputStream outputClientStream = new ObjectOutputStream(clientSocket.getOutputStream());
					
					Profile profile;
					String source = inputClientStream.readUTF();
					String[] values = CommandFormat.getValues(source);
					
					profile = new Profile(lobby, clientSocket, values[0], values[1], values[2], values[3]);
					
					// Now we can do whatever we want with the profile.
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public final void setWelcomeMessage(String arg1) {
		welcomeMessage = arg1;
	}
	
	public void sendCommand(String cmd) throws IOException {
		if (cmd != "") {
			commandListener.getOutput().writeUTF(cmd);
			commandListener.getOutput().flush();
		}
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
	
	public final List<Profile> getConnectedClients() {
		return this.connectedClients;
	}
	
	public final Socket getSocket() {
		return this.serverSocket;
	}

	public final ServerSocket getServer() {
		return this.server;
	}

	@Override
	public void run() {
		while (true) {
			for (Profile profile: connectedClients) {
				if (!profile.getSocket().isConnected()) {
					connectedClients.remove(profile);
				}
			}
		}
	}

}
