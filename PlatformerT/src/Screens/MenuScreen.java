package Screens;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageReader;
import javax.swing.ImageIcon;

import Players.Player1AnimationController;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameAdapter;
import de.gurkenlabs.litiengine.GameMetrics;
import de.gurkenlabs.litiengine.SpritesheetInfo;
import de.gurkenlabs.litiengine.annotation.AnimationInfo;
import de.gurkenlabs.litiengine.configuration.GameConfiguration;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.AnimationController;
import de.gurkenlabs.litiengine.graphics.emitters.AnimationEmitter;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.GamepadManager;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.Mouse;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.resources.Spritesheets;

public class MenuScreen extends Screen {

	public static final String NAME = "BlockY Menu";
	private static MenuScreen instance;
	private static ScreenPlayer1Animator player1Animator;
	public MenuScreen() {
		super(NAME);
	}
	public void reder(final Graphics2D g) {
		
		AnimateP1(g);
		super.render(g);
	}
	public void prepare() {
		super.prepare();
		this.player1Animator = new ScreenPlayer1Animator();
		Game.loop().attach(player1Animator.getCurrentAnimation());
	
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
		final Spritesheet player1_sprite = Resources.spritesheets().get("player_right.png");
		final Spritesheet player2_sprite = Resources.spritesheets().get("Resources\\sprites\\playertwo_front.png");
		
		
/*		ImageComponent Player1 = new ImageComponent(screenCenterX-500, screenCenterY-50, 100,100, null, "hey",null);
		ImageComponent Player2 = new ImageComponent(screenCenterX+500 , Player1.getY(), 100,100, null, "Hi", null);
				
		Player1.onClicked(e -> {  //sets things when clicked
			//Image imageCursor = new ImageIcon("resources/cursor_invisible_1.png").getImage();
			Game.window().getRenderComponent().setCursor(null, 0, 0);
			Game.screens().display(InGameScreen.NAME);
		});
		
		Player2.onClicked(e -> {   //does things when clicked
			
		});*/
//		this.getComponents().add(Player1);
//		this.getComponents().add(Player2);
//		
	}
	public static void AnimateP1(Graphics2D g) {
			System.out.println("Re");
		 final int defaultSize = 73;
		    final double logoScale = 6;
		    final double size = defaultSize * logoScale;
		    double x = Game.window().getCenter().getX() - size / 2.0;
		    double y = Game.window().getCenter().getY() - size;
		    ImageRenderer.renderScaled(g, MenuScreen.player1Animator.getCurrentSprite(), 100, 100, logoScale);
	}
}
