package Players;

import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import abilities.Jump;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.graphics.animation.EntityAnimationController;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.physics.CollisionType;

public class Player2 extends Creature implements IUpdateable {
	public static final int MAX_ADDITIONAL_JUMPS = 1;

	  private static Player2 instance;

	  private final Jump jump;

	  private int consecutiveJumps;

	  private Player2() {
	    super("P2");

	    // setup movement controller
	    this.setController(EntityAnimationController.class, new Player2AnimationController(this));
	    // setup the player's abilities
	    
	    this.jump = new Jump(this);
	  }

	  public static Player2 instance() {
	    if (instance == null) {
	      instance = new Player2();
	    }

	    return instance;
	  }

	  
	  /**
	   * Executes the jump ability.
	   */
	  public void jump() {
	    if (this.consecutiveJumps >= MAX_ADDITIONAL_JUMPS || !this.jump.canCast()) {
	      return;
	    }

	    this.jump.cast();
	    this.consecutiveJumps++;
	  }

	  private boolean isTouchingGround() {
	    // the idea of this ground check is to extend the current collision box by one pixel and see if
	    // a) it collides with any static collision box 
	    Rectangle2D groundCheck = new Rectangle2D.Double(this.getCollisionBox().getX(), this.getCollisionBox().getY(), this.getCollisionBoxWidth(), this.getCollisionBoxHeight() + 1);
	    
	    // b) it collides with the map's boundaries
	    if (groundCheck.getMaxY() > Game.physics().getBounds().getMaxY()) {
	      return true;
	    }

	    return Game.physics().collides(groundCheck, CollisionType.STATIC);
	  }
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.isTouchingGround()) {
			this.consecutiveJumps = 0;
	}
	}



}
