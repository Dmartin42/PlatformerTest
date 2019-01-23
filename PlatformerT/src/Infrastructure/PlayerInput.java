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
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;

public class PlayerInput extends Keyboard {
	public PlayerInput() {}
	public static void initiate() {
		Input.keyboard().onKeyPressed(KeyEvent.VK_ESCAPE, e -> System.exit(0));
	    Input.keyboard().onKeyPressed(KeyEvent.VK_SPACE, e -> {
	    	if(MenuScreen.Player1Selected)
	    		Player1.instance().jump();
	    	if(MenuScreen.Player2Selected)
	    		Player2.instance().jump();
	    	Sound jumpNoise = Resources.sounds().get("Resources\\spin_jump.mp3");
	    	Game.audio().playSound(jumpNoise, false);
	    });
	    Input.keyboard().onKeyPressed(KeyEvent.VK_I,e->
	    {
	    	System.out.println(Player1.instance().getLocation());
	    });
	    Input.keyboard().onKeyPressed(KeyEvent.VK_E, e -> Game.screens().display(MenuScreen.NAME));
	  
			
		

	
		
		}
	

}
