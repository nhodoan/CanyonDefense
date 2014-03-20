package com.game.canyondefense.global;

public class MyPoint {
    private float x, y, width, height;
    private boolean isTouched;
    

    public MyPoint(float x, float y, float width, float height,boolean isTouched) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.isTouched = isTouched;
	
    }

    public boolean isInBound(float x_pre, float y_pre) {
	return x < x_pre && x_pre < x + width && y < y_pre
		&& y_pre < y + height;
    }

    public boolean isTouched() {
        return isTouched;
    }

    public void setTouched(boolean isTouched) {
        this.isTouched = isTouched;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
    
    
}