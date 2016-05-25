package dev.rpg.entities.creature;

import java.awt.Color;
import java.awt.Graphics;
import dev.rpg.Handler;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
	}

	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up || handler.getKeyManager().up2){
			yMove = -speed;
		}
		if(handler.getKeyManager().down || handler.getKeyManager().down2){
			yMove = speed;
		}
		if(handler.getKeyManager().left || handler.getKeyManager().left2){
			xMove = -speed;
		}
		if(handler.getKeyManager().right || handler.getKeyManager().right2){
			xMove = speed;
		}
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.playerStill, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height,null); //(Image, Xpos, Ypos, Xsize, Ysize, observer)
		
		g.setColor(Color.red);
		g.fillRect((int)(x + bounds.x -handler.getGameCamera().getxOffset()), (int)(y + bounds.y -handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

}
