package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.global.ManagerRegion;
import com.game.canyondefense.global.Position;

public class Fire {
    private int id;
   
    private float x, y;
    private TextureRegion texureNormal,texturePress;
    private boolean canPress;
    private boolean isSelect;
    private float width,height;

    public Fire(int id) {
	this.id = id;
	isSelect = false;
	canPress = true;
	switch (id) {
	case IDObject.PLAY_MENU_FIRE_1:
	    x = Position.PLAY_MENU_FIRE_1_X;
	    y = Position.PLAY_MENU_FIRE_Y;
	    width = Dimension.FIRE_W;
	    height = Dimension.FIRE_H;
	    texureNormal = ManagerRegion.fire_1_normal;
	    texturePress = ManagerRegion.fire_1_press;
	    break;
	case IDObject.PLAY_MENU_FIRE_2:
	    x = Position.PLAY_MENU_FIRE_2_X;
	    y = Position.PLAY_MENU_FIRE_Y;
	    width = Dimension.FIRE_W;
	    height = Dimension.FIRE_H;
	    texureNormal = ManagerRegion.fire_2_normal;
	    texturePress = ManagerRegion.fire_2_press;
	    break;
	}
    }


    public boolean canPress() {
        return canPress;
    }


    public void setCanPress(boolean canPress) {
        this.canPress = canPress;
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


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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


    public boolean isSelect() {
        return isSelect;
    }


    public void setSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }


    public TextureRegion getTexture() {
	if(isSelect)
	    return texturePress;
	else return texureNormal;
    }
    
    public boolean isInBound(float x_press, float y_press) {
	if (this.x < x_press && x_press < this.x + this.width
		&& this.y < y_press && y_press < this.y + this.height)
	    return true;
	else
	    return false;
    }
}
