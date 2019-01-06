package Players;

import java.util.ArrayList;

import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.EntityAnimationController;
import de.gurkenlabs.litiengine.resources.Resources;

public class Player2AnimationController extends EntityAnimationController<Player2>{
	public Player2AnimationController(Player2 player) {
		super(player,new Animation(Resources.spritesheets().get("playertwo_right"),true),getPlayer2Animations());
	}
	
private static Animation[] getPlayer2Animations() {
	ArrayList <Animation> animations = new ArrayList <Animation> ();
	animations.add(new Animation(Resources.spritesheets().get("playertwo_front"), true));
	animations.add(new Animation(Resources.spritesheets().get("playertwo_back"), true));
	animations.add(new Animation(Resources.spritesheets().get("playertwo_left"), true));
	animations.add(new Animation(Resources.spritesheets().get("playertwo_right"), true));
	return animations.toArray(new Animation[animations.size()]);
}


}