package org.thrawn.player;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.thrawn.main.Game;
import org.thrawn.physics.Physics;
import org.thrawn.world.LevelData;
import org.thrawn.world.tiles.Tile;

/**
 * Represents an entity that spawns automatically in the world.<br>
 * Use the constructor to set the values you want for the entity.
 */



public class EntityPlayer implements Entity {
	
	public static float offsetX = 487;
	public static float offsetY = 100;
	public static float shiftX = Game.screenWidth / 2;
	public static float shiftY = (Game.screenHeight / 2) + 14;

	private static String name;
	private static int health;
	private static boolean dead;
	private static byte[][] metadata = new byte[32][32];
	private static Rectangle position = new Rectangle(offsetX + shiftX, offsetY + shiftY, 32, 64);
	private static float dx = 0.1f;
	private static float dy = 0.2f;
	
	private LevelData level = new LevelData();
	
	public static boolean jumping = false;
	public static boolean onTile = false;
	
	
	// private float v = mouse.getY();
	// private float w = mouse.getX();
	
	// public float pointPos = v + w;
	//private float v = mouse.getY();
	//private float w = mouse.getX();
	
	
	@Override
	public String getEntityId() {
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getHealth() {
		return health;
	}

	@Override
	public Rectangle getPosition() {
		return position;
	}

	@Override
	public float getDX() {
		return dx;
	}
	
	@Override
	public float getDY() {
		return dy;
	}
	
	@Override
	public void setJumping(boolean set) {
		jumping = set;
	}

	@Override
	public void left(int delta) {
		offsetX -= dx * delta;
		updatePosition();
		hitTile();
	}

	@Override
	public void right(int delta) {
		offsetX += dx * delta;
		updatePosition();
		hitTile();
	}

	@Override
	public void jump(int delta) {
		if (jumping) {
			dy -= Physics.gravity;
			offsetY -= dy * delta;
			updatePosition();
			
			//If you hit a tile going down, stop jumping.
			if (hitTile() && dy < 0) {
				jumping = false;
				dy = 0.2f;
			}
		}
	}
	
	public void updatePosition() {
		position.setX(offsetX + shiftX);
		position.setY(offsetY + shiftY);
	}
	
	public boolean hitTile() {
		for (int x = (int) (offsetX / Tile.size); x < (offsetX + Game.screenWidth) / Tile.size; x++) {
			
			for (int y = (int) (offsetY / Tile.size); y < (offsetY + Game.screenHeight) / Tile.size; y++) {
				
				if (level.getTileFromLevelArray(x, y) != null) {
					
					if (level.getTileFromLevelArray(x, y).hit(position)) {
						onTile = true;
						return true;
						
					}
				}
			}
		}
		
		onTile = false;
		return false;
	}

	@Override
	public void down(int delta) {
		
	}

	@Override
	public void connect() {
		
	}

	@Override
	public void disconnect() {
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(shiftX, shiftY, 32, 62);
	}

	@Override
	public boolean getIsDead() {
		return dead;
	}

	@Override
	public byte[][] getMetadata() {
		return metadata;
	}

	/**
	 * Updates all the stuff that needs to be in a constant loop. {@link Game}
	 * @param delta
	 */
	public void update(int delta) {
		
		if (jumping) {
			jump(delta);
		}
		
	}

	@Override
	public boolean isJumping() {
		return jumping;
	}

}
