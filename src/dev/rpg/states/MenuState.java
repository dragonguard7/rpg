package dev.rpg.states;

import java.awt.Graphics;

import dev.rpg.Handler;
import dev.rpg.gfx.Assets;
import dev.rpg.ui.ClickListener;
import dev.rpg.ui.UIImageButton;
import dev.rpg.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;
	
	public MenuState(final Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200,200, 128, 64, Assets.startButton, new ClickListener(){

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
				
			}}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}
}
