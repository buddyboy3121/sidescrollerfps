package org.world;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.player.EntityPlayer;
import org.tools.Vector2D;

public class Tile {

	private Vector2D coordinates;
	public static int size = 32;
	public Image tile;
	
	//Stores the original x and y positions.
	private float originalX, originalY;
	
	public Tile(Image tileImage, float x, float y) {
		coordinates = new Vector2D(x, y);
		originalX = x;
		originalY = y;
		tile = tileImage;
	}
	
	/**
	 * Render the Tile with the specified {@link Graphics}.
	 * @param g The graphics to use for drawing the image.
	 */
	public void render(Graphics g) {
		g.drawImage(tile, coordinates.getX(), coordinates.getY());
	}
	
	/**
	 * Returns if the player hits the block or not.
	 * @param player
	 * @return
	 */
	public boolean hit(int x, int y) {
		return false;
		//TODO 
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
	
}

