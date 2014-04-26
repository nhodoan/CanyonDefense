package com.game.canyondefense.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.ManagerRegion;

public class Bullet {
    private TextureRegion texture;
    private float x, y, width, height;
    private float power;
    private float a, b;
    private float speed;
    public static int TYPE_GROUND = 0;
    public static int TYPE_AIR = 1;

    private int type;

    public Bullet() {
	speed = 10;
	power = 50;
	texture = ManagerRegion.bullet;
	width = Dimension.BRICK_W / 2;
	height = Dimension.BRICK_H / 2;
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
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public float getPower() {
	return power;
    }

    public void setPower(float power) {
	this.power = power;
    }

    public void move(float deltatime) {
	x += deltatime * a * speed;
	y += deltatime * b * speed;
    }

    public void genRoute(float x0, float y0) {
	a = x0 - x;
	b = y0 - y;
	Gdx.app.log("A :", String.valueOf(a));
	Gdx.app.log("B :", String.valueOf(b));
    }
}
