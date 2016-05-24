package dev.rpg.entities.creature;

import java.awt.Graphics;

import dev.rpg.Game;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	public void tick() {
		getInput();
		move();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().up || game.getKeyManager().up2){
			yMove = -speed;
		}
		if(game.getKeyManager().down || game.getKeyManager().down2){
			yMove = speed;
		}
		if(game.getKeyManager().left || game.getKeyManager().left2){
			xMove = -speed;
		}
		if(game.getKeyManager().right || game.getKeyManager().right2){
			xMove = speed;
		}
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.playerStill, (int)x, (int)y, width, height,null); //(Image, Xpos, Ypos, Xsize, Ysize, observer)
	}

}
