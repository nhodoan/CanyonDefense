package com.game.canyondefense;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.canyondefense.interfaces.AndroidInterface;

public class Main implements AndroidInterface {
    private static Main main;
    
    public static void main(String[] args) {
	LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
	cfg.title = "Canyon Defense";
	cfg.useGL20 = false;
	cfg.width = 800;
	cfg.height = 480;
	main = new Main();
	new LwjglApplication(new GameControl(main), cfg);
    }

    @Override
    public void soundClick() {
    }

    @Override
    public void soundGround() {
	// TODO Auto-generated method stub

    }

    @Override
    public void soundFire() {
	// TODO Auto-generated method stub

    }

    @Override
    public void soundDefense() {
	// TODO Auto-generated method stub

    }

    @Override
    public void soundTouchObject() {
	// TODO Auto-generated method stub

    }

    @Override
    public void soundWin() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void soundLose() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void soundHeartDie() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void soundStartWave() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void soundShowPopup() {
	// TODO Auto-generated method stub
	
    }
}
