package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	
	private static PlayerClient player;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 27375);
		
		// DataOutputStream output = new DataOutputStream(s.getOutputStream());
		// DataInputStream input = new DataInputStream(s.getInputStream());
		
		PlayerClient p = new PlayerClient(new Profile(s, "Nacorpio", "Gustav", "Jeppsson", "My name is Gustav Jeppsson."), s);
		player = p;
		
		Thread thread = new Thread(p);
		thread.start();
		
	}
	
	public static PlayerClient getPlayer() {
		return player;
	}
	
}
