package dev.rpg.worlds;

import java.awt.Graphics;

import dev.rpg.tiles.Tile;
import dev.rpg.utils.Utils;

public class World {

	private int width, height;
	private int xSpawn, ySpawn;
	private int[][] tiles;
	
	public World(String path){
		loadWorld(path);
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				getTile(x,y).render(g,x * Tile.TILEWIDTH,y * Tile.TILEHEIGHT);
			}
		}
	}
	
	//This looks into Tiles array and looks up the 
	public Tile getTile(int x, int y){
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
		
	}
}
