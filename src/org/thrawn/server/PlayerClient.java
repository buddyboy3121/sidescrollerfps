package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

import org.thrawn.format.CommandFormat;

public class PlayerClient implements Runnable {

	private DataOutputStream output;
	private DataInputStream input;
	
	private Profile profile;
	private Socket socket;
	private String ip_address;
	private int id;
	
	public PlayerClient(Profile profile, Socket socket) throws IOException {
		
		this.socket = socket;
		this.profile = profile;
		this.id = new Random(System.currentTimeMillis()).nextInt(1000);
		
		output = new DataOutputStream(socket.getOutputStream());
		input = new DataInputStream(socket.getInputStream());
		
	}
	
	@Override
	public void run() {
		try {
			
			ip_address = socket.getInetAddress().getHostAddress();	
			output.writeUTF(CommandFormat.getConnectionString(profile));
			output.flush();
			
		} catch (Exception e) {
			
		}
	}

	public DataOutputStream getOutputStream() {
		return this.output;
	}
	
	public DataInputStream getInputStream() {
		return this.input;
	}
	
	public int getIdentifier() {
		return this.id;
	}
	
	public Profile getProfile() {
		return this.profile;
	}
	
	public String getIPAddress() {
		return this.ip_address;
	}
	
	public Socket getSocket() {
		return this.socket;
	}
	
}
