package org.thrawn.world.server;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.thrawn.world.LevelData;
import org.thrawn.world.tiles.Dirt;
import org.thrawn.world.tiles.Grass;
import org.thrawn.world.tiles.Rock;
import org.thrawn.world.tiles.Tile;

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
				if (y > ((LevelData.levelHeight / 32) / 2) + 5) {
					int random = (int) (Math.random() * 50);
					
					if (random == 1) {
						generatedLevel[x][y] = new Rock(x * 32, y * 32);
					}else{
						generatedLevel[x][y] = new Dirt(x * 32, y * 32);
					}
				} else if (y > ((LevelData.levelHeight / 32) / 2) + 1) { //Checks if Y-Axis is greater than half the world + 1.
					generatedLevel[x][y] = new Dirt(x * 32, y * 32);
				} else if (y > (LevelData.levelHeight / 32) / 2) {	//Checks if Y-Axis is greater than half the world.
					generatedLevel[x][y] = new Grass(x * 32, y * 32);
				}
				
			}
		}
				
			level.setLevel(generatedLevel);
	}
	
}
