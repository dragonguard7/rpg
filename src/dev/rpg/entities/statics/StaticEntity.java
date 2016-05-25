package dev.rpg.entities.statics;

import dev.rpg.Handler;
import dev.rpg.entities.Entity;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
	}

}
