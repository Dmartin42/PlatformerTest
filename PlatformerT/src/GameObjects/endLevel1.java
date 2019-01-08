package GameObjects;


import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Entity;
import de.gurkenlabs.litiengine.entities.Material;
import de.gurkenlabs.litiengine.entities.Prop;
import de.gurkenlabs.litiengine.graphics.animation.PropAnimationController;
import de.gurkenlabs.litiengine.resources.Resources;

public class endLevel1 extends Prop {
	private static endLevel1 instance;
	 public endLevel1() {
		super("flag");
		// TODO Auto-generated constructor stub
		this.properities();
	}

	public void properities() {
		Prop b = Game.world().environment().getProp("finish");
		Game.world().environment().add(this);
		this.setLocation(1500, 1025);
		this.setSize(184, 175);
		this.setCollision(true);
		
		if(b!=null) {
			this.setName(b.getName());
			this.setLocation(b.getLocation());
			this.setCollisionBoxHeight(b.getCollisionBoxHeight());
			this.setCollisionBoxWidth(b.getCollisionBoxWidth());
		}
		this.setController(PropAnimationController.class,new FlagAnimator(this));
	 }
	public static endLevel1 instance() {
	    if (instance == null) {
	      instance = new endLevel1();
	    }

	    return instance;
	  }
	
	

	
	
}
