package com.game.canyondefense.object;

import com.game.canyondefense.global.Position;

public class GoldAdd {

    private float x, y;
    private int gold;

    public GoldAdd(int gold) {
	this.gold = gold;
	x = Position.MENU_GOLD_FRAME_X + 10 * Position.width / 480;
	y = Position.MENU_GOLD_FRAME_Y - 100 * Position.height / 480;
    }

    public void move() {
	y += Position.height / 480;
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

    public int getGold() {
	return gold;
    }

    public void setGold(int gold) {
	this.gold = gold;
    }
}
