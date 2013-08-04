package org.player;

import org.main.Game;
import org.tools.Vector2D;

public class EntityPlayer implements Entity {
	
	public static float offsetX = 100;
	public static float offsetY = 100;

	private String name;
	private float health;
	private static Vector2D position = new Vector2D(offsetX + Game.screenWidth / 2, offsetY + Game.screenHeight / 2);
	private float walkSpeed = 0.1f;
	private float jumpHeight;
	
	public float pointPos;
	
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

}
