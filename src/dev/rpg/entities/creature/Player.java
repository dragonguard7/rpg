package dev.rpg.entities.creature;

import java.awt.Graphics;

import dev.rpg.gfx.Assets;

public class Player extends Creature{

	public Player(float x, float y) {
		super(x, y);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.playerStill, (int)x, (int)y, null);
	}

}
