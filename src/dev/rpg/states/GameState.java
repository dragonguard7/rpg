package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.Game;
import dev.rpg.entities.creature.Player;

public class GameState extends State {

	private Player player;
	//constructor
	public GameState(Game game){
		super(game);
		player = new Player(game, 100, 100);
	}
	
	public void tick() {
		player.tick();
	}

	public void render(Graphics g) {
		player.render(g);
		
	}
	
}
