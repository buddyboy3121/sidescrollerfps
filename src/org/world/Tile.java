package org.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.player.EntityPlayer;
import org.tools.Vector2D;

public class Tile {

	private Vector2D coordinates;
	public static int size = 32;
	public types type;
	
	//Stores the original x and y positions.
	private int originalX, originalY;
	
	public Tile(types typeOfTile, int x, int y) {
		coordinates = new Vector2D(x, y);
		type = typeOfTile;
		originalX = x;
		originalY = y;
	}
	
	/**
	 * Render the Tile with the specified {@link Graphics}.
	 * @param g The graphics to use for drawing the image.
	 */
	public void render(Graphics g) {
		g.drawImage(type.tileImage, coordinates.getX(), coordinates.getY());
	}
	
	/**
	 * Set a new location for the Tile.
	 * @param x The X-coordinate.
	 * @param y The Y-coordinate.
	 */
	public void setLocation(int x, int y) {
		coordinates.setBounds(x, y);
	}
	
	public void update() {
		coordinates.setX(originalX - EntityPlayer.offsetX);
		coordinates.setY(originalY - EntityPlayer.offsetY);
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

