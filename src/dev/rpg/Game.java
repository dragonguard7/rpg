package dev.rpg;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.rpg.display.Display;
import dev.rpg.gfx.ImageLoader;
import dev.rpg.gfx.SpriteSheet;

public class Game implements Runnable {
	
	private Display display;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	
	public int width, height;
	public String title;
	
	//Test code
	private BufferedImage test; //Test code
	private SpriteSheet sheet;
	
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	//initialize graphics
	private void init(){
		display = new Display(title,width, height);
		test = ImageLoader.loadImage("/textures/spritesheet256.png"); //Test code
		sheet = new SpriteSheet(test);
	}
	
	private void tick(){
		
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0, 0, width, height);
		
		//start render
		
		g.drawImage(sheet.crop(0, 0, 32, 32), 20, 20, null);
		
		//end render
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
	
		init();
		
		while(running){
			tick();
			render();
		}
		
		stop();//incase it didnt stop already
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);	//Put the game class on the thread then calls run
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
