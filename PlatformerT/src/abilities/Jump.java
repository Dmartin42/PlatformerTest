package abilities;

import java.util.Optional;

import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.abilities.Ability;
import de.gurkenlabs.litiengine.abilities.AbilityOrigin;
import de.gurkenlabs.litiengine.abilities.effects.EffectApplication;
import de.gurkenlabs.litiengine.abilities.effects.EffectTarget;
import de.gurkenlabs.litiengine.abilities.effects.ForceEffect;
import de.gurkenlabs.litiengine.annotation.AbilityInfo;
import de.gurkenlabs.litiengine.entities.CollisionBox;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.ICombatEntity;
import de.gurkenlabs.litiengine.environment.GameWorld;
import de.gurkenlabs.litiengine.physics.Force;
import de.gurkenlabs.litiengine.physics.GravityForce;
	@AbilityInfo(cooldown = 500, origin = AbilityOrigin.COLLISIONBOX_CENTER, duration = 300, value = 240)
public class Jump extends Ability {
	public Jump(Creature executor) {
		super(executor);
		this.addEffect(new Jumpeffect(this));
	}
	private class Jumpeffect extends ForceEffect {

	    protected Jumpeffect(Ability ability) {
	      super(ability, ability.getAttributes().getValue().getCurrentValue().intValue(), EffectTarget.EXECUTINGENTITY);
	    }

	    @Override
	    protected Force applyForce(ICombatEntity affectedEntity) {
	      // create a new force and apply it to the player
	      
	      GravityForce force = new GravityForce(affectedEntity, this.getStrength(), Direction.UP);
	      this.getAbility().getExecutor().getMovementController().apply(force);
	      return force;
	    }

	    @Override
	    protected boolean hasEnded(final EffectApplication appliance) {
	      return super.hasEnded(appliance) || this.isTouchingRoof();
	    }

	    /**
	     * Make sure that the jump is cancelled when the entity touches the roof.
	     * 
	     * @return True if the entity touches the roof.
	     */
	    private boolean isTouchingRoof() {

	      Optional<CollisionBox> opt = Game.world().environment().getCollisionBoxes().stream().filter(x -> x.getBoundingBox().intersects(this.getAbility().getExecutor().getBoundingBox())).findFirst();
	      if (!opt.isPresent()) {
	        return false;
	      }

	      CollisionBox box = opt.get();
	      return box.getCollisionBox().getMaxY() <= this.getAbility().getExecutor().getCollisionBox().getMinY();
	    }
	  }
}
