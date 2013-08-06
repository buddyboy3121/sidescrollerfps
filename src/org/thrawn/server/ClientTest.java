package org.thrawn.server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s = new Socket("localhost", 27373);
		
		PlayerClient player = new PlayerClient(new Profile("Nacorpio", "Gustav", "Jeppsson", "My name is Gustav Jeppsson."), s);
		Thread thread = new Thread(player);
		
		thread.start();
		
	}
	
}
