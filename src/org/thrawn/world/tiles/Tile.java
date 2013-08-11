package org.thrawn.world.tiles;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.thrawn.player.EntityPlayer;


public class Tile {

	private byte[] metadata;
	
	private Rectangle tile;
	public static int size = 32;
	public Image tileImage;
	
	//Stores the original x and y positions.
	private float originalX, originalY;
	
	public Tile(String imagePath, float x, float y) throws SlickException {
		tile = new Rectangle(x, y, size, size);
		originalX = x;
		originalY = y;
		tileImage = new Image(imagePath);
	}
	
	/**
	 * Render the Tile with the specified {@link Graphics}.
	 * @param g The graphics to use for drawing the image.
	 */
	public void render(Graphics g) {
		g.drawImage(tileImage, tile.getX(), tile.getY());
		g.drawRect(tile.getX(), tile.getY(), size, size);
	}
	
	/**
	 * Returns if the player hits the block or not.
	 * @param hitSide
	 * @return
	 */
	public boolean hit(Shape object) {
		if (object.intersects(tile)) {
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
		tile.setBounds(x, y, size, size);
	}
	
	/**
	 * Returns the exact location of the Tile.
	 * @return the location.
	 */
	public Rectangle getLocation() {
		return this.tile;
	}
	
	public byte[] getMetadata() {
		return metadata;
	}
	
	public byte getMetadata(int index) {
		return metadata[index];
	}
	
	public void setMetadata(int index, byte data) {
		metadata[index] = data;
	}
		
	public void update() {
		tile.setX(originalX - EntityPlayer.offsetX);
		tile.setY(originalY - EntityPlayer.offsetY);
	}
	
}
