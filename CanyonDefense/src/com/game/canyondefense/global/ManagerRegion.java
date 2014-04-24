package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;

public class ManagerRegion {
	
    	public static TextureRegion star_bg;
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
	public static TextureRegion play_menu_pause_normal;
	public static TextureRegion play_menu_pause_press;
	public static TextureRegion play_menu_sound_on_normal;
	public static TextureRegion play_menu_sound_off_normal;
	public static TextureRegion play_menu_sound_on_press;
	public static TextureRegion play_menu_sound_off_press;
	public static TextureRegion play_menu_quit_normal;
	public static TextureRegion play_menu_quit_press;
	
	public static TextureRegion play_menu_defense_1;
	public static TextureRegion play_menu_defense_2;
	public static TextureRegion play_menu_defense_3;

	public static TextureRegion landmarkdefense;
	public static TextureRegion brick;
	public static TextureRegion ground;
	public static TextureRegion tree;
	
	
	
	public static TextureRegion all_attack_ground_1;
	public static TextureRegion all_attack_ground_2;
	public static TextureRegion all_attack_air;
	
	public static void init(){
		TextureAtlas atlas = GameControl.getAtlas();
		star_bg = atlas.findRegion("startscreen/start_bg");
		new_game_normal = atlas.findRegion("startscreen/new_game_normal");
		new_game_press = GameControl.getAtlas().findRegion("startscreen/new_game_press");
		help_normal = GameControl.getAtlas().findRegion("startscreen/help_normal");
		help_press = GameControl.getAtlas().findRegion("startscreen/help_press");
		high_score_normal = GameControl.getAtlas().findRegion("startscreen/high_score_normal");
		high_score_press = GameControl.getAtlas().findRegion("startscreen/high_score_press");
		
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
		
		play_menu_pause_normal = GameControl.getAtlas().findRegion("playscreen/menu/pause_normal");
		play_menu_pause_press = GameControl.getAtlas().findRegion("playscreen/menu/pause_press");
		play_menu_quit_normal = GameControl.getAtlas().findRegion("playscreen/menu/quit_normal");
		play_menu_quit_press = GameControl.getAtlas().findRegion("playscreen/menu/quit_press");
		play_menu_sound_on_normal = GameControl.getAtlas().findRegion("playscreen/menu/sound_on_normal");
		play_menu_sound_on_press = GameControl.getAtlas().findRegion("playscreen/menu/sound_on_press");
		play_menu_sound_off_normal = GameControl.getAtlas().findRegion("playscreen/menu/sound_off_normal");
		play_menu_sound_off_press = GameControl.getAtlas().findRegion("playscreen/menu/sound_off_press");
		
		play_menu_defense_1 = GameControl.getAtlas().findRegion("playscreen/menu/weapon_info_1_normal");
		play_menu_defense_2 = GameControl.getAtlas().findRegion("playscreen/menu/weapon_info_2_normal");
		play_menu_defense_3 = GameControl.getAtlas().findRegion("playscreen/menu/weapon_info_3_normal");
//		
		brick = GameControl.getAtlas().findRegion("playscreen/brick");
		ground = GameControl.getAtlas().findRegion("playscreen/ground");
		tree = GameControl.getAtlas().findRegion("playscreen/tree");
		
		all_attack_ground_1 = GameControl.getAtlas().findRegion("playscreen/attack/attack1");
		all_attack_ground_2 = GameControl.getAtlas().findRegion("playscreen/attack/attack2");
		all_attack_air = GameControl.getAtlas().findRegion("playscreen/attack/attack3");
	}
}
