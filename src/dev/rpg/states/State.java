package dev.rpg.states;

import java.awt.Graphics;
import dev.rpg.Handler;

public abstract class State {
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	protected Handler handler;
	
	private static State currentState = null;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
}
