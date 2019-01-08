package Infrastructure;

import java.awt.event.KeyEvent;
import java.util.function.Consumer;

import Players.Player1;
import Players.Player2;
import Screens.MenuScreen;
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
	    Input.keyboard().onKeyPressed(KeyEvent.VK_SPACE, e -> {
	    	if(MenuScreen.Player1Selected)
	    		Player1.instance().jump();
	    	if(MenuScreen.Player2Selected)
	    		Player2.instance().jump();
	    });
	    Input.keyboard().onKeyPressed(KeyEvent.VK_E, e -> Game.screens().display(MenuScreen.NAME));
	  
			/*Input.keyboard().onKeyPressed(KeyEvent.VK_UP, (key) -> this.changeDirection(Direction.UP));
			Input.keyboard().onKeyPressed(KeyEvent.VK_DOWN, (key) -> this.changeDirection(Direction.DOWN));
			Input.keyboard().onKeyPressed(KeyEvent.VK_LEFT, (key) -> this.changeDirection(Direction.LEFT));
			Input.keyboard().onKeyPressed(KeyEvent.VK_RIGHT, (key) -> this.changeDirection(Direction.RIGHT));
		
*/
	
		
		}
	

}
