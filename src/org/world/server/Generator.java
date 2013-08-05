package org.world.server;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.world.LevelData;
import org.world.Tile;

public class Generator {
	
	private Tile generatedLevel[][] = new Tile[LevelData.levelWidth / Tile.size][LevelData.levelHeight / Tile.size];
	
	/**
	 * Generates {@link Tile}s to create a world.
	 * And sends them to {@link LevelData} to be put inside of the LevelData Level array.
	 * @throws SlickException 
	 */
	public void generateLevel() throws SlickException {
		LevelData level = new LevelData();
		
		for (int x = 0; x < LevelData.levelWidth / 32; x++) {
			
			for (int y = 0; y < LevelData.levelHeight / 32; y++) {
				
				if (y > (LevelData.levelHeight / 32) / 2) {	//Checks if Y-Axis is greater than half the world.
					
				}else if (y > ((LevelData.levelHeight / 32) / 2) + 1) { //Checks if Y-Axis is greater than half the world + 1.
					generatedLevel[x][y] = new Tile(new Image("images/tiles/dirt.png"), x * 32, y * 32);
				}
				
			}
		}
				
			level.setLevel(generatedLevel);
	}
	
}
