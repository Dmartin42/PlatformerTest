package Screens;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Infrastructure.Logic;
import Infrastructure.PlayerInput;
import Players.Player1;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.environment.EntitySpawner;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.environment.EnvironmentListener;
import de.gurkenlabs.litiengine.environment.IEnvironment;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.physics.GravityForce;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;

public class InGameScreen extends GameScreen {
	public static final String NAME = "BlockY GO!";

	public InGameScreen() {
		super(NAME);
	}

	public void prepare() {
		super.prepare();	    
	    
	    // load data from the utiLITI game file
	    Resources.load("Resources\\maps\\game.litidata");
	    
	    Logic.Initalize();
	    PlayerInput.initiate();
	    
	    // load the first level (resources for the map were implicitly loaded from the game file)
	    Environment Env1 = new Environment("Resources\\maps\\Lvl1.tmx");
	    Game.world().loadEnvironment(Env1);
	    Sound LVL1theme  = Resources.sounds().get("Resources\\mozart.mp3");
	    Game.audio().playSound(Player1.instance(),LVL1theme,true);
	    
	}
	public void render (final Graphics2D graphics2D) {
		if (Game.world().environment() != null) {
			Game.world().environment().render(graphics2D);
		}
		super.render(graphics2D);
	}
	
	

	
	
}
