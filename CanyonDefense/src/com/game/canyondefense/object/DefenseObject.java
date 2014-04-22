package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DefenseObject {
	private float x,y,width,height;
	private float power;
	private TextureRegion textureRegion_normal, textureRegion_press;
	private boolean isPress;
	private float radius_attack;
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
	
	
	
	public float getRadius_attack() {
	    return radius_attack;
	}
	public void setRadius_attack(float radius_attack) {
	    this.radius_attack = radius_attack;
	}
	public boolean isPress() {
	    return isPress;
	}
	public void setPress(boolean isPress) {
	    this.isPress = isPress;
	}
	public TextureRegion getTexture(){
	    if(isPress)
		return getTextureRegion_press();
	    return getTextureRegion_normal();
	}
	private TextureRegion getTextureRegion_normal() {
		return textureRegion_normal;
	}
	private TextureRegion getTextureRegion_press() {
		return textureRegion_press;
	}
	
	public boolean isInBound(float x_press,float y_press){
	    if (this.x < x_press && x_press < this.x + this.width
			&& this.y < y_press && y_press < this.y + this.height)
		return true;
	else
		return false;
	}
	
	
}
