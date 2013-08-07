package org.thrawn.server;

public class Profile {

	private String accountName;
	private String ip_address;
	private String firstName;
	private String lastName;
	private String description;
	
	public Profile(String ip_address, String accountName, String firstName, String lastName, String desc) {
		this.accountName = accountName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = desc;
		this.ip_address = ip_address;
	}
	
	/**
	 * Returns the name of the registered account.
	 * @return the account-name.
	 */
	public String getAccountName() {
		return accountName;
	}
	
	/**
	 * Returns the IP address of the registered account.
	 * @return the IP address.
	 */
	public String getIPAddress() {
		return ip_address;
	}
	
	/**
	 * Returns the first-name of the owner.
	 * @return the first-name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the last-name of the owner.
	 * @return the last-name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Returns a short summary of yourself.
	 * @return the description.
	 */
	public String getDescription() {
		return description;
	}
	
}
