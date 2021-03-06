package org.thrawn.world;

import org.thrawn.main.Game;
import org.thrawn.player.EntityPlayer;
import org.thrawn.world.tiles.Tile;

public class WorldUpdater {
  
	private LevelData level = new LevelData();

	public void update() {
		int offsetX = (int) EntityPlayer.offsetX;
		int offsetY = (int) EntityPlayer.offsetY;
		
		for (int x = offsetX / Tile.size; x < ((offsetX + Game.screenWidth) / Tile.size) + 1; x++) {
			
			for (int y = offsetY / Tile.size; y < ((offsetY + Game.screenHeight) / Tile.size) + 1; y++) {
				
				if (level.getTileFromLevelArray(x, y) != null) {
					level.getTileFromLevelArray(x, y).update();
				}
			}
		}
	}

	
}
