package org.thrawn.player;

import org.newdawn.slick.Graphics;
import org.thrawn.main.Game;
import org.thrawn.physics.Physics;
import org.thrawn.tools.Vector2D;

/**
 * Represents an entity that spawns automatically in the world.<br>
 * Use the constructor to set the values you want for the entity.
 */



public class EntityPlayer implements Entity {
	
	public static float offsetX = 487;
	public static float offsetY = 100;
	public static float shiftX = Game.screenWidth / 2;
	public static float shiftY = Game.screenHeight / 2 + 13;

	private static String name;
	private static float health;
	private static boolean dead;
	private static byte[][] metadata = new byte[32][32];
	private static Vector2D position = new Vector2D(offsetX + (Game.screenWidth / 2), (offsetY + Game.screenHeight / 2));
	private static float dx = 0.1f;
	private static float dy = 0.22f;
	
	public static boolean jumping = false;
	
	
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
	public Vector2D getPosition() {
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
		offsetX += dx * -delta;
		updatePosition();
	}

	@Override
	public void right(int delta) {
		offsetX += dx * delta;
		updatePosition();
	}

	@Override
	public void jump(int delta) {
		if (jumping) {
			dy -= Physics.gravity;
			offsetY -= dy * delta;
			position.addY(dy * delta);
		}
	}
	
	public void updatePosition() {
		position.setX(offsetX + shiftX);
		position.setY(offsetY - shiftY);
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
		g.drawRect(position.getX(), position.getY(), 32, 64);
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
