package org.thrawn.main.information;

import org.newdawn.slick.Graphics;
import org.thrawn.player.EntityPlayer;

public class Infomation {

	/**
	 * This class holds all the information and displays it on the screen.
	 * It renders all the coordinates and info on the screen.
	 */
	
	public void render(Graphics g) {
		g.drawString(String.format("ShiftX: %f\nShiftY: %f\nHit Tile: %b\nJumping: %b\nOffsetX: %f\nOffsetY: %f", EntityPlayer.shiftX,
				EntityPlayer.shiftY, EntityPlayer.onTile, EntityPlayer.jumping, EntityPlayer.offsetX, EntityPlayer.offsetY), 600, 10);
	}
}
