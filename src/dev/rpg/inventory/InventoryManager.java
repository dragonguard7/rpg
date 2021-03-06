package dev.rpg.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import dev.rpg.Handler;
import dev.rpg.items.Item;

public class InventoryManager {
	
	private Handler handler;
	private int x, y;
	private int width, height;	
	private int numCols = 6, numRows = 4;	
	private ArrayList<Slot> itemSlots;
	private Slot curSelectedSlot;
	private boolean hasBeenPressed = false;
	
	public boolean isOpen = false;
	
	public InventoryManager(Handler handler,int x, int y){
		this.handler = handler;
		this.x = x;
		this.y = y;
		itemSlots = new ArrayList<Slot>();
		
		for(int i = 0; i < numCols; i++){
			for(int j = 0; j < numRows; j++){
				if(j == (numRows -1)){
					y += 35;
				}			
				itemSlots.add(new Slot(null,x + (i * (Slot.SLOTWIDTH + 10)), y +(j * (Slot.SLOTHEIGHT + 10))));
										
				if(j == (numRows -1)){
					y -= 35;
				}
					
			}
		}
		width = numCols * (Slot.SLOTWIDTH +10);
		height = numRows * (Slot.SLOTHEIGHT + 10) + 35;
	}

	public void tick(){
		if(isOpen){
			Rectangle temp = new Rectangle(handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),1,2);
			for(Slot is : itemSlots){
				is.tick();
				Rectangle temp2 = new Rectangle(is.getX(), is.getY(), Item.ITEMWIDTH, Item.ITEMHEIGHT);
			
				if(handler.getMouseManager().isLeftPressed() && !hasBeenPressed){
					hasBeenPressed = true;
					System.out.println("pressed left");
					
					if(temp2.contains(temp)){
						if(is.getItem() != null){
							if(curSelectedSlot == null){
								curSelectedSlot = is;
								is.setItem(null);								
							}
						}	else{
							if(curSelectedSlot != null){
								if(is.addItem(curSelectedSlot.getItem(), curSelectedSlot.getItem().getCount())){
									
								}else{
									is.setItem(curSelectedSlot.getItem());
								}
								curSelectedSlot = null;	
							}
						}
					}
					if(hasBeenPressed && !handler.getMouseManager().isLeftPressed()){
						hasBeenPressed = false;
					}
				}
			}
		}
	}
	
	public void render(Graphics g){
		if(isOpen){
			g.setColor(Color.lightGray);
			g.fillRect(x - 17, y - 17, width + 30, height + 30);
			
			g.setColor(Color.black);
			g.drawRect(x - 17, y - 17, width + 30, height + 30);
		
			for(Slot is : itemSlots){
				is.render(g);
			}
			/*
			if(curSelectedSlot != null){
				g.drawImage(curSelectedSlot.getItem().getTexture(), handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), null);
				g.drawString(Integer.toString(curSelectedSlot.getItem().getCount()), handler.getMouseManager().getMouseX() + 27, handler.getMouseManager().getMouseY()+ 10);
			}
			*/
		}
	}
	
	public void addItemToInventory(Item i){
		for(Slot is : itemSlots){
			System.out.println(i.getId());
			if(is.getItem() != null && is.getItem().getId() == i.getId()){
				is.getItem().setCount(is.getItem().getCount()+i.getCount());
				return;
			}
		}
		for(Slot is : itemSlots){
			if(is.getItem() == null){
				is.setItem(i);
				return;
			}
		}
	}
	
	
//Getters and setters	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Slot> getItemSlots() {
		return itemSlots;
	}

	public void setItemSlots(ArrayList<Slot> itemSlots) {
		this.itemSlots = itemSlots;
	}
	
	
}
