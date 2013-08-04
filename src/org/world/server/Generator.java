package org.world.server;

import org.world.LevelData;
import org.world.Tile;

public class Generator {
	
	/**
	 * Generates {@link Tile}s to create a world.
	 */
	public void generateLevel() {
		LevelData level = new LevelData();
		
		for (int x = 0; x < LevelData.levelWidth / 32; x++) {
			
			for (int y = 0; y < LevelData.levelHeight / 32; y++) {
				level.addTile(x, y, new Tile(Tile.types.ROCK, x * 32, y * 32));
			}
		}
				
			
	}
	
}
