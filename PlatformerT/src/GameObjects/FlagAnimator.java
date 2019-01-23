package GameObjects;

import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.PropAnimationController;
import de.gurkenlabs.litiengine.resources.Resources;

public class FlagAnimator extends PropAnimationController<EndFlag>{

	public FlagAnimator(EndFlag prop) {
		super(prop);
		this.add(new Animation(Resources.spritesheets().get("flag"),true));
		
	}}
