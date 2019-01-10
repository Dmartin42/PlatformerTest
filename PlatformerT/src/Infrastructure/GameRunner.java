package Infrastructure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import Screens.InGameScreen;
import Screens.MenuScreen;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;
import de.gurkenlabs.litiengine.gui.screens.Resolution;

public class GameRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game.info().setName("BlockY");
	    Game.info().setSubTitle("");
	    Game.info().setVersion("v0.0.1");
	    Game.info().setDescription("An example 2D platformer made with elements from the very cool LITIengine!");
	    Game.init();
		Game.graphics().setBaseRenderScale(1.00f);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		Image imageCursorMain = new ImageIcon("Resources\\icons8-cursor-104.png").getImage();
		Game.window().getRenderComponent().setCursor(imageCursorMain, 0, 0);
		Resources.load("Resources\\maps\\game.litidata");
	 
	    // add the screens that will help you organize the different states of your game
	
	    Game.screens().add(new InGameScreen());
	    Game.screens().add(new MenuScreen());
	    Game.screens().display(MenuScreen.NAME);
	    
	    
	    
	    Game.start();
	    
	  }
	
	

}
