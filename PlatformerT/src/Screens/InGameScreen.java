package Screens;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.print.attribute.standard.Finishings;

import GameObjects.FlagAnimator;
import GameObjects.EndFlag;
import Infrastructure.Logic;
import Infrastructure.PlayerInput;
import Players.Player1;
import Players.Player2;
import de.gurkenlabs.litiengine.Direction;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.entities.Prop;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.environment.EntitySpawner;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.environment.EnvironmentListener;
import de.gurkenlabs.litiengine.environment.IEnvironment;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;
import de.gurkenlabs.litiengine.graphics.animation.PropAnimationController;
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
	    Game.audio().stopMusic();
	    // load data from the utiLITI game file
	    EndFlag finishFlag = new EndFlag();
	    finishFlag.setSize(50,50);
	    finishFlag.setLocation(1310,1041);
	    Game.world().environment().add(finishFlag);
	    // load the first level (resources for the map were implicitly loaded from the game file)
	    
	    
	}
	
	

	
	
}
