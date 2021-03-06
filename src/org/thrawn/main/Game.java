package org.thrawn.main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.thrawn.main.information.Infomation;
import org.thrawn.player.EntityPlayer;
import org.thrawn.player.KeyControls;
import org.thrawn.world.LevelData;
import org.thrawn.world.WorldRenderer;
import org.thrawn.world.WorldUpdater;
import org.thrawn.world.server.Generator;
import org.thrawn.world.tiles.Rock;


public class Game extends BasicGameState {

	public static int screenWidth = 1025;
	public static int screenHeight = 668;
	
	private KeyControls keyControls;
	private WorldRenderer worldRenderer;
	private WorldUpdater worldUpdater;
	private Infomation info;
	private EntityPlayer player = new EntityPlayer();
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		Generator generator = new Generator();
		keyControls = new KeyControls();
		worldRenderer = new WorldRenderer();
		worldUpdater = new WorldUpdater();
		info = new Infomation();
	
		generator.generateLevel();
		new LevelData().addTile(23, 15, 1);
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		worldRenderer.render(g);
		player.draw(g);
		info.render(g);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		keyControls.update(game, delta);
		worldUpdater.update();
		player.update(delta);
	}
	
	public int getID() {
		return 0;
	}
	
}
