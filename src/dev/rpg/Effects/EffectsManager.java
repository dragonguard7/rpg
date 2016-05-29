package dev.rpg.Effects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.rpg.Handler;

public class EffectsManager {

	private Handler handler;
	private ArrayList<Effects> effects;
	
	
	public EffectsManager(Handler handler){
		this.handler = handler;
		effects = new ArrayList<Effects>();
	}
	
	public void tick(){
		Iterator<Effects> it = effects.iterator();
		while(it.hasNext()){
			Effects e = it.next();
			if(e.completed){
				it.remove();
			}
			e.tick();
		}
		
	}
	
	public void render(Graphics g){
		for(Effects e : effects){
			e.render(g);
		}
	
	}
	
	public void addEffect(Effects e){
		e.setHandler(handler);
		effects.add(e);
	}
	
	public void removeEffect(Effects e){
		effects.remove(e);
	}

	
//Getters and setters
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
}
