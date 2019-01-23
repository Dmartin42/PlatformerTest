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
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.IAnimationController;
import de.gurkenlabs.litiengine.graphics.animation.PropAnimationController;
import de.gurkenlabs.litiengine.physics.CollisionType;
import de.gurkenlabs.litiengine.resources.Resources;

public class EndFlag extends Prop implements IUpdateable{
	private static EndFlag instance;
	 public EndFlag() {
		super("flag");
		// TODO Auto-generated constructor stub
		this.properities();
	}

	public void properities() {
		Game.world().environment().add(this);
		this.setCollisionBoxAlign(Align.CENTER_RIGHT);
		this.setCollisionBoxValign(Valign.TOP);
		Game.physics().add(this.getCollisionBox());
		
	 }


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	if(Game.physics().collides(this, CollisionType.ENTITY))
		System.out.println("lol");
	if(isPlayerTouchingFlag())
		System.out.println("Ready");
	}
	
	public boolean isPlayerTouchingFlag() {

	    // the idea of this ground check is to extend the current collision box by one pixel and see if
	    // a) it collides with any static collision box 
	    Rectangle2D groundCheck = new Rectangle2D.Double(this.getCollisionBox().getX()-1, this.getCollisionBox().getY(),this.getCollisionBoxWidth()+1,this.getCollisionBoxHeight()+3);
	    
	    // b) it collides with the map's boundaries
	    if (groundCheck.getMaxY() > Game.physics().getBounds().getMaxY()) {
	      return true;
	    }
	    return Game.physics().collides(groundCheck,this,CollisionType.ENTITY);
	  
	}

	
	
}
