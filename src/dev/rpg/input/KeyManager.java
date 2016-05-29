package dev.rpg.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean aUp, aDown, aLeft, aRight, rKey;
	
	public void tick(){
		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
		
		up = keys[KeyEvent.VK_W];	
		down = keys[KeyEvent.VK_S];		
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		rKey = keys[KeyEvent.VK_R];
	}
	
	public KeyManager(){
		keys = new boolean[256];
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

	
	public void keyTyped(KeyEvent arg0) {
		
		
	}

}
