package Screens;

import java.util.ArrayList;

import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.AnimationController;
import de.gurkenlabs.litiengine.resources.Resources;

public class ScreenPlayer1Animator extends AnimationController {
	public ScreenPlayer1Animator() {
		super(new Animation(Resources.spritesheets().get("player_right"), true), getPlayerAnimations());
	}
	private static Animation[] getPlayerAnimations () {
		ArrayList <Animation> animations = new ArrayList <Animation> ();
		animations.add(new Animation(Resources.spritesheets().get("player_right"), true));
		animations.add(new Animation(Resources.spritesheets().get("player_front"), true));
		return animations.toArray(new Animation[animations.size()]);
		
	}
}
