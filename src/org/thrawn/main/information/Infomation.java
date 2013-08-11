package org.thrawn.main.information;

import org.newdawn.slick.Graphics;
import org.thrawn.player.EntityPlayer;
import org.thrawn.player.MouseControls;

public class Infomation {

	/**
	 * This class holds all the information and displays it on the screen.
	 * It renders all the coordinates and info on the screen.
	 */
	
	private MouseControls mouse = new MouseControls();
	
	public void render(Graphics g) {
		g.drawString(String.format("ShiftX: %f\nShiftY: %f\nHit Tile: %b\nJumping: %b\nOffsetX: %f\nOffsetY: %f" +
				"\nBlockX %f\nBlockY: %f\nX: %f\nY: %f", EntityPlayer.shiftX,
				EntityPlayer.shiftY, EntityPlayer.hitTile, EntityPlayer.jumping, EntityPlayer.offsetX, EntityPlayer.offsetY,
				mouse.getXBlockTileOn(), mouse.getYBlockTileOn(), mouse.getX(), mouse.getY()), 600, 10);
	}
}
