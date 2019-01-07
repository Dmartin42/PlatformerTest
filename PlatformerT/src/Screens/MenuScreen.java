package Screens;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import Players.Player1AnimationController;
import de.gurkenlabs.litiengine.Game;

import de.gurkenlabs.litiengine.graphics.ImageRenderer;

import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;

import de.gurkenlabs.litiengine.resources.Resources;

public class MenuScreen extends Screen {

	public static final String NAME = "BlockY Menu";
	private static MenuScreen instance;
	private static  ScreenPlayer1Animator player1Animator;
	private static  ScreenPlayer2Animator player2Animator;
	
	public MenuScreen() {
		super(NAME);
	}
	public void render(final Graphics2D g) {
		AnimateP1(g);
		AnimateP2(g);
		double size = 32*5;
		int x = (int) ((Game.window().getCenter().getX() - size / 2.0));
		int y = (int) (Game.window().getCenter().getY() - size / 2.0);
		g.setColor(Color.BLACK);
		g.drawRect(x+295, y, 200,200);
		g.drawRect(x-300, y, 200,200);
		super.render(g);
	}
	public void prepare() {
		super.prepare();

		this.player1Animator = new ScreenPlayer1Animator();
		Game.loop().attach(this.player1Animator);
		
		this.player2Animator = new ScreenPlayer2Animator();
		Game.loop().attach(this.player2Animator);
		
		
	}

	public static MenuScreen instance() {
		if(instance==null)
			instance = new MenuScreen();
		return instance;
	}
	
	@Override
	protected void initializeComponents () {
	
		final double screenCenterX = Game.window().getResolution().getWidth() / 2.0;
		final double screenCenterY = Game.window().getResolution().getHeight() / 2.0;	
		ImageComponent Player1 = new ImageComponent(screenCenterX-380, 500, 200,100, null, "Player 1",null);
		ImageComponent Player2 = new ImageComponent(screenCenterX+220, 500, 200,100, null, "Player 2", null);
		Game.window().getRenderComponent().fadeIn(3000);
		Player1.onClicked(e -> {  //sets things when clicked
				this.getComponents().remove(Player1);
				Game.loop().execute(3000, new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Game.screens().display(InGameScreen.NAME);
					}
				});
		});
		
		Player2.onClicked(e -> {   //does things when clicked
			
		});
		
		this.getComponents().add(Player1);
		this.getComponents().add(Player2);
	
	}
	public static void AnimateP1(Graphics2D g) {
		 final int defaultSize = 32;
		 final double Scale = 5;
		 final double size = defaultSize * Scale;
		 double x = (Game.window().getCenter().getX() - size / 2.0)-300; //Puts the animation in the center in terms of X
		 double y = (Game.window().getCenter().getY() - size /2.0);  	// Puts the animation in the center of the screen in terms of Y
		 ImageRenderer.renderScaled(g, MenuScreen.player1Animator.getCurrentSprite(), x,y, Scale); //Displays current Sprite of Anima
		 
	}
	public static void AnimateP2(Graphics2D g) {
		final int defaultSize = 32; 
		final double Scale = 5; 
		final double size =  Scale * defaultSize;
		double x = (Game.window().getCenter().getX() - size / 2.0)+315;
		double y = (Game.window().getCenter().getY() - size / 2.0);
		ImageRenderer.renderScaled(g,MenuScreen.player2Animator.getCurrentSprite(),x,y,Scale );
	}
}
