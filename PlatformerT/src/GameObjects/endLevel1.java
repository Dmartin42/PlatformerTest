package GameObjects;


import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Optional;

import Players.Player1;
import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionBox;
import de.gurkenlabs.litiengine.entities.Entity;
import de.gurkenlabs.litiengine.entities.Material;
import de.gurkenlabs.litiengine.entities.Prop;
import de.gurkenlabs.litiengine.graphics.animation.IAnimationController;
import de.gurkenlabs.litiengine.graphics.animation.PropAnimationController;
import de.gurkenlabs.litiengine.physics.CollisionType;
import de.gurkenlabs.litiengine.resources.Resources;

public class endLevel1 extends Prop implements IUpdateable{
	private static endLevel1 instance;
	 public endLevel1() {
		super("flag");
		// TODO Auto-generated constructor stub
		this.properities();
	}

	public void properities() {
		Prop b = Game.world().environment().getProp("finish");
		Game.world().environment().add(this);
		this.setLocation(1575, 1108);
		this.setSize(19,55);
		this.setCollision(true);
		this.setCollisionBoxHeight(18.0f);
		this.setCollisionBoxWidth(18.0f);
		this.setCollisionBoxAlign(Align.CENTER_RIGHT);
		this.setCollisionBoxValign(Valign.TOP);
		Game.physics().add(getCollisionBox());
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	if(Game.physics().collides(this, CollisionType.ENTITY))
		System.out.println("lol");
	if(isPlayerTouchingFlag())
		System.out.println("Ready");
	}
	public boolean isTouchingFlag() {


	      Optional<CollisionBox> opt = Game.world().environment().getCollisionBoxes().stream().filter(x -> x.getBoundingBox().intersects(this.getBoundingBox())).findFirst();
	      if (!opt.isPresent()) {
	        return false;
	      }

	      CollisionBox box = opt.get();
	      return box.getCollisionBox().getMaxY() <= this.getCollisionBox().getMinY();
	    
	}
	public boolean isPlayerTouchingFlag() {

	    // the idea of this ground check is to extend the current collision box by one pixel and see if
	    // a) it collides with any static collision box 
	    Rectangle2D groundCheck = new Rectangle2D.Double(this.getCollisionBox().getX(), this.getCollisionBox().getY(),this.getCollisionBoxWidth()+1,this.getCollisionBoxHeight()+1);
	    
	    // b) it collides with the map's boundaries
	    if (groundCheck.getMaxY() > Game.physics().getBounds().getMaxY()) {
	      return true;
	    }

	    return Game.physics().collides(groundCheck,this,CollisionType.ENTITY);
	  
	}
	
}
