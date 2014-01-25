package org.thrawn.player;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.thrawn.main.Game;
import org.thrawn.physics.Physics;

/**
 * Represents an entity that spawns automatically in the world.<br>
 * Use the constructor to set the values you want for the entity.
 */
public class EntityPlayer implements Entity {
	
	public static float offsetX = 487;
	public static float offsetY = 101;
	public static float shiftX = Game.screenWidth / 2;
	public static float shiftY = (Game.screenHeight / 2) + 12;

	private static String name;
	private static int health;
	private static boolean dead;
	private static byte[][] metadata = new byte[32][32];
	private static Rectangle position = new Rectangle(offsetX + shiftX, offsetY + shiftY, 32, 64);
	
	private static EntityCollider collider = new EntityCollider();
	
	private static float dx = 0.1f;
	private static float dy = 0.2f;
	
	private MouseControls mouse = new MouseControls();
	
	public static boolean jumping = false;
	public static boolean onTile = false;
	public static boolean hitTile = true;
	

	@Override
	public void left(int delta) {
		offsetX -= dx * delta;
		updatePosition();

		if (collider.hitTile() && collider.getHitSide()) {
			System.out.println(collider.getHitBottom() + "\t" + collider.getHitSide() + "\t" + collider.getHitTop());
			dx = 0;
		}
	}

	@Override
	public void right(int delta) {
		offsetX += dx * delta;
		updatePosition();
		
	}
	

	@Override
	public void jump(int delta) {
		if (jumping) {
			dy -= Physics.gravity;
			offsetY -= dy * delta;
			updatePosition();
		}
		
	}
	
	public void updatePosition() {
		position.setX(offsetX + shiftX);
		position.setY(offsetY + shiftY);
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
		
		updatePosition();
		collider.updateCollider(position.getX(), position.getY());
		mouse.update();
	}

	@Override
	public boolean isJumping() {
		return jumping;
	}
	
	
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
	public Rectangle getPosition() {
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
	
	@Override
	public void setJumping(boolean set) {
		jumping = set;
	}

}
