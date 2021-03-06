package Players;

import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import Infrastructure.Logic;
import abilities.Jump;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.CombatEntityDeathListener;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.ICombatEntity;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.environment.IEnvironment;
import de.gurkenlabs.litiengine.graphics.animation.EntityAnimationController;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.input.PlatformingMovementController;
import de.gurkenlabs.litiengine.physics.CollisionType;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;

public class Player2 extends Creature implements IUpdateable {
	public static final int MAX_ADDITIONAL_JUMPS = 1;

	  private static Player2 instance;

	  private final Jump jump;

	  private int consecutiveJumps;

	  private Player2() {
	    super("Player 2");
	    setName("Player 2");
	    
	    this.setController(EntityAnimationController.class, new Player2AnimationController(this));
	    this.addController(new PlatformingMovementController<>(this));
	    /*KeyboardEntityController <Player2> keyboardController = new KeyboardEntityController<Player2>(this, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
		this.addController(keyboardController);*/
	    // setup the player's abilities
	    this.jump = new Jump(this);
	    this.playerProperties();
	    
	  }
	  public void playerProperties() {
		  	setCollisionBoxHeight(32);
		  	setCollisionBoxWidth(32);  
		  	getVelocity().setBaseValue(140.0f); //Sets Velocity pixels per second
		  	setSpritePrefix("playertwo_right");
		  	
	  }
	
	  public void changeDirection(Direction direction){
		  switch (direction) {
			case UP:
				if (Input.keyboard().isPressed(KeyEvent.VK_LEFT)) {
					this.getAnimationController().playAnimation("playertwo_left");
				}
				else if (Input.keyboard().isPressed(KeyEvent.VK_RIGHT)) {
					this.getAnimationController().playAnimation("playertwo_right");
				}
				else {
					this.getAnimationController().playAnimation("playertwo_front");
					
				}
				break;
			case DOWN:
				if (Input.keyboard().isPressed(KeyEvent.VK_LEFT)) {
					this.getAnimationController().playAnimation("playertwo_back");
				}
				else if (Input.keyboard().isPressed(KeyEvent.VK_RIGHT)) {
					this.getAnimationController().playAnimation("playertwo_right");
				}
				else {
					this.getAnimationController().playAnimation("playertwo_back");
				
				}
				break;
			case LEFT:
				if (Input.keyboard().isPressed(KeyEvent.VK_UP)) {
					this.getAnimationController().playAnimation("playertwo_left");
				}
				else if (Input.keyboard().isPressed(KeyEvent.VK_DOWN)) {
					this.getAnimationController().playAnimation("playertwo_back");
				}
				else {
					this.getAnimationController().playAnimation("playertwo_left");
				}
				break;
			case RIGHT:
				if (Input.keyboard().isPressed(KeyEvent.VK_UP)) {
					this.getAnimationController().playAnimation("playertwo_front");
				
				}
				else if (Input.keyboard().isPressed(KeyEvent.VK_DOWN)) {
					this.getAnimationController().playAnimation("playertwo_right");
					
				}
				else {
					this.getAnimationController().playAnimation("playertwo_right");
				}
				
				break;
			default:
				break;
		}
		this.getAnimationController().update();
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
	/*	if(this.getY()>Game.world().environment().getCollisionBox("Bottom").getY()+(this.getCollisionBoxHeight())) {
			System.out.println("Death");
			die();
		}*/
	
		if(this.getY()>1450) {
			this.die();
			Game.world().environment().remove(this);
			Spawnpoint Creator = Game.world().environment().getSpawnpoint("Beginning");
			this.setLocation(Creator.getLocation());
			this.resurrect();
			Creator.spawn(this);
		}
		
	}
}