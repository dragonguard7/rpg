package dev.rpg.entities.creature;

import java.awt.Graphics;

import dev.rpg.Game;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	public void tick() {
		if(game.getKeyManager().up || game.getKeyManager().up2){
			y -= 3;
		}
		if(game.getKeyManager().down || game.getKeyManager().down2){
			y += 3;
		}
		if(game.getKeyManager().left || game.getKeyManager().left2){
			x -= 3;
		}
		if(game.getKeyManager().right || game.getKeyManager().right2){
			x += 3;
		}
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.playerStill, (int)x, (int)y, null);
	}

}
