package dev.rpg.worlds;

import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.entities.EntityManager;
import dev.rpg.entities.creature.Player;
import dev.rpg.entities.statics.Tree;
import dev.rpg.tiles.Tile;
import dev.rpg.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int xSpawn, ySpawn;
	private int[][] tiles;
//Entities
	private EntityManager entityManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler,100,100));
		entityManager.addEntity(new Tree(handler, 100, 250));
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(xSpawn);
		entityManager.getPlayer().setX(ySpawn);
	}
	
	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/ Tile.TILEWIDTH); 
		int xEnd = (int)Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH +1);
		int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int)Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT +1);
		
		
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x,y).render(g,(int)(x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),(int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	//Entity
		entityManager.render(g);
		
	}
	
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
	
}
