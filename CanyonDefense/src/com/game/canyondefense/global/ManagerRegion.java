package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;

public class ManagerRegion {
	
	public static TextureRegion new_game_normal,new_game_press;
	public static TextureRegion help_normal,help_press;
	public static TextureRegion high_score_normal,high_score_press;
	
	public static TextureRegion map_1;
	public static TextureRegion map_1_press;
	public static TextureRegion map_2;
	public static TextureRegion map_2_press;
	public static TextureRegion map_3;
	public static TextureRegion map_3_press;
	
	public static TextureRegion diff_easy_normal;
	public static TextureRegion diff_easy_press;
	public static TextureRegion diff_medium_normal;
	public static TextureRegion diff_medium_press;
	public static TextureRegion diff_hard_normal;
	public static TextureRegion diff_hard_press;
	
	
	public static TextureRegion menu_bg;
	public static TextureRegion play_menu_play;
	public static TextureRegion play_menu_sound;
	public static TextureRegion play_menu_quit;
	
	public static TextureRegion play_menu_defense_1;
	public static TextureRegion play_menu_defense_2;
	public static TextureRegion play_menu_defense_3;

	public static TextureRegion landmarkdefense;
	public static TextureRegion brick;
	
	public static void init(){
		TextureAtlas atlas = GameControl.getAtlas();
		new_game_normal = atlas.findRegion("startscreen/new_game_normal");
		new_game_press = GameControl.getAtlas().findRegion("startscreen/new_game_press");
		help_normal = GameControl.getAtlas().findRegion("startscreen/help_normal");
		help_press = GameControl.getAtlas().findRegion("startscreen/help_press");
		high_score_normal = GameControl.getAtlas().findRegion("startscreen/high_score_normal");
		high_score_press = GameControl.getAtlas().findRegion("startscreen/high_score_normal");
		
		map_1 = GameControl.getAtlas().findRegion("mapscreen/map_1_normal");
		map_1_press = GameControl.getAtlas().findRegion("mapscreen/map_1_hover");
		map_2 = GameControl.getAtlas().findRegion("mapscreen/map_2_normal");
		map_2_press = GameControl.getAtlas().findRegion("mapscreen/map_2_hover");
		map_3 = GameControl.getAtlas().findRegion("mapscreen/map_3_normal");
		map_3_press = GameControl.getAtlas().findRegion("mapscreen/map_3_hover");
		
		diff_easy_normal = GameControl.getAtlas().findRegion("diffscreen/diff_easy_normal");
		diff_easy_press = GameControl.getAtlas().findRegion("diffscreen/diff_easy_press");
		diff_medium_normal = GameControl.getAtlas().findRegion("diffscreen/diff_medium_normal");
		diff_medium_press = GameControl.getAtlas().findRegion("diffscreen/diff_medium_press");
		diff_hard_normal = GameControl.getAtlas().findRegion("diffscreen/diff_hard_normal");
		diff_hard_press = GameControl.getAtlas().findRegion("diffscreen/diff_hard_press");
		
		menu_bg = GameControl.getAtlas().findRegion("playscreen/menu/bg_menu");
		
		play_menu_play = GameControl.getAtlas().findRegion("playscreen/menu/play");
		play_menu_sound = GameControl.getAtlas().findRegion("playscreen/menu/sound_on");
		play_menu_quit = GameControl.getAtlas().findRegion("playscreen/menu/quit");
		
		play_menu_defense_1 = GameControl.getAtlas().findRegion("playscreen/menu/weapon_info_1_normal");
		play_menu_defense_2 = GameControl.getAtlas().findRegion("playscreen/menu/weapon_info_2_normal");
		play_menu_defense_3 = GameControl.getAtlas().findRegion("playscreen/menu/weapon_info_3_normal");
//		
		brick = GameControl.getAtlas().findRegion("playscreen/brick");
//		diff_easy = GameControl.getAtlas().findRegion("difficultscreen/diff_easy");
//		diff_normal = GameControl.getAtlas().findRegion("difficultscreen/diff_easy");
//		diff_hard = GameControl.getAtlas().findRegion("difficultscreen/diff_easy");
	}
}
