package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet extends Sprite{
	private float power;
	private int id;

	public Bullet(int id) {
	}

	public float getPower() {
	    return power;
	}

	public void setPower(float power) {
	    this.power = power;
	}

	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}
	
	
}
