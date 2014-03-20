package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.global.ManagerRegion;
import com.game.canyondefense.global.Position;

public class AreaObject {

	private float x, y, width, height;
	private TextureRegion myTexture, myTextureWait;
	private boolean canPress;
	private int id;

	public AreaObject(int id) {
		canPress = true;
		this.id = id;
		switch (id) {

		case IDObject.START_PLAY:
			x = Position.START_PLAY_X;
			y = Position.START_PLAY_Y;
			width = Dimension.START_PLAY_W;
			height = Dimension.START_PLAY_H;
			myTexture = ManagerRegion.start_play;
			myTextureWait = ManagerRegion.start_play_press;
			break;
		case IDObject.START_HELP:
			x = Position.START_HELP_X;
			y = Position.START_HELP_Y;
			width = Dimension.START_HELP_W;
			height = Dimension.START_HELP_H;
			myTexture = ManagerRegion.start_help;
			myTextureWait = ManagerRegion.start_help_press;
			break;
		case IDObject.START_HIGH_SCORE:
			x = Position.START_HIGH_SCORE_X;
			y = Position.START_HIGH_SCORE_Y;
			width = Dimension.START_HIGH_SCORE_W;
			height = Dimension.START_HIGH_SCORE_H;
			myTexture = ManagerRegion.start_high_score;
			myTextureWait = ManagerRegion.start_high_score_press;
			break;
		case IDObject.MAP_1:
			x = Position.MAP_1_X;
			y = Position.MAP_1_Y;
			width = Dimension.MAP_1_W;
			height = Dimension.MAP_1_H;
			myTexture = ManagerRegion.map_1;
			myTextureWait = ManagerRegion.map_1_press;
			break;
		case IDObject.MAP_2:
			x = Position.MAP_2_X;
			y = Position.MAP_2_Y;
			width = Dimension.MAP_2_W;
			height = Dimension.MAP_2_H;
			myTexture = ManagerRegion.map_2;
			myTextureWait = ManagerRegion.map_2_press;
			break;
		case IDObject.MAP_3:
			x = Position.MAP_3_X;
			y = Position.MAP_3_Y;
			width = Dimension.MAP_3_W;
			height = Dimension.MAP_3_H;
			myTexture = ManagerRegion.map_3;
			myTextureWait = ManagerRegion.map_3_press;
			break;
		}
		
		

	}

	public void updateArea() {
		
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getID() {
		return this.id;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	public float getWidth() {
		return this.width;
	}

	public float getHeight() {
		return this.height;
	}

	public TextureRegion getTexture() {
		if (canPress) {
			return myTexture;
		} else {
			return myTextureWait;
		}
	}

	public void setCanPress(boolean canPress) {
		this.canPress = canPress;
	}

	public boolean canPress() {
		return this.canPress;
	}

	public boolean isInBound(float x_press, float y_press) {
		if (this.x < x_press && x_press < this.x + this.width
				&& this.y < y_press && y_press < this.y + this.height)
			return true;
		else
			return false;
	}
}
