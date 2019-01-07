package Infrastructure;

import Players.Player1;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.environment.EnvironmentListener;
import de.gurkenlabs.litiengine.environment.IEnvironment;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;
import de.gurkenlabs.litiengine.physics.Force;
import de.gurkenlabs.litiengine.physics.GravityForce;

public class Logic {
	
public Logic() {
	
}

public static void Initalize() {
	
 
    // set a basic gravity for all levels.
    Game.world().setGravity(120);
    
    spawnPlayer1();
    
	Camera camera = new PositionLockCamera(Player1.instance());
    camera.setClampToMap(true);
    Game.world().setCamera(camera);
Game.config().graphics().setAntiAliasing(true);	
}

/**
 Spawns Player1 
 */
public static void spawnPlayer1() {
	Game.world().addLoadedListener(e -> {
    	// spawn the player instance on the spawn point with the name "Beginning"
        Spawnpoint Beginning = e.getSpawnpoint("Beginning");
        if (Beginning != null) {
          Beginning.spawn(Player1.instance());
          System.out.println("Spawned");
        }
        else 
        	System.out.println("null");
      });
}

}
