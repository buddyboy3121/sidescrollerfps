package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

import org.thrawn.format.CommandFormat;

public class PlayerClient implements Runnable {

	private static Scanner input;
	private static DataOutputStream output;
	private Profile profile;
	private Socket socket;
	private String ip_address;
	private int id;
	
	public PlayerClient(Profile profile, Socket socket) {
		this.socket = socket;
		this.profile = profile;
		this.id = new Random(System.currentTimeMillis()).nextInt(1000);
	}
	
	@Override
	public void run() {
		try {
			
			input  = new Scanner(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			
			ip_address = socket.getInetAddress().getHostAddress();
			
			output.writeUTF(CommandFormat.getConnectionString(profile));
			
			output.flush();
			
		} catch (Exception e) {
			
		}
	}

}