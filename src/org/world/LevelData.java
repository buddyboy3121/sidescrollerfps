package org.world;

import org.main.Game;

public class LevelData {

	public static int levelWidth = 2000;
	public static int levelHeight = 2000;
	private static Tile level[][] = new Tile[levelHeight / 32][levelWidth / 32];
	
	public Tile[][] getLevel() {
		return level;
	}
	
	public Tile getTileFromLevelArray(int tileX, int tileY) {
		return level[tileX][tileY];
	}
	
	public void addTile(int tileX, int tileY, Tile tile) {
		level[tileX][tileY] = tile;
	}
	
}
