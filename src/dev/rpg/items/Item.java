package dev.rpg.items;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.rpg.Handler;
import dev.rpg.gfx.Assets;

public class Item {

	//Item handler
	
	public static Item[] items = new Item[256];
	public static Item money = new Item(Assets.money, "Gold", 0);
	
	
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	protected boolean pickedUp = false;
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	protected Rectangle bounds;
	
	protected int x, y, count;
	
	public Item(BufferedImage texture, String name, int id){
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		bounds = new Rectangle(0,0,ITEMWIDTH,ITEMHEIGHT);
	
		items[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if(handler == null){
			return;
		}
		render(g, (int)(x - handler.getGameCamera().getxOffset()), (int)(y- handler.getGameCamera().getyOffset()));
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
		
		//g.setColor(Color.red);
		//g.fillRect((int)(x + bounds.x -handler.getGameCamera().getxOffset()), (int)(y + bounds.y -handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
//		g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);

		
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Item createNew(int x, int y){
		Item i = new Item(texture, name, id);
		i.setPosition(x, y);
		return i;
	}
	
	public Rectangle itemOffset(){
		return(new Rectangle((int)(x + bounds.x - handler.getGameCamera().getxOffset()),
				(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height));
	}
	
	
	
//Getters and setters
	
	public Handler getHandler() {
		return handler;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}
	
	
}
