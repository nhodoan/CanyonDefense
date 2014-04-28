package com.game.canyondefense;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.game.canyondefense.interfaces.AndroidInterface;

public class MainActivity extends AndroidApplication implements
	AndroidInterface {

    private SoundPool soundPool;
    private int click, fire, win, lose, heart_die, start_wave, attack,show_popup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
	cfg.useGL20 = false;
	soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

	click = soundPool.load(this, R.raw.click, 1);
	fire = soundPool.load(this, R.raw.fire, 1);
	win = soundPool.load(this, R.raw.winwinwin, 1);
	lose = soundPool.load(this, R.raw.lost, 1);
	heart_die = soundPool.load(this, R.raw.heart_die, 1);
	start_wave = soundPool.load(this, R.raw.start_wave, 1);
	attack = soundPool.load(this, R.raw.attack, 1);
	show_popup = soundPool.load(this, R.raw.build_defense, 1);
	initialize(new GameControl(this), cfg);
    }

    @Override
    public void soundClick() {
	// TODO Auto-generated method stub
	soundPool.play(click, 1, 1, 0, 0, 1);
    }

    @Override
    public void soundGround() {
	// TODO Auto-generated method stub

    }

    @Override
    public void soundFire() {
	// TODO Auto-generated method stub
	soundPool.play(fire, 1, 1, 0, 0, 1);
    }

    @Override
    public void soundDefense() {
	// TODO Auto-generated method stub
	soundPool.play(attack, 1, 1, 0, 0, 1);
    }

    @Override
    public void soundTouchObject() {
	// TODO Auto-generated method stub

    }

    @Override
    public void soundWin() {
	// TODO Auto-generated method stub
	soundPool.play(win, 1, 1, 0, 0, 1);
    }

    @Override
    public void soundLose() {
	// TODO Auto-generated method stub
	soundPool.play(lose, 1, 1, 0, 0, 1);
    }

    @Override
    public void soundHeartDie() {
	// TODO Auto-generated method stub
	soundPool.play(heart_die, 1, 1, 0, 0, 1);
    }

    @Override
    public void soundStartWave() {
	// TODO Auto-generated method stub
	soundPool.play(start_wave, 1, 1, 0, 0, 1);
    }

    @Override
    public void soundShowPopup() {
	// TODO Auto-generated method stub
	soundPool.play(show_popup, 1, 1, 0, 0, 1);
    }
}