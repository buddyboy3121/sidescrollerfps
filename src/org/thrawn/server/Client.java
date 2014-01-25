package org.thrawn.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.thrawn.format.CommandFormat;

public class Client implements Runnable {

	private int session_id;
	
	private Map<String, Object> values = new HashMap<String, Object>();
	private Socket socket;
	
	public Client(Socket par1) {
		this.socket = par1;
	}
	
	public final String getServerName() {
		return String.valueOf(values.get("NAME"));
	}
	
	public final Map<String, Object> getValues() {
		return this.values;
	}
	
	public final Socket getSocket() {
		return this.socket;
	}
	
	public void onPlayerKicked(String par1, boolean par2) throws IOException {
		if (!par2) {
			if (par1 != null) {
				System.out.println(">> You were kicked from the server. [Reason: " + par1 + "]");
			}			
		}
		socket.close();
	}
	
	public void onServerFull() throws IOException {
		System.out.println(">> The server is currently full.");
	}
	
	public void onPlayerBanned(String par1) throws IOException {
		System.out.println(">> You were banned from the server. [Reason: " + par1 + "]");
		this.onPlayerKicked(par1, true);
	}
	
	public void onPlayerJoined() {
		this.session_id = Integer.parseInt(values.get("SESSION_ID").toString());
		System.out.println(">> You were assigned the session_id \'" + session_id + "\'.");
		System.out.println(">> " + String.valueOf(values.get("WELCOME_MSG")));
	}
	
	@Override
	public void run() {
		try {
			
			DataInputStream dIn = new DataInputStream(socket.getInputStream());
			Scanner in = new Scanner(socket.getInputStream());	
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			while (true) {
				
				byte type = dIn.readByte();
				
				switch (type) {
				case 1:		
					String utf = dIn.readUTF();
					values.put(CommandFormat.getTags(utf)[0], CommandFormat.getValues(utf)[0]);
					if (values.size() == 5) {
						this.onPlayerJoined();
					}
					break;
				case 2:			
					this.onPlayerKicked(dIn.readUTF(), false);
					break;
				case 3:		
					this.onPlayerBanned(dIn.readUTF());
					break;
				case 4:
					this.onServerFull();
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 9:
					break;
				case -1:
					this.onPlayerKicked(null, false);
					break;
				}
				
			}

		} catch (Exception e) {
			
		}
	}
	
}
