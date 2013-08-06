package org.player;

import org.main.Game;
import org.newdawn.slick.Graphics;
import org.physics.Physics;
import org.tools.Vector2D;

public class EntityPlayer implements Entity {
	
	public static float offsetX = 487;
	public static float offsetY = 100;
	public static float shiftX = Game.screenWidth / 2;
	public static float shiftY = Game.screenHeight / 2 + 13;

	private static String name;
	private static float health;
	private static boolean dead;
	private static byte[][] metadata = new byte[32][32];
	private static Vector2D position = new Vector2D(offsetX + Game.screenWidth / 2, (offsetY + Game.screenHeight / 2) + 10);
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
	
	public void setJumping(boolean set) {
		jumping = set;
	}

	@Override
	public void left(int delta) {
		position.addX(dx * -delta);
		offsetX += dx * -delta;
	}

	@Override
	public void right(int delta) {
		position.addX(dx * delta);
		offsetX += dx * delta;
	}

	@Override
	public void jump(int delta) {
		if (jumping) {
			dy -= Physics.gravity;
			offsetY -= dy * delta;
			position.addY(dy * delta);
		}
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
		g.drawRect(shiftX, shiftY, 32, 64);
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

}
