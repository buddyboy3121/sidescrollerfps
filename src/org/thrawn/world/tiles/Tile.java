package org.thrawn.world.tiles;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.thrawn.player.EntityPlayer;
import org.thrawn.tools.Vector2D;


public class Tile {

	private Rectangle coordinates;
	public static int size = 32;
	public Image tile;
	
	//Stores the original x and y positions.
	private float originalX, originalY;
	
	public Tile(String tileImage, float x, float y) throws SlickException {
		coordinates = new Rectangle(x, y, size, size);
		originalX = x;
		originalY = y;
		tile = new Image(tileImage);
	}
	
	/**
	 * Render the Tile with the specified {@link Graphics}.
	 * @param g The graphics to use for drawing the image.
	 */
	public void render(Graphics g) {
		g.drawImage(tile, coordinates.getX(), coordinates.getY());
		g.drawRect(coordinates.getX(), coordinates.getY(), size, size);
	}
	
	/**
	 * Returns if the player hits the block or not.
	 * @param player
	 * @return
	 */
	public boolean hit(Rectangle player) {
		if (player.intersects(coordinates)) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Set a new location for the Tile.
	 * @param x The X-coordinate.
	 * @param y The Y-coordinate.
	 */
	public void setLocation(int x, int y) {
		coordinates.setBounds(x, y, size, size);
	}
	
	/**
	 * Returns the exact location of the Tile.
	 * @return the location.
	 */
	public Rectangle getLocation() {
		return this.coordinates;
	}
	
	public void update() {
		coordinates.setX(originalX - EntityPlayer.offsetX);
		coordinates.setY(originalY - EntityPlayer.offsetY);
	}
	
}
