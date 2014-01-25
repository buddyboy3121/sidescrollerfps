package org.thrawn.server.packet;

import org.thrawn.format.CommandFormat;

public class DataPacket {

	private String name;
	private String[] data = new String[]{};
	
	public DataPacket(String par1, String... par2) {
		this.name = par1;
		this.data = par2;
	}
	
	public static final DataPacket packet(String par1, String... par2) {
		return new DataPacket(par1, par2);
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final Object[] getData() {
		return this.data;
	}
	
	public final String toString() {
		return CommandFormat.getCommand(new String[]{name}, data);
	}
	
}
