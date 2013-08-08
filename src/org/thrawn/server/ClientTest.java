package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 27373);
		
		// DataOutputStream output = new DataOutputStream(s.getOutputStream());
		// DataInputStream input = new DataInputStream(s.getInputStream());
		
		PlayerClient player = new PlayerClient(new Profile(s, "Nacorpio", "Gustav", "Jeppsson", "My name is Gustav Jeppsson."), s);
		
		Thread thread = new Thread(player);
		thread.start();
		
	}
	
}
