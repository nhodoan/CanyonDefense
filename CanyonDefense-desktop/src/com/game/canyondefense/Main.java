package com.game.canyondefense;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Canyon Defense";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 480;		
		new LwjglApplication(new GameControl(), cfg);
	}
}
