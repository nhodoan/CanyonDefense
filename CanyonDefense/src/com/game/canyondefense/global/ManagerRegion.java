package com.game.canyondefense.global;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;

public class ManagerRegion {

    public static TextureRegion star_bg, play_game_normal, play_game_press,
	    help_normal, help_press, high_score_normal, high_score_press;

    public static TextureRegion map_1, map_1_press, map_2, map_2_press, map_3,
	    map_3_press;

    public static TextureRegion diff_easy_normal, diff_easy_press,
	    diff_medium_normal, diff_medium_press, diff_hard_normal,
	    diff_hard_press;

    public static TextureRegion map_bg, diff_bg,high_score_bg,high_score_table;

    public static TextureRegion back_menu_normal, back_menu_press,
	    replay_normal, replay_press, win_icon, lose_icon, bg_status,
	    pause_icon, continue_normal, continue_press;

    public static TextureRegion menu_bg;
    public static TextureRegion play_menu_pause_normal;
    public static TextureRegion play_menu_pause_press;
    public static TextureRegion sound_on_normal;
    public static TextureRegion sound_off_normal;
    public static TextureRegion sound_on_press;
    public static TextureRegion sound_off_press;
    public static TextureRegion play_menu_quit_normal;
    public static TextureRegion play_menu_quit_press;
    public static TextureRegion gold_frame, wave_frame, heart_frame;

    public static TextureRegion play_menu_defense_1_normal,
	    play_menu_defense_2_normal, play_menu_defense_3_normal,
	    play_menu_defense_4_normal, play_menu_defense_1_press,
	    play_menu_defense_2_press, play_menu_defense_3_press,
	    play_menu_defense_4_press, play_attack_new_wave_normal,
	    play_attack_new_wave_press;
    public static TextureRegion number1, number2, number3, number4, number5,
	    number6, number7, number8, number9, number0, gach_xien, plus;

    public static TextureRegion brick, ground, tree, fire_1_normal,
	    fire_2_normal, fire_1_press, fire_2_press;

    public static TextureRegion all_attack_ground_1;
    public static TextureRegion all_attack_ground_2;
    public static TextureRegion all_attack_air_1, all_attack_air_2;

    public static TextureRegion defense1_normal, defense2_normal,
	    defense3_normal, defense1_press, defense2_press, defense3_press,
	    defense4_normal, defense4_press, circle_select, sell_normal,
	    sell_press;

    public static TextureRegion bullet;

    public static TextureRegion frame_blood;
    public static TextureRegion blood;

    public static TextureRegion circle_attack;

    public static void init() {
	TextureAtlas atlas = GameControl.getAtlas();
	star_bg = atlas.findRegion("startscreen/start_bg");
	play_game_normal = atlas.findRegion("startscreen/play_game_normal");
	play_game_press = atlas.findRegion("startscreen/play_game_press");
	help_normal = atlas.findRegion("startscreen/help_normal");
	help_press = atlas.findRegion("startscreen/help_press");
	high_score_normal = atlas.findRegion("startscreen/high_score_normal");
	high_score_press = atlas.findRegion("startscreen/high_score_press");

	map_1 = atlas.findRegion("mapscreen/map1_normal");
	map_1_press = atlas.findRegion("mapscreen/map1_press");
	map_2 = atlas.findRegion("mapscreen/map2_normal");
	map_2_press = atlas.findRegion("mapscreen/map2_press");
	map_3 = atlas.findRegion("mapscreen/map3_normal");
	map_3_press = atlas.findRegion("mapscreen/map3_press");
	map_bg = atlas.findRegion("mapscreen/map_bg");

	diff_easy_normal = atlas.findRegion("diffscreen/diff_easy_normal");
	diff_easy_press = atlas.findRegion("diffscreen/diff_easy_press");
	diff_medium_normal = atlas.findRegion("diffscreen/diff_medium_normal");
	diff_medium_press = atlas.findRegion("diffscreen/diff_medium_press");
	diff_hard_normal = atlas.findRegion("diffscreen/diff_hard_normal");
	diff_hard_press = atlas.findRegion("diffscreen/diff_hard_press");
	diff_bg = atlas.findRegion("diffscreen/diff_bg");

	menu_bg = atlas.findRegion("playscreen/menu/bg_menu");
	high_score_table = atlas.findRegion("highscorescreen/table");
	high_score_bg = atlas.findRegion("highscorescreen/table");
	
	play_menu_pause_normal = atlas
		.findRegion("playscreen/menu/pause_normal");
	play_menu_pause_press = atlas.findRegion("playscreen/menu/pause_press");
	play_menu_quit_normal = atlas.findRegion("playscreen/menu/quit_normal");
	play_menu_quit_press = atlas.findRegion("playscreen/menu/quit_press");
	sound_on_normal = atlas.findRegion("playscreen/menu/sound_on_normal");
	sound_on_press = atlas.findRegion("playscreen/menu/sound_on_press");
	sound_off_normal = atlas.findRegion("playscreen/menu/sound_off_normal");
	sound_off_press = atlas.findRegion("playscreen/menu/sound_off_press");

	play_attack_new_wave_normal = atlas
		.findRegion("playscreen/menu/attack_play_normal");
	play_attack_new_wave_press = atlas
		.findRegion("playscreen/menu/attack_play_press");

	gold_frame = atlas.findRegion("playscreen/menu/gold_frame");
	number0 = atlas.findRegion("playscreen/menu/number/0");
	number1 = atlas.findRegion("playscreen/menu/number/1");
	number2 = atlas.findRegion("playscreen/menu/number/2");
	number3 = atlas.findRegion("playscreen/menu/number/3");
	number4 = atlas.findRegion("playscreen/menu/number/4");
	number5 = atlas.findRegion("playscreen/menu/number/5");
	number6 = atlas.findRegion("playscreen/menu/number/6");
	number7 = atlas.findRegion("playscreen/menu/number/7");
	number8 = atlas.findRegion("playscreen/menu/number/8");
	number9 = atlas.findRegion("playscreen/menu/number/9");
	gach_xien = atlas.findRegion("playscreen/menu/number/gach");
	plus = atlas.findRegion("playscreen/menu/number/plus");

	wave_frame = atlas.findRegion("playscreen/menu/wave_frame");

	heart_frame = atlas.findRegion("playscreen/menu/heart_frame");

	back_menu_normal = atlas
		.findRegion("playscreen/menu/statusgame/back_menu_normal");
	back_menu_press = atlas
		.findRegion("playscreen/menu/statusgame/back_menu_press");
	replay_normal = atlas
		.findRegion("playscreen/menu/statusgame/replay_normal");
	replay_press = atlas
		.findRegion("playscreen/menu/statusgame/replay_press");
	win_icon = atlas.findRegion("playscreen/menu/statusgame/win_icon");
	lose_icon = atlas.findRegion("playscreen/menu/statusgame/lose_icon");
	bg_status = atlas.findRegion("playscreen/menu/statusgame/bg");
	pause_icon = atlas.findRegion("playscreen/menu/statusgame/pause_icon");
	continue_normal = atlas
		.findRegion("playscreen/menu/statusgame/continue_game_normal");
	continue_press = atlas
		.findRegion("playscreen/menu/statusgame/continue_game_press");

	play_menu_defense_1_normal = atlas
		.findRegion("playscreen/popup/defense1_select_normal");
	play_menu_defense_2_normal = atlas
		.findRegion("playscreen/popup/defense2_select_normal");
	play_menu_defense_3_normal = atlas
		.findRegion("playscreen/popup/defense3_select_normal");
	play_menu_defense_4_normal = atlas
		.findRegion("playscreen/popup/defense4_select_normal");
	play_menu_defense_1_press = atlas
		.findRegion("playscreen/popup/defense1_select_press");
	play_menu_defense_2_press = atlas
		.findRegion("playscreen/popup/defense2_select_press");
	play_menu_defense_3_press = atlas
		.findRegion("playscreen/popup/defense3_select_press");
	play_menu_defense_4_press = atlas
		.findRegion("playscreen/popup/defense4_select_press");
	circle_select = atlas.findRegion("playscreen/popup/circle_defense");

	//
	brick = atlas.findRegion("playscreen/brick");
	ground = atlas.findRegion("playscreen/ground");
	tree = atlas.findRegion("playscreen/tree");

	all_attack_ground_1 = atlas
		.findRegion("playscreen/attack/tank_attack1");
	all_attack_ground_2 = atlas
		.findRegion("playscreen/attack/tank_attack2");
	all_attack_air_1 = atlas.findRegion("playscreen/attack/plane_attack1");
	all_attack_air_2 = atlas.findRegion("playscreen/attack/plane_attack2");

	frame_blood = atlas.findRegion("playscreen/attack/frame_blood");
	blood = atlas.findRegion("playscreen/attack/blood");

	defense1_normal = atlas
		.findRegion("playscreen/defense/defense1_normal");
	defense2_normal = atlas
		.findRegion("playscreen/defense/defense2_normal");
	defense3_normal = atlas
		.findRegion("playscreen/defense/defense3_normal");

	defense4_normal = atlas
		.findRegion("playscreen/defense/defense4_normal");

	defense1_press = atlas.findRegion("playscreen/defense/defense1_press");
	defense2_press = atlas.findRegion("playscreen/defense/defense2_press");
	defense3_press = atlas.findRegion("playscreen/defense/defense3_press");
	defense4_press = atlas.findRegion("playscreen/defense/defense4_press");
	circle_attack = atlas.findRegion("playscreen/defense/circle");
	sell_normal = atlas.findRegion("playscreen/defense/sell_normal");
	sell_press = atlas.findRegion("playscreen/defense/sell_press");

	bullet = atlas.findRegion("playscreen/bullet/shot1");
	fire_1_normal = atlas
		.findRegion("playscreen/bullet/fire_power1_normal");
	fire_1_press = atlas.findRegion("playscreen/bullet/fire_power1_press");
	fire_2_normal = atlas
		.findRegion("playscreen/bullet/fire_power2_normal");
	fire_2_press = atlas.findRegion("playscreen/bullet/fire_power2_press");
    }

}
