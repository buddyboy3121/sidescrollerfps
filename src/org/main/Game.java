package org.main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.player.KeyControls;
import org.world.WorldRenderer;
import org.world.WorldUpdater;
import org.world.server.Generator;


public class Game extends BasicGameState {

	public static int screenWidth = 1025;
	public static int screenHeight = 668;
	
	private KeyControls keyControls;
	private WorldRenderer worldRenderer;
	private WorldUpdater worldUpdater;
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		Generator generator = new Generator();
		keyControls = new KeyControls();
		worldRenderer = new WorldRenderer();
		worldUpdater = new WorldUpdater();
		
		generator.generateLevel();
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		worldRenderer.render(g);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		keyControls.update(game, delta);
		worldUpdater.update();
	}
	
	public int getID() {
		return 0;
	}
	
}
