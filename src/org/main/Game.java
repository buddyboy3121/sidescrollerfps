package org.main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.world.LevelData;
import org.world.server.Generator;


public class Game extends BasicGameState {

	public static int screenWidth = 1025;
	public static int screenHeight = 668;
	LevelData level = new LevelData();
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		Generator generator = new Generator();
		generator.generateLevel();
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		
		for (int x = 0; x < 800 / 32; x++) {
			
			for (int y = 0; y < 800 / 32; y++) {
				level.getTileFromLevelArray(x, y).render(g);
			}
		}
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		
	}
	
	public int getID() {
		return 0;
	}
	
}
