package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.Game;
import dev.rpg.entities.creature.Player;
import dev.rpg.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	
	//constructor
	public GameState(Game game){
		super(game);
		player = new Player(game, 100, 100);
		world = new World("res/worlds/world1.txt");
	}
	
	public void tick() {
		world.tick();
		player.tick();
	}

	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}
	
}
