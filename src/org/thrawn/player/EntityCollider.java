package org.thrawn.player;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.thrawn.main.Game;
import org.thrawn.world.LevelData;
import org.thrawn.world.tiles.Tile;

public class EntityCollider {
	
	private Line positions[] = new Line[4];
	private boolean hitSide, hitTop, hitBot;
	
	private LevelData level;

	public EntityCollider() {
		level = new LevelData();
		
		positions[0] = new Line(0, 0, 32, 1); //Feet.
		positions[1] = new Line(0, 0, 32, 1); //Head.
		positions[2] = new Line(0, 0, 1, 62); //Left side.
		positions[3] = new Line(0, 0, 1, 62); //Right side.
	}
	
	public boolean hitTile() {
		float offsetX = EntityPlayer.offsetX; //Player offsetX
		float offsetY = EntityPlayer.offsetY; //Player offsetY
		
		for (int x = (int) (offsetX / Tile.size); x < (offsetX + Game.screenWidth) / Tile.size; x++) {
			
			for (int y = (int) (offsetY / Tile.size); y < (offsetY + Game.screenHeight) / Tile.size; y++) {
				Tile tile = level.getTileFromLevelArray(x, y);
				
				if (tile != null) {
					
					if (tile.hit(positions[0])) {
						hitBot = true;
					}else{
						hitBot = false;
					}
					
					if (tile.hit(positions[1])) {
						hitTop = true;
					}else{
						hitTop = false;
					}
					
					if (tile.hit(positions[2])) {
						hitSide = true;
						System.out.println("YAYYA");
					}else{
						hitSide = false;
					}
					
					if (hitSide || hitTop || hitBot) {	//Returns true if the tile is hit in any way.
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Updates the location of the hit markers.
	 * @param position 
	 */
	public void updateCollider(float x, float y) {
		positions[0].set(x, y + 64, 32, 1); //Feet.
		positions[1].set(x, y, 32, 1); //Head.
		positions[2].set(x, y + 1, 1, 62); //Left side.
		positions[3].set(x + 32, y + 1, 1, 62); //Right side.
	}
	
	public void draw(Graphics g) {
		g.draw(positions[0]);
	}
	
	public boolean getHitBottom() {
		return hitBot;
	}
	
	public boolean getHitTop() {
		return hitTop;
	}
	
	public boolean getHitSide() {
		return hitSide;
	}
}
