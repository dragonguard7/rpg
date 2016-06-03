package dev.rpg.states;

import java.awt.Font;
import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.ui.UIManager;
import dev.rpg.worlds.World;

public class GameState extends State {


	private World world;
	private static Font font;
	
	//constructor
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		//font = new Font("Serif",Font.BOLD, 20);
		handler.setWorld(world);	
	}
	
	public void tick() {
		world.tick();
	}

	public void render(Graphics g) {
		g.setFont(font);
		world.render(g);
	}
	
}
