package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.thrawn.format.CommandFormat;

public class Client {

	private DataInputStream input;
	private DataOutputStream output;
	
	private Profile profile;
	private Socket socket;
	
	public Client(Profile profile){
		this.profile = profile;
	}
	
	public final void connect(String host, int port) throws UnknownHostException, IOException {
		
		try {
			Socket socket = new Socket(host, port);
			this.socket = socket;
			
			if (socket.isConnected()) {
				
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				
				// Send the information about the client.
				output.writeUTF(CommandFormat.getConnectionString(profile));
				
			} else {		
				System.out.println(CommandFormat.getCurrentMethodError("CONNECTION", "Could not connect to the server"));
			}
		} catch (Exception e) {
			System.out.println(CommandFormat.getCurrentMethodError("EXCEPTION", e.getMessage()));
		}	
		
	}
	
	public final Profile getProfile() {
		return this.profile;
	}
	
	public final Socket getSocket() {
		return this.socket;
	}
	
}
