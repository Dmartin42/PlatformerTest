package Infrastructure;

import java.awt.Dimension;
import java.awt.Toolkit;

import Screens.InGameScreen;
import Screens.MenuScreen;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.Environment;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;

public class GameRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game.info().setName("BlockY");
	    Game.info().setSubTitle("");
	    Game.info().setVersion("v0.0.1");
	    Game.info().setDescription("An example 2D platformer made with elements from the very cool LITIengine!");
	    Game.init();
		Game.graphics().setBaseRenderScale(8.00f);
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Game.window().getWindowLocation().setLocation(dim.width/2-MenuScreen.instance().getWidth()/2,dim.height/2-MenuScreen.instance().getHeight()/2); //Sets Window in the center
	   

	 
	    // add the screens that will help you organize the different states of your game
	
	    Game.screens().add(new InGameScreen());
	    Game.screens().add(new MenuScreen());
	    Game.screens().display(MenuScreen.NAME);
	    
	    
	    Game.start();
	    
	  }
	
	

}
