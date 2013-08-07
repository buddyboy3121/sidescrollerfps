package org.thrawn.player;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.thrawn.tools.Vector2D;

/**
 * Represents an interface used for creating entities.<br>
 * This must be implemented for the spawning to work correctly.
 */
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
	public Rectangle getPosition();
	
	/**
	 * Set the jump-state of the entity.
	 * @param set the jump-state.
	 */
	public void setJumping(boolean set);
	
	/**
	 * Returns whether the entity is jumping.
	 * @return whether the entity is jumping.
	 */
	public boolean isJumping();
	
	/**
	 * The speed that the entity walks in X-Axis.
	 * @return the walk-speed for X-Axis.
	 */
	public float getDX();
	
	/**
	 * The speed that the entity walks in Y-Axis.
	 * @return the walk-speed for Y-Axis.
	 */
	public float getDY();
	
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
	public void jump(int delta);
	
	/**
	 * Go down with the entity.
	 */
	public void down(int delta);
	
	public void connect();
	
	public void disconnect();
	
	/**
	 * Draw the entity to the world.
	 */
	public void draw(Graphics g);

	
}

