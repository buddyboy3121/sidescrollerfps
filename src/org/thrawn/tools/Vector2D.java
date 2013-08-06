package org.thrawn.tools;

public class Vector2D {

	private float x, y;
	
	public Vector2D(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the X coordinate.
	 * @return the X coordinate.
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * Set the new X-coordinate of the Vector.<br>
	 * * Use the {@link #setBounds(int, int)} for setting both coordinates.
	 * @param x The X-coordinate.
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Adds a float to the X-coordinate.
	 * @param x The X-coordinate.
	 */
	public void addX(float x) {
		this.x += x;
	}

	/**
	 * Returns the Y coordinate.
	 * @return the Y coordinate.
	 */
	public float getY() {
		return this.y;
	}
	
	/**
	 * Set the new y-coordinate of the Vector.<br>
	 * Use the {@link #setBounds(int, int)} for setting both coordinates.
	 * @param y The Y-coordinate.
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Adds a float to the Y-coordinate.
	 * @param y The Y-coordinate.
	 */
	public void addY(float y) {
		this.y += y;
	}
	
	/**
	 * Set the new x and y coordinates of the Vector.
	 * @param x The X-coordinate of the new bounds.
	 * @param y The Y-coordinate of the new bounds.
	 */
	public void setBounds(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
}
