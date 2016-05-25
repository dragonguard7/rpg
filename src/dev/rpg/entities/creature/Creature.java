package dev.rpg.entities.creature;

import dev.rpg.Handler;
import dev.rpg.entities.Entity;
import dev.rpg.tiles.Tile;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move(){
		xMove();
		yMove();
	}
	
	public void xMove(){
		if(xMove > 0){//Moving right
			
			int tx =(int)(x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx,(int)(y+bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx,(int)(y+bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
			
		}else if(xMove < 0){//Moving left
			int tx =(int)(x + xMove + bounds.x) / Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx,(int)(y+bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx,(int)(y+bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
		}
		
	}
	
	public void yMove(){
		if(yMove < 0){//Moving up
			
			int ty =(int)(y + yMove + bounds.y) / Tile.TILEWIDTH;
			
			if(!collisionWithTile((int)(x+bounds.x) / Tile.TILEHEIGHT,ty) &&
					!collisionWithTile((int)(x+bounds.x + bounds.width) / Tile.TILEHEIGHT, ty)){
				y += yMove;
			}
			
		}else if(yMove > 0){//Moving down
			int ty =(int)(y + yMove + bounds.y + bounds.height) / Tile.TILEWIDTH;
			
			if(!collisionWithTile((int)(x+bounds.x) / Tile.TILEHEIGHT,ty) &&
					!collisionWithTile((int)(x+bounds.x + bounds.width) / Tile.TILEHEIGHT, ty)){
				y += yMove;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	//Getters and setters

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
}
