package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.ManagerRegion;

public class AttackObject {
	private float x, y;
	private float width, height;
	private TextureRegion texture;
	private float blood;
	private int id;
	private boolean isDead;
	public AttackObject(int id){
		switch(id){
		case 0:
			x = 0;
			y = 0;
			width = 0;
			height= 0;
			texture = ManagerRegion.map_1;
			blood = 50;
			break;
		}
		isDead = false;
	}
	
	
	public boolean isDead() {
	    return isDead;
	}


	public void setDead(boolean isDead) {
	    this.isDead = isDead;
	}


	public int getId(){
		return this.id;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	

	public TextureRegion getTexture() {
		return texture;
	}

	public void setTexture(TextureRegion texture) {
		this.texture = texture;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBlood() {
		return blood;
	}

	public void setBlood(float blood) {
		this.blood = blood;
	}

}
