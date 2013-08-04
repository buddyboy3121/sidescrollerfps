package org.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.tools.Vector2D;

public class Tile {

	private Vector2D coordinates;
	public types type;
	
	public Tile(types typeOfTile, int x, int y) {
		coordinates = new Vector2D(x, y);
		type = typeOfTile;
	}
	
	public void render(Graphics g) {
		g.drawImage(type.tileImage, coordinates.getX(), coordinates.getY());
	}
	
	public void setLocation(int x, int y) {
		coordinates.setBounds(x, y);
	}
	
	public void update(int delta) {
		
	}
	
	public enum types {
		ROCK("images/tiles/rock.png"), STONE("images/tiles/stone.png"), GRASS("images/tiles/grass.png");
		
		public Image tileImage;
		
		private types(String path) {
			try {
				
				Image image = new Image("images/tiles/rock.png");
				tileImage = image;
			}catch(SlickException e) {
				e.printStackTrace();
			}
		}
	}
	
}
