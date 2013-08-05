package org.player;

import org.main.Game;
import org.tools.Vector2D;

public class EntityPlayer implements Entity {
	
	public static float offsetX = 487;
	public static float offsetY = 100;
	public static float shiftX = Game.screenWidth / 2;
	public static float shiftY = (Game.screenHeight / 2) + 100;

	private String name;
	private float health;
	private boolean dead;
	private byte[][] metadata = new byte[32][32];
	private static Vector2D position = new Vector2D(offsetX + Game.screenWidth / 2, offsetY + Game.screenHeight / 2);
	private float walkSpeed = 0.1f;
	private float jumpHeight;
	
	//private float v = mouse.getY();
	//private float w = mouse.getX();
	
	//public float pointPos = v + w;
	
	@Override
	public String getEntityId() {
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getHealth() {
		return this.health;
	}

	@Override
	public Vector2D getPosition() {
		return position;
	}

	@Override
	public float getWalkSpeed() {
		return this.walkSpeed;
	}

	@Override
	public float getJumpHeight() {
		return this.jumpHeight;
	}

	@Override
	public void left(int delta) {
		position.addX(walkSpeed * -delta);
		offsetX += walkSpeed * -delta;
	}

	@Override
	public void right(int delta) {
		position.addX(walkSpeed * delta);
		offsetX += walkSpeed * delta;
	}

	@Override
	public void up(int delta) {
		
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
	public void draw() {
		
	}

	@Override
	public boolean getIsDead() {
		return this.dead;
	}

	@Override
	public byte[][] getMetadata() {
		return this.metadata;
	}

}
