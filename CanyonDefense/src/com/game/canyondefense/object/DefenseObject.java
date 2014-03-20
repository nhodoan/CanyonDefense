package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DefenseObject {
	private float x,y,width,height;
	private float power;
	private TextureRegion textureRegion_normal, textureRegion_press;
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
	public TextureRegion getTextureRegion_normal() {
		return textureRegion_normal;
	}
	public void setTextureRegion_normal(TextureRegion textureRegion_normal) {
		this.textureRegion_normal = textureRegion_normal;
	}
	public TextureRegion getTextureRegion_press() {
		return textureRegion_press;
	}
	public void setTextureRegion_press(TextureRegion textureRegion_press) {
		this.textureRegion_press = textureRegion_press;
	}
	
	
}
