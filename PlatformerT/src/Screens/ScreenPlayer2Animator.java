package Screens;

import java.util.ArrayList;

import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.AnimationController;
import de.gurkenlabs.litiengine.resources.Resources;

public class ScreenPlayer2Animator extends AnimationController {
	public ScreenPlayer2Animator() {
		super(new Animation(Resources.spritesheets().get("playertwo_front"), true), getPlayerAnimations());
	}
	private static Animation[] getPlayerAnimations () {
		ArrayList <Animation> animations = new ArrayList <Animation> ();
		animations.add(new Animation(Resources.spritesheets().get("playertwo_right"), true));
		animations.add(new Animation(Resources.spritesheets().get("playertwo_front"), true));
		return animations.toArray(new Animation[animations.size()]);
		
	} 

}
