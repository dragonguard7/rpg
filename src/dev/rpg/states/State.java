package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.Game;

public abstract class State {
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	protected Game game;
	
	private static State currentState = null;
	
	public State(Game game){
		this.game = game;
	}
	
	public static void setState(State state){
		currentState = state;
	}
	
	public static State getState(){
		return currentState;
	}
	
}
