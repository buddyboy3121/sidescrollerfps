package org.thrawn.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.thrawn.format.CommandFormat;

public class Lobby {

	private static String name;
	private static String welcome_message = "Welcome to my Lobby!";
	private static int players = 0;
	
	private static Map<String, Object> clients = new HashMap<String, Object>();
	private static List<String> bannedList = new ArrayList<String>();
	
	private static final int MAX_PLAYERS = 10;
	private static final int PORT = 5667;
	
	private static ServerSocket server;
	
	public static void main(String[] par1) {
		try {
			
			server = new ServerSocket(PORT);
			
			System.out.println(">> Started a server on port " + PORT + ".");
			System.out.println(">> The server can now accept connections.");
			
			System.out.println();
			
			while (true) {
				
				Socket var1 = server.accept();
				
				System.out.println(">> A player joined the lobby (" + var1.getLocalAddress().getHostAddress() + ").");
				players++;
				
				DataOutputStream varOutput1 = new DataOutputStream(var1.getOutputStream());
				
				send(varOutput1, CommandFormat.getCommand(new String[]{"NAME"}, name), 1);
				send(varOutput1, CommandFormat.getCommand(new String[]{"PLAYER_COUNT"}, String.valueOf(players)), 1);
				send(varOutput1, CommandFormat.getCommand(new String[]{"MAX_PLAYERS"}, String.valueOf(MAX_PLAYERS)), 1);
				send(varOutput1, CommandFormat.getCommand(new String[]{"WELCOME_MSG"}, welcome_message), 1);
				
				int id = new Random().nextInt(999999);
				while (clients.containsKey(id)) {
					id = new Random().nextInt(999999);
				}
				
				send(varOutput1, CommandFormat.getCommand(new String[]{"SESSION_ID"}, String.valueOf(id)), 1);
				
				if (players > MAX_PLAYERS) {
					send(varOutput1, null, 4);
					var1.close();
				}
				
				Client client = new Client(var1);
				
				clients.put(String.valueOf(id), client);	
				new Thread(client).start();
				
			}
			
		} catch (Exception e) {
			
		}
	}

	public static final void send(DataOutputStream par1, String par2, int par3) throws IOException {
		par1.writeByte(par3);
		if (par2 != null) {
			par1.writeUTF(par2);
		}		
		par1.flush();
	}
	
}
