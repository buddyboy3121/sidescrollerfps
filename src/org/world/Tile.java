package org.world;

public class Tile {

	public int x;
	public int y;
	public types type;
	
	public Tile(types typeOfTile, int x, int y) {
		this.x = x;
		this.y = y;
		type = typeOfTile;
		
	}
	
	
	enum types {
		ROCK, STONE, GRASS, WOOD, 
	}
}
