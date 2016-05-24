package dev.rpg.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, up2, down, down2, left, left2, right, right2;
	
	public void tick(){
		up = keys[KeyEvent.VK_UP];
		up2 = keys[KeyEvent.VK_W];
		
		down = keys[KeyEvent.VK_DOWN];
		down2 = keys[KeyEvent.VK_S];
		
		left = keys[KeyEvent.VK_LEFT];
		left2 = keys[KeyEvent.VK_A];
		
		right = keys[KeyEvent.VK_RIGHT];
		right2 = keys[KeyEvent.VK_D];
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
