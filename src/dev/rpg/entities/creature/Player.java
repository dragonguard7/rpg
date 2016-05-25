package dev.rpg.entities.creature;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import dev.rpg.Handler;
import dev.rpg.gfx.Animation;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	//Animations
	private Animation animationDown, animationUp, animationLeft, animationRight;
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 10;
		bounds.y = 32;
		bounds.width = 40;
		bounds.height = 32;
		
		//Animations
		animationDown = new Animation(500,Assets.playerDown); //500 is the speed in milliseconds.
		animationUp = new Animation(500,Assets.playerUp); //500 is the speed in milliseconds.
		animationLeft = new Animation(500,Assets.playerLeft); //500 is the speed in milliseconds.
		animationRight = new Animation(500,Assets.playerRight); //500 is the speed in milliseconds.
	}

	public void tick() {
		//Animation
		animationDown.tick();
		animationUp.tick();
		animationLeft.tick();
		animationRight.tick();
		
		//Movement
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
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height,null); //(Image, Xpos, Ypos, Xsize, Ysize, observer)
		
	//Draws collision box
		//g.setColor(Color.red);
		//g.fillRect((int)(x + bounds.x -handler.getGameCamera().getxOffset()), (int)(y + bounds.y -handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		if(xMove < 0){
			return animationLeft.getCurrentFrame();
		}else if(xMove > 0){
			return animationRight.getCurrentFrame();
			
		}else if(yMove < 0){
			return animationUp.getCurrentFrame();
		}else if(yMove > 0){
			return animationDown.getCurrentFrame();
		}
		return Assets.playerStill;
	}

}
