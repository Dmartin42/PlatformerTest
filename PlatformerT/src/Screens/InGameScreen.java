package Screens;

import java.awt.Graphics;
import java.awt.Graphics2D;

import GameObjects.endLevel1;
import Infrastructure.Logic;
import Infrastructure.PlayerInput;
import Players.Player1;
import Players.Player2;
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
		Environment Env1 = new Environment("Resources\\maps\\Lvl1.tmx");
	    Game.world().loadEnvironment(Env1);
		Logic.Initalize();
	    PlayerInput.initiate();
	    endLevel1 finishFlag = new endLevel1();
	    Game.world().environment().add(finishFlag);
	    // load data from the utiLITI game file
	    
	    // load the first level (resources for the map were implicitly loaded from the game file)
	    
	    
	}
	
	

	
	
}
