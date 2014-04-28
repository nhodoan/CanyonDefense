package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDPerson;
import com.game.canyondefense.global.ManagerRegion;
import com.game.canyondefense.global.Sale;

public class DefenseObject {
	private float x,y,width,height;
	private float power;
	private TextureRegion textureRegion_normal, textureRegion_press;
	private boolean isPress;
	private float radius_attack;
	
	private long timeOldFire;
	private int id;
	protected int type;
	private int sale;
	
	public DefenseObject(int id){
	    this.id = id;
	    width = Dimension.DEFENSE_W;
	    height = Dimension.DEFENSE_H;
	    
	    isPress = false;
	    timeOldFire = 0;
	    radius_attack = Dimension.DEFENSE_H * 3;
	    switch(id){
	    case IDPerson.DEFENSE_GROUND_1:
		textureRegion_normal = ManagerRegion.defense1_normal;
		textureRegion_press = ManagerRegion.defense1_press;
		power = 20;
		sale = Sale.GROUND_1;
		break;
	    case IDPerson.DEFENSE_GROUND_2:
		textureRegion_normal = ManagerRegion.defense2_normal;
		textureRegion_press = ManagerRegion.defense2_press;
		sale = Sale.GROUND_2;
		power = 30;
		break;
	    case IDPerson.DEFENSE_AIR_1:
		textureRegion_normal = ManagerRegion.defense3_normal;
		textureRegion_press = ManagerRegion.defense3_press;
		sale = Sale.AIR_1;
		power = 25;
		break;
	    case IDPerson.DEFENSE_AIR_2:
		textureRegion_normal = ManagerRegion.defense3_normal;
		textureRegion_press = ManagerRegion.defense3_press;
		sale = Sale.AIR_2;
		power = 40;
		break;
	    }
	}
	public int getSale() {
	    return sale;
	}
	public int getId() {
	    return id;
	}
	public long getTimeOldFire() {
	    return timeOldFire;
	}
	public void setTimeOldFire(long timeOldFire) {
	    this.timeOldFire = timeOldFire;
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
	
	public int getType() {
	    return type;
	}
	public boolean isInRadius(float x,float y){
	    return (this.x + this.width/2 - x)*(this.x + this.width/2 - x) +
		    (this.y + this.height/2 - y)*(this.y + this.height/2 - y)< radius_attack*radius_attack;
	}
	
	public boolean isInBound(float x_press,float y_press){
	    if (this.x < x_press && x_press < this.x + this.width
			&& this.y < y_press && y_press < this.y + this.height)
		return true;
	else
		return false;
	}
	
	
}
