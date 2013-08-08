package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.thrawn.format.CommandFormat;

public class ConnectedPlayer {

	private int id;
	private Profile profile;
	private Socket socket;
	private ServerSocket server;
	private Lobby lobby;
	
	private PlayerListener playerListener;
	
	public ConnectedPlayer(PlayerClient client, Lobby lobby, Socket socket, int id, Profile profile) {
		
		this.socket = socket;
		this.id = id;
		this.profile = profile;
		this.lobby = lobby;
		
		this.playerListener = new PlayerListener(this);
		new Thread(this.playerListener).start();
		
	}
	
	private class PlayerListener implements Runnable {

		private ConnectedPlayer player;
		
		public PlayerListener(ConnectedPlayer player) {
			this.player = player;
		}
		
		public ConnectedPlayer getPlayer() {
			return this.player;
		}
		
		@Override
		public void run() {
			try {
				
				if (socket.isConnected()) {

					System.out.println(CommandFormat.getCommand(new String[]{"PLAYER", "LISTENER"}, new String[]{"Initialized"}));
					String data = (String) getClient().getInputStream().readUTF();
					
					while (true) {
						
						// getOutputStream().writeUTF("HELLO!");
						String resp = CommandFormat.getResponsible(data);
						String[] values = CommandFormat.getTargetValues(data);
						
						if (data.equals(CommandFormat.getMessageString(resp, values[0], values[1]))) {
							System.out.println(" - Message from " + resp + ": " + values[1]);
						}
						
					}
				}
							
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
	}
	
	/**
	 * Write data to the Player.
	 * @param data The data for the Player to receive.
	 * @throws IOException
	 */
	public void writeData(Object data) throws IOException {
		if (isConnected()) { // Check if the player is still connected.
			try {
				
				this.lobby.getLastPlayerOutput().write((String) data);
				this.lobby.getLastPlayerOutput().flush();
				
			} finally {
			}
		}
	}
	
	/**
	 * Send a message to the Player.
	 * @param sender The sender of the message.
	 * @param msg The message.
	 * @throws IOException
	 */
	public void sendMessage(String sender, String msg) throws IOException {
		if (msg != "" || msg != null) {
			writeData(CommandFormat.getMessageString(sender, this.getProfile().getAccountName() , msg));
		}
	}
	
	public Lobby getLobby() {
		return this.lobby;
	}
	
	/**
	 * Returns the server the client is connected to.<br>
	 * Returns <b>null</b> if connected to no server.
	 * @return the server.
	 */
	public ServerSocket getServer() {
		return this.server;
	}
	
	/**
	 * Returns if the Player is still connected.<br>
	 * @return the connection-status.
	 */
	public boolean isConnected() {
		return this.socket.isConnected();
	}
	
	public PlayerClient getClient() {
		return ClientTest.getPlayer();
	}
	
	/**
	 * Returns the profile of the player.
	 * @return the profile.
	 */
	public Profile getProfile() {
		return this.profile;
	}
	
	/**
	 * Returns the IP address of the player.
	 * @return the IP address.
	 */
	public String getIPAddress() {
		return socket.getInetAddress().getHostAddress();
	}
	
}
