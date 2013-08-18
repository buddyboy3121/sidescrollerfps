package org.thrawn.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.thrawn.format.CommandFormat;

public class Profile {

	private Statistics statistics;
	private String accountName;
	private String firstName;
	private String lastName;
	private String description;
	private Socket socket;
	private Lobby lobby;
	
	public Profile(String accountName, String firstName, String lastName, String desc) {
		this.accountName = accountName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = desc;
	}
	
	public Profile(Socket socket, String accountName, String firstName, String lastName, String desc) {
		this(accountName, firstName, lastName, desc);
		this.socket = socket;
	}
	
	public Profile(Lobby lobby, Socket socket, String accountName, String firstName, String lastName, String desc) {
		this(socket, accountName, firstName, lastName, desc);
		this.lobby = lobby;
	}
	
	/**
	 * Write data to the profile.<br>
	 * The {@link Socket} must be connected and open.
	 * @param data the data.
	 * @throws IOException
	 */
	public final void write(String data) throws IOException {
		try {
			if ((socket.isConnected() && !socket.isClosed()) && (data != null && data != "")) {
				getOutputStream().writeUTF(data);
			} else {
				System.out.println(CommandFormat.getCurrentMethodError("CONNECTION", "Either the Socket is closed, or it isn't connected"));
			}
		} catch (Exception e) {
			System.out.println(CommandFormat.getCurrentMethodError("EXCEPTION", e.getMessage()));
		}	
	}
	
	/**
	 * Read data from the profile.
	 * The {@link Socket} must be connected and open.
	 * @return the data.
	 * @throws IOException
	 */
	public final String read() throws IOException {
		if ((socket.isConnected() && !socket.isClosed())) {
			return getInputStream().readUTF();
		} else {
			return null;
		}
	}
	
	/**
	 * Write data to the profile.<br>
	 * The {@link Socket} must be connected and open.
	 * @param data the data.
	 * @throws IOException
	 */
	public final void write(int data) throws IOException {
		if (socket.isConnected() && !socket.isClosed()) {
			getOutputStream().writeInt(data);
		}
	}
	
	/**
	 * Returns the name of the registered account.
	 * @return the account-name.
	 */
	public final String getAccountName() {
		return accountName;
	}
	
	/**
	 * Returns the first-name of the owner.
	 * @return the first-name.
	 */
	public final String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the last-name of the owner.
	 * @return the last-name.
	 */
	public final String getLastName() {
		return lastName;
	}
	
	/**
	 * Returns a short summary of yourself.
	 * @return the description.
	 */
	public final String getDescription() {
		return description;
	}
	
	/**
	 * Returns the socket of the profile.
	 * @return the socket.
	 */
	public final Socket getSocket() {
		return socket;
	}
	
	/**
	 * Returns the {@link Lobby} the owner of the profile is currently in.<br>
	 * Returns <b>null</b> if the owner isn't in a {@link Lobby}.
	 * @return the Lobby.
	 */
	public final Lobby getLobby() {
		return lobby;
	}
	
	/**
	 * Returns the Stream used for reading data.
	 * @return the Input-stream.
	 * @throws IOException
	 */
	public final DataInputStream getInputStream() throws IOException {
		return new DataInputStream(socket.getInputStream());
	}
	
	/**
	 * Returns the Stream used for writing data.
	 * @return the Output-stream.
	 * @throws IOException
	 */
	public final DataOutputStream getOutputStream() throws IOException {
		return new DataOutputStream(socket.getOutputStream());
	}
	
}
