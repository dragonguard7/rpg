package dev.rpg.worlds;

import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.Effects.EffectsManager;
import dev.rpg.entities.EntityManager;
import dev.rpg.entities.creature.Player;
import dev.rpg.entities.statics.Tree;
import dev.rpg.items.ItemManager;
import dev.rpg.tiles.Tile;
import dev.rpg.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int xSpawn, ySpawn;
	private int[][] tiles;
	
//Entities
	private EntityManager entityManager;
//Item
	private ItemManager itemManager;
//Effects
	private EffectsManager effectsManager;

//Constructor
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler,100,100));
		itemManager = new ItemManager(handler);
		effectsManager = new EffectsManager(handler);
		
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Tree(handler, 200, 350));
		entityManager.addEntity(new Tree(handler, 300, 450));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(xSpawn);
		entityManager.getPlayer().setX(ySpawn);
	}

	public void tick(){
		effectsManager.tick();
		entityManager.tick();
		itemManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/ Tile.TILEWIDTH); 
		int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH +1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1);
		
//World		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x,y).render(g,(int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
//Effects
		effectsManager.render(g);
//Items
		itemManager.render(g);
//Entity
		entityManager.render(g);
		
	}//End rendering
	
	//This looks into Tiles array and looks up the 
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height){
			return Tile.grassTile;
		}
		
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null){
			return Tile.grassTile;
		}
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+"); //Splits up every number into their own string separated by any white space
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		xSpawn = Utils.parseInt(tokens[2]);
		ySpawn = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x <width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width +4)]);
			}
		}
		
	}//end loadWorld
	
//Getters and setters
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
		
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public EffectsManager getEffectsManager() {
		return effectsManager;
	}

	
	
}
