package org.thrawn.world;

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
	 */
	public void addTile(int tileX, int tileY, Tile tile) {
		level[tileX][tileY] = tile;
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
