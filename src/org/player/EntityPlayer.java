package org.player;

import org.tools.Vector2D;

public class EntityPlayer implements Entity {
	
	public static int offsetX = 0;
	public static int offsetY = 0;

	private String name;
	private float health;
	private static Vector2D position;
	private float walkSpeed = 0.02f;
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
	}

	@Override
	public void right(int delta) {
		position.addX(walkSpeed * delta);
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
