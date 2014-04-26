package com.game.canyondefense.global;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;

public class ManagerRegion {

    public static TextureRegion star_bg, new_game_normal, new_game_press,
	    help_normal, help_press, high_score_normal, high_score_press;

    public static TextureRegion map_1, map_1_press, map_2, map_2_press, map_3,
	    map_3_press;

    public static TextureRegion diff_easy_normal, diff_easy_press,
	    diff_medium_normal, diff_medium_press, diff_hard_normal,
	    diff_hard_press;

    public static TextureRegion menu_bg;
    public static TextureRegion play_menu_pause_normal;
    public static TextureRegion play_menu_pause_press;
    public static TextureRegion play_menu_sound_on_normal;
    public static TextureRegion play_menu_sound_off_normal;
    public static TextureRegion play_menu_sound_on_press;
    public static TextureRegion play_menu_sound_off_press;
    public static TextureRegion play_menu_quit_normal;
    public static TextureRegion play_menu_quit_press;
    public static TextureRegion gold_frame, all_number, wave_frame,
	    heart_frame;

    public static TextureRegion play_menu_defense_1_normal;
    public static TextureRegion play_menu_defense_2_normal;
    public static TextureRegion play_menu_defense_3_normal;
    public static TextureRegion play_menu_defense_1_press;
    public static TextureRegion play_menu_defense_2_press;
    public static TextureRegion play_menu_defense_3_press;

    public static TextureRegion brick;
    public static TextureRegion ground;
    public static TextureRegion tree;

    public static TextureRegion all_attack_ground_1;
    public static TextureRegion all_attack_ground_2;
    public static TextureRegion all_attack_air;

    public static TextureRegion defense1_normal, defense2_normal,
	    defense3_normal, defense1_press, defense2_press, defense3_press,circle_select;

    public static TextureRegion bullet;

    public static TextureRegion frame_blood;
    public static TextureRegion blood;

    public static TextureRegion circle_attack;

    public static void init() {
	TextureAtlas atlas = GameControl.getAtlas();
	star_bg = atlas.findRegion("startscreen/start_bg");
	new_game_normal = atlas.findRegion("startscreen/new_game_normal");
	new_game_press = atlas.findRegion("startscreen/new_game_press");
	help_normal = atlas.findRegion("startscreen/help_normal");
	help_press = atlas.findRegion("startscreen/help_press");
	high_score_normal = atlas.findRegion("startscreen/high_score_normal");
	high_score_press = atlas.findRegion("startscreen/high_score_press");

	map_1 = atlas.findRegion("mapscreen/map_1_normal");
	map_1_press = atlas.findRegion("mapscreen/map_1_hover");
	map_2 = atlas.findRegion("mapscreen/map_2_normal");
	map_2_press = atlas.findRegion("mapscreen/map_2_hover");
	map_3 = atlas.findRegion("mapscreen/map_3_normal");
	map_3_press = atlas.findRegion("mapscreen/map_3_hover");

	diff_easy_normal = atlas.findRegion("diffscreen/diff_easy_normal");
	diff_easy_press = atlas.findRegion("diffscreen/diff_easy_press");
	diff_medium_normal = atlas.findRegion("diffscreen/diff_medium_normal");
	diff_medium_press = atlas.findRegion("diffscreen/diff_medium_press");
	diff_hard_normal = atlas.findRegion("diffscreen/diff_hard_normal");
	diff_hard_press = atlas.findRegion("diffscreen/diff_hard_press");

	menu_bg = atlas.findRegion("playscreen/menu/bg_menu");

	play_menu_pause_normal = atlas
		.findRegion("playscreen/menu/pause_normal");
	play_menu_pause_press = atlas.findRegion("playscreen/menu/pause_press");
	play_menu_quit_normal = atlas.findRegion("playscreen/menu/quit_normal");
	play_menu_quit_press = atlas.findRegion("playscreen/menu/quit_press");
	play_menu_sound_on_normal = atlas
		.findRegion("playscreen/menu/sound_on_normal");
	play_menu_sound_on_press = atlas
		.findRegion("playscreen/menu/sound_on_press");
	play_menu_sound_off_normal = atlas
		.findRegion("playscreen/menu/sound_off_normal");
	play_menu_sound_off_press = atlas
		.findRegion("playscreen/menu/sound_off_press");
	gold_frame = atlas.findRegion("playscreen/menu/gold_frame");
	all_number = atlas.findRegion("playscreen/menu/number");
	wave_frame = atlas.findRegion("playscreen/menu/wave_frame");

	heart_frame = atlas.findRegion("playscreen/menu/heart_frame");

	play_menu_defense_1_normal = atlas
		.findRegion("playscreen/popup/defense1_select_normal");
	play_menu_defense_2_normal = atlas
		.findRegion("playscreen/popup/defense2_select_normal");
	play_menu_defense_3_normal = atlas
		.findRegion("playscreen/popup/defense3_select_normal");
	play_menu_defense_1_press = atlas
		.findRegion("playscreen/popup/defense1_select_press");
	play_menu_defense_2_press = atlas
		.findRegion("playscreen/popup/defense2_select_press");
	play_menu_defense_3_press = atlas
		.findRegion("playscreen/popup/defense3_select_press");
	circle_select = atlas.findRegion("playscreen/popup/circle_defense");
	
	//
	brick = atlas.findRegion("playscreen/brick");
	ground = atlas.findRegion("playscreen/ground");
	tree = atlas.findRegion("playscreen/tree");

	all_attack_ground_1 = atlas.findRegion("playscreen/attack/attack1");
	all_attack_ground_2 = atlas.findRegion("playscreen/attack/attack2");
	all_attack_air = atlas.findRegion("playscreen/attack/attack3");

	frame_blood = atlas.findRegion("playscreen/attack/frame_blood");
	blood = atlas.findRegion("playscreen/attack/blood");

	defense1_normal = atlas
		.findRegion("playscreen/defense/defense1_normal");
	defense2_normal = atlas
		.findRegion("playscreen/defense/defense2_normal");
	defense3_normal = atlas
		.findRegion("playscreen/defense/defense3_normal");

	defense1_press = atlas.findRegion("playscreen/defense/defense1_press");
	defense2_press = atlas.findRegion("playscreen/defense/defense2_press");
	defense3_press = atlas.findRegion("playscreen/defense/defense3_press");
	circle_attack = atlas.findRegion("playscreen/defense/circle");

	bullet = atlas.findRegion("playscreen/bullet/shot1");
    }

}
