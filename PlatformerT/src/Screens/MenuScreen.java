package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import Infrastructure.Logic;
import Players.Player1;
import Players.Player1AnimationController;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;

import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;

import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;

public class MenuScreen extends Screen {
	private static Boolean Countdown = false;
	public static final String NAME = "BlockY Menu";
	private static MenuScreen instance;
	private static  ScreenPlayer1Animator player1Animator;
	private static  ScreenPlayer2Animator player2Animator;
	private static int seconds = 0;
	private static int counter = -11;
	private static IUpdateable time;
	private static String TimeRemain = "3";
	public static Boolean Player1Selected = false;
	public static Boolean Player2Selected = false;
	
	public MenuScreen() {
		super(NAME);
	}
	public void render(final Graphics2D g) {
		super.render(g);
		AnimateP1(g);
		AnimateP2(g);
		double size = 32*5;
		int x = (int) ((Game.window().getCenter().getX() - size / 2.0));
		int y = (int) (Game.window().getCenter().getY() - size / 2.0);
		g.setColor(Color.BLACK);
		g.drawRect(x+295, y, 200,200);
		g.drawRect(x-300, y, 200,200);
		g.setFont(new Font("Times New Roman",Font.BOLD, 178));
		if(Countdown) {
			Game.graphics().renderText(g, TimeRemain,Game.window().getCenter());
			System.out.println("Time" + TimeRemain);
		}
	}
	public void prepare() {
		super.prepare();
		
		this.player1Animator = new ScreenPlayer1Animator();
		Game.loop().attach(this.player1Animator);
		
		this.player2Animator = new ScreenPlayer2Animator();
		Game.loop().attach(this.player2Animator);
		
		 time = new IUpdateable() {
				@Override
				public void update() {
					// TODO Auto-generated method stub
					counter++;
					if(counter%60==0) //Controls the seconds
						seconds++;
					if(seconds == 1) //This is where the three goes as it's first in the count down
						TimeRemain = "3";
					if(seconds == 2)
						TimeRemain = "2";
					if(seconds == 3)
						TimeRemain = "1";
					if(seconds == 4) {
						TimeRemain = "G0!";
						Game.loop().detach(time);
						counter = 0;
						LoadMainGame();
					}
				}
			};
			
		Sound MenuTheme = Resources.sounds().get("Resources\\Retro.mp3");
		Game.audio().playMusic(MenuTheme);
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
			
			FinalCountDown(Player1);
			Player1Selected = true;
		});
		Player2.onClicked(e -> {   //does things when clicked
			FinalCountDown(Player2);
			Player2Selected = true;
		});
		this.getComponents().add(Player1);
		this.getComponents().add(Player2);
	}
	/**
	 * @param Player1
	 */
	public void FinalCountDown(ImageComponent image) {
		this.getComponents().remove(image);
		Game.loop().attach(time);
		Sound Ding = Resources.sounds().get("Resources\\countdown.mp3");
		Game.audio().playSound(Ding, false);
		Countdown = true;
	}
	public static void AnimateP1(Graphics2D g) {
		 final int defaultSize = 32;
		 final double Scale = 5;
		 final double size = defaultSize * Scale;
		 double x = (Game.window().getCenter().getX() - size / 2.0)-300;//Puts the animation in the center in terms of X
		 double y = (Game.window().getCenter().getY() - size /2.0); // Puts the animation in the center of the screen in terms of Y
		 ImageRenderer.renderScaled(g, MenuScreen.player1Animator.getCurrentSprite(), x,y, Scale);//Displays current Sprite of Animation
	}
	public static void AnimateP2(Graphics2D g) {
		final int defaultSize = 32; 
		final double Scale = 5; 
		final double size =  Scale * defaultSize;
		double x = (Game.window().getCenter().getX() - size / 2.0)+315;
		double y = (Game.window().getCenter().getY() - size / 2.0);
		ImageRenderer.renderScaled(g,MenuScreen.player2Animator.getCurrentSprite(),x,y,Scale);
	}
	public static void LoadMainGame() {
		//Game.window().getRenderComponent().setCursor(null,0,0);
		Game.screens().display(InGameScreen.NAME);
		seconds = 0;
		
	}
}
