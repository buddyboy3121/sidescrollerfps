package org.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Tile {

	public int x;
	public int y;
	public types type;
	
	public Tile(types typeOfTile, int x, int y) {
		this.x = x;
		this.y = y;
		type = typeOfTile;
		
	}
	
	public void render(Graphics g) {
		
	}
	
	public void update(int delta) {
		
	}
	
	enum types {
		ROCK("images/tiles/rock.png"), STONE("images/tiles/stone.png"), GRASS("images/tiles/grass.png");
		
		Image tileImage;
		
		types(String path) {
			try {
				tileImage = new Image(path);
			}catch(SlickException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
