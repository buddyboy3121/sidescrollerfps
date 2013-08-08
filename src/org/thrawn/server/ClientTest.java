package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client(new Profile("Nacorpio", "Gustav", "Jeppsson", "Something")).connect("localhost", 27375);
	}
	
}
