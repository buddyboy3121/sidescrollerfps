package org.player;

import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

public class KeyControls {
	
	private EntityPlayer player;
	
	public KeyControls() {
		player = new EntityPlayer();
	}
	
	public void update(StateBasedGame game, int delta) {
		Input input = game.getContainer().getInput();
		
		if (input.isKeyDown(Input.KEY_D)) {
			player.right(delta);
		}
		if (input.isKeyDown(Input.KEY_A)) {
			player.left(delta);
		}if (input.isKeyDown(Input.KEY_SPACE)) {
			player.setJumping(true);
		}
		
		input.consumeEvent();
	}
 
}
