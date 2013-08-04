package org.player;

import org.tools.Vector2D;

public class EntityPlayer implements Entity {

	private String name;
	private float health;
	private Vector2D position;
	private float walkSpeed;
	private float jumpHeight;
	
	@Override
	public String getEntityId() {
		// TODO Auto-generated method stub
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
		return this.position;
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
	public void left() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void right() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void down() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
