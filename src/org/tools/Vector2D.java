package org.tools;

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
	 * Set the new X-coordinate of the Vector.
	 * @param x The X-coordinate.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the Y coordinate.
	 * @return the Y coordinate.
	 */
	public float getY() {
		return this.y;
	}
	
	/**
	 * Set the new y-coordinate of the Vector.
	 * @param y The Y-coordinate.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Set the new x and y coordinates of the Vector.
	 * @param x
	 * @param y
	 */
	public void setBounds(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
