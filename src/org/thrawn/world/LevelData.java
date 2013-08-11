package org.thrawn.world;

import org.newdawn.slick.SlickException;
import org.thrawn.world.tiles.Dirt;
import org.thrawn.world.tiles.Grass;
import org.thrawn.world.tiles.Rock;
import org.thrawn.world.tiles.Tile;

public class LevelData {

	public static int levelWidth = 2000;
	public static int levelHeight = 1000;
	private static Tile level[][] = new Tile[levelHeight / 32][levelWidth / 32];
	
	/**
	 * Returns the data of the Level.
	 * @return the data.
	 */
	public Tile[][] getLevel() {
		return level;
	}
	
	/**
	 * Returns the {@link Tile} at the specified coordinates.
	 * @param tileX The X-coordinate.
	 * @param tileY The Y-coordinate.
	 * @return the {@link Tile} at the specified coordinates.
	 */
	public Tile getTileFromLevelArray(int tileX, int tileY) {
		return level[tileX][tileY];
	}
	
	/**
	 * Add the specified {@link Tile} to the specified coordinates.
	 * @param tileX The X-coordinate.
	 * @param tileY The Y-coordinate.
	 * @param tile The tile to set at the specified coordinates.
	 * @throws SlickException 
	 */
	public void addTile(int tileX, int tileY, int ID) throws SlickException {
		switch(ID) {
		case 1: level[tileX][tileY] = new Rock(tileX * Tile.size, tileY * Tile.size); break;
		case 2: level[tileX][tileY] = new Grass(tileX * Tile.size, tileY * Tile.size); break;
		case 3: level[tileX][tileY] = new Dirt(tileX * Tile.size, tileY * Tile.size); break;
		}
		
	}

	/**
	 * Sets the level array in the LevelData.java to the level array that was generated inside of
	 * {@link Generator}
	 * @param generatedLevel
	 */
	public void setLevel(Tile[][] generatedLevel) {
		level = generatedLevel;
	}
	
}
