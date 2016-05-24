package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.gfx.Assets;

public class GameState extends State {

	//constructor
	public GameState(){
		
	}
	
	public void tick() {
		
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.playerStill, 0, 0, null);
		
	}
	
}
