package dev.rpg.entities.creature;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import dev.rpg.Handler;
import dev.rpg.entities.Entity;
import dev.rpg.gfx.Animation;
import dev.rpg.gfx.Assets;

public class Player extends Creature{

	//Animations
	private Animation animationDown, animationUp, animationLeft, animationRight;
	
	//Attack timer
	private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;
	
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
		
	//Attack
		checkAttacks();
	}
	
	private void checkAttacks(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown){
			return;
		}
		
		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		
		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width / 2 - arSize/2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width / 2 - arSize/2;
			ar.y = cb.y + arSize;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height /2 - arSize /2;
		}else if(handler.getKeyManager().aRight){
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height /2 - arSize /2;
		}else{
			return;
		}
		
		attackTimer = 0;
		
		for(Entity e: handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getCollisionBounds(0, 0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}

	
	}
	
	
	public void die(){
		System.out.println("You lose");
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up){
			yMove = -speed;
		}
		if(handler.getKeyManager().down){
			yMove = speed;
		}
		if(handler.getKeyManager().left){
			xMove = -speed;
		}
		if(handler.getKeyManager().right){
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
