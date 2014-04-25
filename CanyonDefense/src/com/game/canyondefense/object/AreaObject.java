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

		/*Object in Start Screen*/
		
		case IDObject.START_PLAY:
			x = Position.START_PLAY_X;
			y = Position.START_PLAY_Y;
			width = Dimension.START_PLAY_W;
			height = Dimension.START_PLAY_H;
			myTexture = ManagerRegion.new_game_normal;
			myTextureWait = ManagerRegion.new_game_press;
			break;
		case IDObject.START_HELP:
			x = Position.START_HELP_X;
			y = Position.START_HELP_Y;
			width = Dimension.START_HELP_W;
			height = Dimension.START_HELP_H;
			myTexture = ManagerRegion.help_normal;
			myTextureWait = ManagerRegion.help_press;
			break;
		case IDObject.START_HIGH_SCORE:
			x = Position.START_HIGH_SCORE_X;
			y = Position.START_HIGH_SCORE_Y;
			width = Dimension.START_HIGH_SCORE_W;
			height = Dimension.START_HIGH_SCORE_H;
			myTexture = ManagerRegion.high_score_normal;
			myTextureWait = ManagerRegion.high_score_press;
			break;
			
		/*Object in select map screen*/
			
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
			
		/* Object in select difficult screen */
		case IDObject.DIFF_EASY:
			x = Position.DIFF_EASY_X;
			y = Position.DIFF_EASY_Y;
			width = Dimension.DIFF_EASY_W;
			height = Dimension.DIFF_EASY_H;
			myTexture = ManagerRegion.diff_easy_normal;
			myTextureWait = ManagerRegion.diff_easy_press;
			break;
		case IDObject.DIFF_NORMAL:
			x = Position.DIFF_NORMAL_X;
			y = Position.DIFF_NORMAL_Y;
			width = Dimension.DIFF_NORMAL_W;
			height = Dimension.DIFF_NORMAL_H;
			myTexture = ManagerRegion.diff_medium_normal;
			myTextureWait = ManagerRegion.diff_medium_press;
			break;
		case IDObject.DIFF_HARD:
			x = Position.DIFF_HARD_X;
			y = Position.DIFF_HARD_Y;
			width = Dimension.DIFF_HARD_W;
			height = Dimension.DIFF_HARD_H;
			myTexture = ManagerRegion.diff_hard_normal;
			myTextureWait = ManagerRegion.diff_hard_press;
			break;
			
		/*Object in Play screen*/
			
		case IDObject.PLAY_MENU_PLAY:
			x = Position.PLAY_MENU_PLAY_X;
			y = Position.PLAY_MENU_PLAY_Y;
			width = Dimension.PLAY_MENU_PLAY_W;
			height = Dimension.PLAY_MENU_PLAY_H;
			myTexture = ManagerRegion.play_menu_pause_normal;
			myTextureWait = ManagerRegion.play_menu_pause_press;
			break;
		case IDObject.PLAY_MENU_SOUND:
			x = Position.PLAY_MENU_SOUND_X;
			y = Position.PLAY_MENU_SOUND_Y;
			width = Dimension.PLAY_MENU_SOUND_W;
			height = Dimension.PLAY_MENU_SOUND_H;
			myTexture = ManagerRegion.play_menu_sound_on_normal;
			myTextureWait = ManagerRegion.play_menu_sound_on_press;
			break;
		case IDObject.PLAY_MENU_QUIT:
			x = Position.PLAY_MENU_QUIT_X;
			y = Position.PLAY_MENU_QUIT_Y;
			width = Dimension.PLAY_MENU_QUIT_W;
			height = Dimension.PLAY_MENU_QUIT_H;
			myTexture = ManagerRegion.play_menu_quit_normal;
			myTextureWait = ManagerRegion.play_menu_quit_press;
			break;
			
		case IDObject.PLAY_MENU_DEFENSE_1:
			width = Dimension.PLAY_MENU_DEFENSE_1_W;
			height = Dimension.PLAY_MENU_DEFENSE_1_H;
			myTexture = ManagerRegion.play_menu_defense_1_normal;
			myTextureWait = ManagerRegion.play_menu_defense_1_press;
			break;
		case IDObject.PLAY_MENU_DEFENSE_2:
			width = Dimension.PLAY_MENU_DEFENSE_2_W;
			height = Dimension.PLAY_MENU_DEFENSE_2_H;
			myTexture = ManagerRegion.play_menu_defense_2_normal;
			myTextureWait = ManagerRegion.play_menu_defense_2_press;
			break;
		case IDObject.PLAY_MENU_DEFENSE_3:
			width = Dimension.PLAY_MENU_DEFENSE_3_W;
			height = Dimension.PLAY_MENU_DEFENSE_3_H;
			myTexture = ManagerRegion.play_menu_defense_3_normal;
			myTextureWait = ManagerRegion.play_menu_defense_3_press;
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
	
	

	public void setMyTexture(TextureRegion myTexture) {
	    this.myTexture = myTexture;
	}

	public void setMyTextureWait(TextureRegion myTextureWait) {
	    this.myTextureWait = myTextureWait;
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
