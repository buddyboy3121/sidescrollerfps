package org.thrawn.save;

import org.thrawn.world.LevelData;

public class WorldData {
	
	@SuppressWarnings("null")
	public void save(LevelData data, String fileName) {
		
		byte[][][] world_data = null;
		
		for (int a = 0; a < data.getLevel().length; a++) {
			for (int b = 0; b < data.getLevel()[a].length; b++) {
				
				world_data[a][b][0] = (byte) data.getLevel()[a][b].getLocation().getX();
				world_data[a][b][1] = (byte) data.getLevel()[a][b].getLocation().getY();
				
			}
		}
		
	}
	
}
