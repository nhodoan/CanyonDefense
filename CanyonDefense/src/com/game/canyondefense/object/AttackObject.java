package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDPerson;
import com.game.canyondefense.global.ManagerRegion;

public class AttackObject {
    protected float x, y, speed;
    private float width, height;
    private float blood, max_blood;
    private int id;
    protected TextureRegion allTextureRegion;
    protected TextureRegion texture;
    private boolean isStart;
    protected int statusMove;
    protected int type;
    
    public int getType() {
        return type;
    }

    private int gold;

    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int UP = 3;

    public float getMax_blood() {
	return max_blood;
    }

    private boolean isDead;

    public AttackObject(int id) {
	this.id = id;
	isDead = false;
	isStart = false;
	width = Dimension.ATTACK_W;
	height = Dimension.ATTACK_H;
	
	
	statusMove = RIGHT;
	switch (id) {
	case IDPerson.ATTACK_GROUND_1:
	    blood = 80;
	    speed = 40;
	    allTextureRegion = ManagerRegion.all_attack_ground_1;
	    gold = 30;
	    break;
	case IDPerson.ATTACK_GROUND_2:
	    blood = 100;
	    speed = 45;
	    allTextureRegion = ManagerRegion.all_attack_ground_2;
	    gold = 50;
	    break;
	case IDPerson.ATTACK_AIR_1:
	    allTextureRegion = ManagerRegion.all_attack_air_1;
	    speed = 40;
	    blood = 100;
	    gold = 50;
	    break;
	case IDPerson.ATTACK_AIR_2:
	    allTextureRegion = ManagerRegion.all_attack_air_2;
	    speed = 50;
	    blood = 150;
	    gold = 70;
	    break;
	}
	
	max_blood = blood;

    }

    public int getGold() {
        return gold;
    }

    public boolean isDead() {
	return isDead;
    }

    public void setDead(boolean isDead) {
	this.isDead = isDead;
    }

    public int getId() {
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

    public void setId(int id) {
	this.id = id;
    }

    public float getBlood() {
	return blood;
    }

    public void setBlood(float blood) {
	this.blood = blood;
    }

    public void setStart(boolean isStart) {
	this.isStart = isStart;
    }

    public boolean isStart() {
	return this.isStart;
    }

    public int getStatusMove() {
	return statusMove;
    }

    public void setStatusMove(int statusMove) {
	this.statusMove = statusMove;
    }

    public TextureRegion getTexture() {
	return this.texture;
    }

    public void move(float deltatime) {
	// TODO Auto-generated method stub

    }

    public void attack(float decreaseBlood) {
	this.blood -= decreaseBlood;
	if (this.blood <= 0)
	    setDead(true);
    }

}
