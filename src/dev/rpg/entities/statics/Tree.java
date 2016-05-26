package dev.rpg.entities.statics;

import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.gfx.Assets;
import dev.rpg.items.Item;
import dev.rpg.tiles.Tile;

public class Tree extends StaticEntity{

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		
		bounds.x = 20;
		bounds.y = (int)(height/1.2f);
		bounds.width = 20;
		bounds.height = (int)(height - height/1.2);
		
	}

	@Override
	public void tick() {
		
		
	}
	
	@Override
	public void die(){
		handler.getWorld().getItemManager().addItem(Item.money.createNew((int)x, (int)y));
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(Assets.tree, (int)(x - handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()), width, height, null);
	}

}
