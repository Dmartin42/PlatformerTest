package Players;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.EntityAnimationController;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.resources.Spritesheets;

public class Player1AnimationController extends EntityAnimationController<Player1> {
	public Player1AnimationController(Player1 player) {   
		super(player, new Animation(Resources.spritesheets().get("player_front"), true), getPlayerAnimations());
	}


	private static Animation[] getPlayerAnimations () {
		ArrayList <Animation> animations = new ArrayList <Animation> ();
		animations.add(new Animation(Resources.spritesheets().get("player_front"), true));
		animations.add(new Animation(Resources.spritesheets().get("player_back"), true));
		animations.add(new Animation(Resources.spritesheets().get("player_left"), true));
		animations.add(new Animation(Resources.spritesheets().get("player_right"), true));
		return animations.toArray(new Animation[animations.size()]);
		
	}
}