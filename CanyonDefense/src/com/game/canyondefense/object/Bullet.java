package com.game.canyondefense.object;


import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bullet{
    	private TextureRegion texture;
    	private float x,y,width,height;
	private float power;
	private int id;

	public Bullet(int id) {
	    
	}
	
	

	public TextureRegion getTexture() {
	    return texture;
	}



	public void setTexture(TextureRegion texture) {
	    this.texture = texture;
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
