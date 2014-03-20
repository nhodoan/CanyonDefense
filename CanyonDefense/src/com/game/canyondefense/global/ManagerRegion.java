package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;

public class ManagerRegion {
	
	public static TextureRegion start_play,start_play_press;
	public static TextureRegion start_help,start_help_press;
	public static TextureRegion start_high_score,start_high_score_press;
	
	public static TextureRegion map_1;
	public static TextureRegion map_1_press;
	public static TextureRegion map_2;
	public static TextureRegion map_2_press;
	public static TextureRegion map_3;
	public static TextureRegion map_3_press;
	
	public static TextureRegion diff_easy;
	public static TextureRegion diff_normal;
	public static TextureRegion diff_hard;	
	
	public static void init(){
		TextureAtlas atlas = GameControl.getAtlas();
		start_play = atlas.findRegion("startscreen/start_play");
		start_play_press = GameControl.getAtlas().findRegion("startscreen/start_play_hover");
		Gdx.app.log("tag", String.valueOf(start_play.getRegionHeight()));
		start_help = GameControl.getAtlas().findRegion("startscreen/start_help");
		start_help_press = GameControl.getAtlas().findRegion("startscreen/start_help_hover");
		start_high_score = GameControl.getAtlas().findRegion("startscreen/start_high_score");
		start_high_score_press = GameControl.getAtlas().findRegion("startscreen/start_high_score_hover");
		
		map_1 = GameControl.getAtlas().findRegion("mapscreen/map_1_normal");
		map_1_press = GameControl.getAtlas().findRegion("mapscreen/map_1_hover");
		map_2 = GameControl.getAtlas().findRegion("mapscreen/map_2_normal");
		map_2_press = GameControl.getAtlas().findRegion("mapscreen/map_2_hover");
		map_3 = GameControl.getAtlas().findRegion("mapscreen/map_3_normal");
		map_3_press = GameControl.getAtlas().findRegion("mapscreen/map_3_hover");
//		
//		diff_easy = GameControl.getAtlas().findRegion("difficultscreen/diff_easy");
//		diff_normal = GameControl.getAtlas().findRegion("difficultscreen/diff_easy");
//		diff_hard = GameControl.getAtlas().findRegion("difficultscreen/diff_easy");
	}
}
