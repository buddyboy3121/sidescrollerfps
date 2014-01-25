package org.thrawn.server.client;

import java.net.Socket;

import org.thrawn.server.Client;

public class LocalClient {

	public static void main(String[] par1) {
		connect("localhost", 5667);
	}
	
	public static final void connect(String par1, int par2) {
		try {
			
			Socket var1 = new Socket(par1, par2);
			System.out.println(">> Connected to the server on " + par1 + " @ " + par2 + ".");
			
			Client var2 = new Client(var1);
			new Thread(var2).start();
			
		} catch (Exception e) {
			
			System.out.println(">> Couldn't find a server running on " + par1 + " @ " + par2 + ".");
			System.out.println(">> Make sure that the server is running, and then retry.");
			
		}
	}
	
	public void onServerConnected() {
		
	}
	
}
