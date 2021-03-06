package dev.rpg.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import dev.rpg.Handler;

public class ItemManager {

	private Handler handler;
	private ArrayList<Item> items;
	
	
	public ItemManager(Handler handler){
		this.handler = handler;
		items = new ArrayList<Item>();
		
	}
	
	public void tick(){
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item i = it.next();
			i.tick();
			//This just removes it from the world does not add it any inventory
			if(i.pickedUp){
				it.remove();
			}
		}
	}
	
	public void render(Graphics g){
		for(Item i : items){
			i.render(g);
		}
	}
	
	public void addItem(Item i){
		i.setHandler(handler);
		items.add(i);
	}
//Getters and setters

	
	public Handler getHandler() {
		return handler;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	
}
