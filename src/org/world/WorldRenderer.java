package org.world;

import org.main.Game;
import org.newdawn.slick.Graphics;
import org.player.EntityPlayer;

public class WorldRenderer {
	
	private LevelData level = new LevelData();

	/**
	 * Render the world with the specified {@link Graphics} object.
	 * @param g The graphics object to use for rendering the world.
	 */
	public void render(Graphics g) {
		int offsetX = (int) EntityPlayer.offsetX;
		int offsetY = (int) EntityPlayer.offsetY;
		
		for (int x = offsetX / Tile.size; x < (offsetX + Game.screenWidth) / Tile.size; x++) {
			
			for (int y = offsetY / Tile.size; y < (offsetY + Game.screenHeight) / Tile.size; y++) {
				level.getTileFromLevelArray(x, y).render(g);
			}
		}
	}
}
