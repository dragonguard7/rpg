package dev.rpg.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64;
	public static BufferedImage grass, water, tree, stone, road, dirt, brick;
	public static BufferedImage playerStill, playerUp, playerDown, playerRight, playerLeft;
	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet512.png"));
		
		playerStill = sheet.crop(0 * width, 4 * height, width, height);
		playerRight = sheet.crop(0 * width, 0 * height, width, height);
		playerLeft= sheet.crop(0 * width, 1 * height, width, height);
		playerUp = sheet.crop(0 * width, 2 * height, width, height);
		playerDown = sheet.crop(0 * width, 3 * height, width, height);
		
		
		
		grass = sheet.crop(1 * width, 0 * height, width, height);
		water = sheet.crop(2 * width, 0 * height, width, height);
		tree = sheet.crop(3 * width, 0 * height, width, height);
		stone = sheet.crop(4 * width, 0 * height, width, height);
		road = sheet.crop(5 * width, 0 * height, width, height);
		dirt = sheet.crop(6 * width, 0 * height, width, height);
		brick = sheet.crop(7 * width, 0 * height, width, height);
		
	}
}
