package org.main;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;



public class Main extends StateBasedGame {

	public Main(String name) {
		super(name);
	}
	
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new Game());
	}
	
	public static void main(String args[]) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Main("2d shooter"));
		
		app.setDisplayMode(800, 800, false);
		app.setAlwaysRender(true);
		app.setTargetFrameRate(60);
		
		app.start();
	}

}
