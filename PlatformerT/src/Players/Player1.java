package Players;

import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageTypeSpecifier;

import GameObjects.EndFlag;
import Infrastructure.Logic;
import Screens.MenuScreen;
import abilities.Jump;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.annotation.CollisionInfo;
import de.gurkenlabs.litiengine.annotation.EntityInfo;
import de.gurkenlabs.litiengine.annotation.MovementInfo;
import de.gurkenlabs.litiengine.attributes.AttributeModifier;
import de.gurkenlabs.litiengine.entities.CombatEntityDeathListener;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.ICombatEntity;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.AnimationController;
import de.gurkenlabs.litiengine.graphics.animation.CreatureAnimationController;
import de.gurkenlabs.litiengine.graphics.animation.EntityAnimationController;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.input.PlatformingMovementController;
import de.gurkenlabs.litiengine.physics.CollisionType;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;
@EntityInfo(width = 32, height = 32)
@MovementInfo(velocity = 200)
@CollisionInfo(collisionBoxWidth = 8, collisionBoxHeight = 16, collision = true)
public class Player1 extends Creature implements IUpdateable {
	
	public static final int MAX_ADDITIONAL_JUMPS = 1;

	  private static Player1 instance;

	  private final Jump jump;

	  private int consecutiveJumps;

	  private Player1() {
	    super("player");
	    setName("Player 1");
	    setFacingDirection(Direction.LEFT);
	    
	    
	   
	    
	
	    this.addController(new CreatureAnimationController<>(this,true));
	  //  CreatureAnimationController AN = this.getController(CreatureAnimationController.class);
	    
	    
	    this.addController(new PlatformingMovementController<>(this));
	    

	    
	    // setup the player's abilities
	    this.jump = new Jump(this);
	    this.playerProperties();
	  }
	  public void playerProperties() {
		  	setCollisionBoxHeight(32);
		  	setCollisionBoxWidth(32);  
		  	getVelocity().setBaseValue(200.0f); //Sets Velocity pixels per second 140
		  	addDeathListener(new CombatEntityDeathListener() {
				public void onDeath(ICombatEntity entity) {
					Spawnpoint Creator = Game.world().environment().getSpawnpoint("Beginning");
					
					Player1.instance().resurrect();
					Creator.spawn(Player1.instance());
				}
			});
		  	
		  	 setSpritePrefix("player_right");
		  	 Sound lvl1p1Theme = Resources.sounds().get("Resources\\mozart.mp3");
			 setCollision(true);
			 Game.physics().add(this);
			 Game.audio().playSound(new Point2D.Double(32, 324), lvl1p1Theme);
			 Game.audio().setMaxDistance(10);
			 
		    
	  }
	
	
		
		
	
	  

	  public static Player1 instance() {
	    if (instance == null) {
	      instance = new Player1();
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
	/*	if(this.getY()>Game.world().environment().getCollisionBox("Bottom").getY()+(this.getCollisionBoxHeight())) {
			System.out.println("Death");
			die();
		}*/
	
		if(this.getY()>1460) {
			this.die();
			
			
		}
	
	}
}
	




