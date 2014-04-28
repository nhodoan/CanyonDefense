package com.game.canyondefense.object;

import com.game.canyondefense.global.IDPerson;

public class FireAttack {
    private int id;
    private float radius;
    private float x, y;
    private float power;

    public FireAttack(int id) {
	this.id = id;
	switch (id) {
	case IDPerson.FIRE_1:
	    radius = 100;
	    power = 30;
	    break;
	case IDPerson.FIRE_2:
	    radius = 150;
	    power = 40;
	    break;

	}
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

    public float getPower() {
        return power;
    }

    public float getRadius() {
	return radius;
    }

    public void setRadius(float radius) {
	this.radius = radius;
    }

    public int getId() {
	return id;
    }

    public boolean isInRadius(float x, float y) {
	return (x - this.x) * (x - this.x) + (y - this.y) * (y - this.y) < radius
		* radius;
    }

    public boolean isAttacked(AttackObject attackObject) {
	return isInRadius(attackObject.getX(), attackObject.getY())
		|| isInRadius(attackObject.getX(), attackObject.getY()
			+ attackObject.getHeight())
		|| isInRadius(attackObject.getX() + attackObject.getWidth(),
			attackObject.getY())
		|| isInRadius(attackObject.getX() + attackObject.getWidth(),
			attackObject.getY() + attackObject.getHeight());
    }
}
