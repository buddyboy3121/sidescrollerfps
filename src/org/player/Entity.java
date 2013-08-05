package org.player;

import org.tools.Vector2D;

public interface Entity {
	
	/**
	 * Returns the unique entity id of the Entity.
	 * @return the entity id.
	 */
	public String getEntityId();
	
	/**
	 * Returns whether the entity is dead.
	 * @return the death-state.
	 */
	public boolean getIsDead();
	
	/**
	 * Returns any additional information of the entity.<br>
	 * All data must be converted to {@link Byte}.
	 * @return the additional metadata.
	 */
	public byte[][] getMetadata();
	
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
	 * @return the jump-height.
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

