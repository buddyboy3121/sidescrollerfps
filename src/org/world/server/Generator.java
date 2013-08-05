package org.world.server;

import org.world.LevelData;
import org.world.Tile;

public class Generator {
	
	private Tile generatedLevel[][] = new Tile[LevelData.levelWidth / Tile.size][LevelData.levelHeight / Tile.size];
	
	/**
	 * Generates {@link Tile}s to create a world.
	 * And sends them to {@link LevelData} to be put inside of the LevelData Level array.
	 */
	public void generateLevel() {
		LevelData level = new LevelData();
		
		for (int x = 0; x < LevelData.levelWidth / 32; x++) {
			
			for (int y = 0; y < LevelData.levelHeight / 32; y++) {
				int random = (int) (Math.random() * 3);
				
				if (y > (LevelData.levelHeight / 32) / 2) {		//Checks if Y-Axis is greater than half the world.
					generatedLevel[x][y] = new Tile(Tile.types.ROCK, x * 32, y * 32);
				}
				
			}
		}
				
			level.setLevel(generatedLevel);
	}
	
}
