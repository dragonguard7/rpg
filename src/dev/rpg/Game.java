package dev.rpg;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import dev.rpg.display.Display;
import dev.rpg.gfx.Assets;
import dev.rpg.gfx.GameCamera;
import dev.rpg.input.KeyManager;
import dev.rpg.states.GameState;
import dev.rpg.states.State;


public class Game implements Runnable {
	
	private Display display;
	private Thread thread;
	private boolean running = false;
	private BufferStrategy bs;
	private Graphics g;
	

	private int width, height;
	
	public String title;	
	
	//States
	private State gameState;
	
	
	//Inputs
	private KeyManager keyManager;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	//Camera
	private GameCamera gameCamera;
	
//initialize graphics
	private void init(){
		display = new Display(title,width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0, 0);
		
		gameState = new GameState(this); //test code
		State.setState(gameState); //test code
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}

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
		
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		//end render
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
	
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
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
	
	//******Getters and setters
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
