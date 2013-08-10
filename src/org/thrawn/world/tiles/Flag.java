package org.thrawn.world.tiles;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.thrawn.player.EntityPlayer;

public class Flag {

private byte[] metadata;
	
	private Rectangle coordinates;
	
	public static int height = 32 * 4;
	public static int width = 32;
	
	public Image texture;
	
	//Stores the original x and y positions.
	private float originalX, originalY;
	
	public Flag(String tileImage, float x, float y) throws SlickException {
		coordinates = new Rectangle(x, y, height, width);
		originalX = x;
		originalY = y;
		texture = new Image(tileImage);
	}
	
	/**
	 * Render the Tile with the specified {@link Graphics}.
	 * @param g The graphics to use for drawing the image.
	 */
	public void render(Graphics g) {
		g.drawImage(texture, coordinates.getX(), coordinates.getY());
		g.drawRect(coordinates.getX(), coordinates.getY(), height, width);
	}
	
	/**
	 * Returns if the player hits the block or not.
	 * @param player
	 * @return
	 */
	public boolean hit(Rectangle player) {
		if (player.intersects(new Rectangle(originalX, originalY, height, width))) {
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
		coordinates.setBounds(x, y, height, width);
	}
	
	/**
	 * Returns the exact location of the Tile.
	 * @return the location.
	 */
	public Rectangle getLocation() {
		return this.coordinates;
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
		coordinates.setX(originalX - EntityPlayer.offsetX);
		coordinates.setY(originalY - EntityPlayer.offsetY);
	}
	
}
