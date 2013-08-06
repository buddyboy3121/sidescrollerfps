package org.thrawn.world;

import org.thrawn.main.Game;
import org.thrawn.player.EntityPlayer;

public class WorldUpdater {
  
	private LevelData level = new LevelData();
	private EntityPlayer player = new EntityPlayer();

	public void update() {
		int offsetX = (int) EntityPlayer.offsetX;
		int offsetY = (int) EntityPlayer.offsetY;
		
		for (int x = offsetX / Tile.size; x < (offsetX + Game.screenWidth) / Tile.size; x++) {
			
			for (int y = offsetY / Tile.size; y < (offsetY + Game.screenHeight) / Tile.size; y++) {
				
				if (level.getTileFromLevelArray(x, y) != null) {
					level.getTileFromLevelArray(x, y).update();
					
					level.getTileFromLevelArray(x, y).hit(player.getPosition().getX(), player.getPosition().getY());
				}
			}
		}
	}
}
