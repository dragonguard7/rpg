package dev.rpg.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 64, height = 64;
	public static BufferedImage playerStill, grass, water, tree, stone, road, dirt, brick, monster, money;
	public static BufferedImage[] playerUp, playerDown, playerRight, playerLeft;
	public static BufferedImage[] startButton;
	public static BufferedImage attack, mushroom;
	

	
	
	public static void init(){
		//SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet512.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/teemo.png"));
		
		playerRight = new BufferedImage[2];
		playerLeft = new BufferedImage[2];
		playerUp = new BufferedImage[2];
		playerDown = new BufferedImage[2];
		startButton = new BufferedImage[2];
		
		playerRight[0] = sheet.crop(1 * width, 2 * height, width, height);
		playerRight[1] = sheet.crop(0 * width, 2 * height, width, height);
		playerLeft[0] = sheet.crop(1 * width, 1 * height, width, height);
		playerLeft[1] = sheet.crop(0 * width, 1 * height, width, height);
		playerUp[0] = sheet.crop(1 * width, 3 * height, width, height);
		playerUp[1] = sheet.crop(0 * width, 3 * height, width, height);
		playerDown[0] = sheet.crop(1 * width, 0 * height, width, height);
		playerDown[1] = sheet.crop(0 * width, 0 * height, width, height);
		playerStill = playerDown[0];
		startButton[0] = sheet.crop(6 * width, 6 * height, width *2, height);
		startButton[1] = sheet.crop(6 * width, 7 * height, width *2, height);
		monster = sheet.crop(2 * width, 2 * height, width, height);
		money = sheet.crop(0 * width, 7 * height, width, height);
		attack = sheet.crop(0 * width, 6 * height, width, height);
		mushroom = sheet.crop(1 * width, 7 * height, width, height);
		
		
		grass = sheet.crop(2 * width, 1 * height, width, height);
		water = sheet.crop(2 * width, 0 * height, width, height);
		tree = sheet.crop(3 * width, 0 * height, width, height);
		stone = sheet.crop(4 * width, 0 * height, width, height);
		road = sheet.crop(5 * width, 0 * height, width, height);
		dirt = sheet.crop(6 * width, 0 * height, width, height);
		brick = sheet.crop(7 * width, 0 * height, width, height);
		
	}
}
