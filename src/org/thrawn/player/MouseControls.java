package org.thrawn.player;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.geom.Point;
import org.thrawn.main.Game;
import org.thrawn.world.tiles.Tile;

public class MouseControls {
    
	private static float x = Mouse.getY();
	private static float y = Mouse.getX();
	private static Point mousePoint;
	
	public void update() {
		x = Mouse.getX();
		y = Game.screenHeight - Mouse.getY();
	}
    
    public float getXBlockTileOn() {
    	return (EntityPlayer.offsetX + x) / Tile.size;
    }
    
    public float getYBlockTileOn() {
    	return (EntityPlayer.offsetY + y) / Tile.size;
    }
    
    public float getX() {
    	return x + EntityPlayer.offsetX;
    }

	public float getY() {
		return y + EntityPlayer.offsetY;
	}
    
}



