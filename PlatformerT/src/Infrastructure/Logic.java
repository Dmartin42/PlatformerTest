package Infrastructure;

import Players.Player1;
import Players.Player2;
import Screens.MenuScreen;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.entities.IMobileEntity;
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
    Game.world().camera().setClampToMap(true);
    
    if(MenuScreen.Player1Selected) {
    	PlayerCamera(Player1.instance());
    	spawnPlayer1(Player1.instance());
    }
    else if(MenuScreen.Player2Selected) {
    	PlayerCamera(Player2.instance());
    	spawnPlayer1(Player2.instance());
    }
    
	
    Game.config().graphics().setAntiAliasing(true);	
}

/**
 *camera lock on player selected
 */
private static void PlayerCamera(IEntity player) {
	Camera camera = new PositionLockCamera(player);
	camera.setClampToMap(true);
	Game.world().setCamera(camera);
}

/**
 Spawns Player
 */
public static void spawnPlayer1(IMobileEntity player) {
	Game.world().addLoadedListener(e -> {
    	// spawn the player instance on the spawn point with the name "Beginning"
        Spawnpoint Beginning = e.getSpawnpoint("Beginning");
        if (Beginning != null) {
          Beginning.spawn(player);
        }
        else 
        	System.out.println("null");
      });
}




}
