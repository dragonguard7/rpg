package dev.rpg.Effects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.rpg.Handler;
import dev.rpg.gfx.Assets;

public class Effects {
	
	public static final int EFFECTWIDTH = 32, EFFECTHEIGHT = 32;
	public static Effects attack = new Effects(Assets.attack);
	
	protected Handler handler;
	protected BufferedImage effect;
	protected int x, y;
	protected boolean completed = false;
	protected long effectTime, effectStart;
	
	public Effects(BufferedImage effect, long effectTime){
		this.effect = effect;
		this.effectTime = effectTime;
		effectStart = System.currentTimeMillis();
	}
	
	public Effects(BufferedImage effect){
		this.effect = effect;
	}
	
	public void tick(){
		long time = System.currentTimeMillis();
		if(time - this.effectStart < effectTime){
			return;
		}
		this.completed = true;
	}
	
	public void render(Graphics g){
		if(handler == null){
			return;
		}
		
		g.drawImage(effect,(int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),EFFECTWIDTH, EFFECTHEIGHT, null);
	}

//Getters and setters
	
	
	public int getX() {
		return x;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	
	
}
