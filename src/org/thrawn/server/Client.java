package org.thrawn.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.thrawn.format.CommandFormat;

public class Client {

	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private Profile profile;
	private Socket socket;
	
	public Client(Profile profile){
		this.profile = profile;
	}
	
	public final void connect(String host, int port) throws UnknownHostException, IOException {
		
		Socket socket = new Socket(host, port);
		this.socket = socket;
		
		if (socket.isConnected()) {
			
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
			
			// Send the information about the client.
			output.writeUTF(CommandFormat.getLogProfileParsed(profile, socket.getInetAddress().getHostAddress()));
			
		}
		
	}
	
	public final Profile getProfile() {
		return this.profile;
	}
	
	public final Socket getSocket() {
		return this.socket;
	}
	
}
