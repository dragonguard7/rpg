package dev.rpg;

import dev.rpg.display.Display;

public class Game implements Runnable {
	
	private Display display;
	private Thread thread;
	private boolean running = false;
	
	public int width, height;
	public String title;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	//initialize graphics
	private void init(){
		display = new Display(title,width, height);
	}
	
	private void tick(){
		
	}
	
	private void render(){
		
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
