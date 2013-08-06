package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectedPlayer {

	private String ip_address;
	private int id;
	private Profile profile;
	private Socket player;
	
	public ConnectedPlayer(Socket player, int id, String ip_address, Profile profile) {
		this.player = player;
		this.id = id;
		this.ip_address = ip_address;
		this.profile = profile;
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
	 * Returns if the Player is still connected.
	 * @return the connection-status.
	 */
	public boolean isConnected() {
		return this.player.isConnected();
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
