package Infrastructure;

import java.awt.event.KeyEvent;

import Players.Player1;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.graphics.animation.CreatureAnimationController;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.Keyboard;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.input.PlatformingMovementController;
import de.gurkenlabs.litiengine.physics.GravityForce;

public class PlayerInput extends Keyboard {
	public PlayerInput() {}
	public static void initiate() {
		Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> System.exit(0));
	    Input.keyboard().onKeyPressed(KeyEvent.VK_SPACE, e -> Player1.instance().jump());
	    
	
		
		}
	

}
