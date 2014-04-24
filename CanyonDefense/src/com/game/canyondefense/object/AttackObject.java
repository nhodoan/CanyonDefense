package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDPerson;
import com.game.canyondefense.global.ManagerRegion;

public class AttackObject {
    protected float x, y, speed;
    private float width, height;
    private float blood;
    private int id;
    protected TextureRegion allTextureRegion;

    private boolean isDead;

    public AttackObject(int id) {
	isDead = false;
	width = Dimension.ATTACK_W;
	height = Dimension.ATTACK_H;
	switch (id) {
	case IDPerson.ATTACK_GROUND_1:
	    blood = 50;
	    speed = 40;
	    allTextureRegion = ManagerRegion.all_attack_ground_1;
	    break;
	case IDPerson.ATTACK_GROUND_2:
	    blood = 100;
	    allTextureRegion = ManagerRegion.all_attack_ground_2;
	    break;
	case IDPerson.ATTACK_AIR:
	    allTextureRegion = ManagerRegion.all_attack_air;
	    blood = 70;
	    break;
	}

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

}
