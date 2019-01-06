package Screens;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Players.Player1AnimationController;

import java.awt.Color;
import java.awt.Dimension;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.SpritesheetInfo;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.AnimationController;
import de.gurkenlabs.litiengine.graphics.emitters.AnimationEmitter;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.Mouse;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.resources.Spritesheets;

public class MenuScreen extends Screen {
	public static final String NAME = "BlockY Menu";
	private static MenuScreen instance;
	public MenuScreen() {
		super(NAME);
	}
	public void prepare() {
		
		super.prepare();
		
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
		final Spritesheet player1_sprite = Resources.spritesheets().get("player_front");
		final Spritesheet player2_sprite = Resources.spritesheets().get("Resources\\sprites\\playertwo_front.png");
		Animation player1Animation = new Animation("Player 1", player1_sprite,true,2);
		ImageComponent Player1 = new ImageComponent(screenCenterX-500, screenCenterY-50, 50,50, player1_sprite, "", null);
		ImageComponent Player2 = new ImageComponent(screenCenterX+500 , Player1.getY(), 50, 50, player2_sprite, "", null);
		
		
		Player1.onClicked(e -> {  //sets things when clicked
			//Image imageCursor = new ImageIcon("resources/cursor_invisible_1.png").getImage();
			Game.window().getRenderComponent().setCursor(null, 0, 0);
			Game.screens().display(InGameScreen.NAME);
		});
		
		Player2.onClicked(e -> {   //does things when clicked
			
		});
		this.getComponents().add(Player1);
		this.getComponents().add(Player2);
		
	}
}
