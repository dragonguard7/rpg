package dev.rpg.inventory;

import java.awt.Color;
import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.items.Item;

public class Slot{

	public static final int SLOTWIDTH = 32, SLOTHEIGHT =32;
	
	private Handler handler;
	private int x, y;
	private Item item;
	
	public Slot(Item item, int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.GRAY);
		g.fillRect(x, y, SLOTWIDTH, SLOTHEIGHT);
		
		g.setColor(Color.black);
		g.drawRect(x, y, SLOTWIDTH, SLOTHEIGHT);
		
		if(this.item != null){
			g.drawImage(this.item.getTexture(), x, y, SLOTWIDTH, SLOTHEIGHT, null);
			g.drawString(Integer.toString(item.getCount()), x + SLOTWIDTH -20, y + SLOTHEIGHT - 10);
		}
	}

	public boolean addItem(Item item, int amount){
		
		if(item != null){
			System.out.println("Item is null");
			if(item.getId() == this.item.getId()){
				this.item.setCount(this.item.getCount() + amount);
				return true;
			}else{
				return false;
			}
		}else{
			this.item = item;
			return true;
		}
		
	}
	
	
//Getters and setters
	public Item getItem(){
		return item;
	}
	public void setItem(Item item){
		this.item = item;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
