package dev.rpg.tiles;

import dev.rpg.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.brick, id);
	}
	
	public boolean isSolid(){
		return true;
	}

}
