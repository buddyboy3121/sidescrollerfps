package org.player;

import org.tools.Vector2D;

public interface Entity {
	
	/**
	 * Returns the unique entity id of the Entity.
	 * @return the entity id.
	 */
	public String getEntityId();
	
	/**
	 * The name of the entity.
	 * @return the name.
	 */
	public String getName();
	
	/**
	 * The health of the entity.
	 * @return the health.
	 */
	public float getHealth();
	
	/**
	 * The position of the entity.
	 * @return the position.
	 */
	public Vector2D getPosition();
	
	/**
	 * The speed that the entity walks in.
	 * @return the walk-speed.
	 */
	public float getWalkSpeed();
	
	/**
	 * The jump-height of the entity.
	 * @return the jump-height.d
	 */
	public float getJumpHeight();
	
	/**
	 * Go left with the entity.
	 */
	public void left(int delta);
	
	/**
	 * Go right with the entity.
	 */
	public void right(int delta);
	
	/**
	 * Go up with the entity.
	 */
	public void up(int delta);
	
	/**
	 * Go down with the entity.
	 */
	public void down(int delta);
	
	public void connect();
	
	public void disconnect();
	
	/**
	 * Draw the entity to the world.
	 */
	public void draw();
	
}

