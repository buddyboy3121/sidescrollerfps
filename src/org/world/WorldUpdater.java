package org.world;

import org.main.Game;
import org.player.EntityPlayer;

public class WorldUpdater {
  
	private LevelData level = new LevelData();

	public void update() {
		int offsetX = (int) EntityPlayer.offsetX;
		int offsetY = (int) EntityPlayer.offsetY;
		
		for (int x = offsetX / Tile.size; x < (offsetX + Game.screenWidth) / Tile.size; x++) {
			
			for (int y = offsetY / Tile.size; y < (offsetY + Game.screenHeight) / Tile.size; y++) {
				
				if (level.getTileFromLevelArray(x, y) != null) {
					level.getTileFromLevelArray(x, y).update();
				}
			}
		}
	}
}
