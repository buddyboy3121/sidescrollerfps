package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectedPlayer {

	private int id;
	private Profile profile;
	private Socket player;
	private ServerSocket server;
	
	public ConnectedPlayer(ServerSocket server, Socket player, int id, Profile profile) {
		this.player = player;
		this.id = id;
		this.profile = profile;
		this.server = server;
	}
	
	/**
	 * Write data to the Player.
	 * @param data The data for the Player to receive.
	 * @throws IOException
	 */
	public void writeData(String data) throws IOException {
		if (isConnected()) { // Check if the player is still connected.
			this.getOutputStream().writeUTF(data);
			this.getOutputStream().flush();
		}
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
		return this.player.isConnected();
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
		return player.getInetAddress().getHostAddress();
	}
	
	/**
	 * Returns the DataInputStream of the Connected Player.
	 * @return the DataInputStream.
	 * @throws IOException
	 */
	public DataInputStream getInputStream() throws IOException {
		return new DataInputStream(player.getInputStream());
	}
	
	/**
	 * Returns the DataOutputStream of the Connected Player.
	 * @return the DataOutputStream.
	 * @throws IOException
	 */
	public DataOutputStream getOutputStream() throws IOException {
		return new DataOutputStream(player.getOutputStream());
	}
	
}
