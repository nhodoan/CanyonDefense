package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;

public class Position {
    public static float width = Gdx.graphics.getWidth();
    public static float height = Gdx.graphics.getHeight();

    /**
     * Positon of Start Screen
     */
    public static float START_PLAY_X = width * 220 / 800;
    public static float START_PLAY_Y = height * 240 / 480;
    public static float START_HELP_X = width * 240 / 800;
    public static float START_HELP_Y = height * 160 / 480;
    public static float START_HIGH_SCORE_X = width * 240 / 800;
    public static float START_HIGH_SCORE_Y = height * 80 / 480;

    /**
     * Position of Level Screen
     */
    public static float MAP_1_X = width * 70 / 800;
    public static float MAP_1_Y = height * 200 / 480;
    public static float MAP_2_X = width * 270 / 800;
    public static float MAP_2_Y = height * 200 / 480;;
    public static float MAP_3_X = width * 470 / 800;
    public static float MAP_3_Y = height * 200 / 480;;

    /**
     * Position of Difficult Screen
     */
    public static float DIFF_EASY_X = width * 70 / 800;
    public static float DIFF_EASY_Y = height * 200 / 480;
    public static float DIFF_NORMAL_X = width * 270 / 800;
    public static float DIFF_NORMAL_Y = height * 200 / 480;
    public static float DIFF_HARD_X = width * 470 / 800;
    public static float DIFF_HARD_Y = height * 200 / 480;

    /**
     * Position of Play Screen
     */

    /* Position of Menu in Play Screen */

    public static float MENU_X = 480 * width / 800;
    public static float MENU_Y = 0;
    
    public static float PLAY_MENU_PLAY_X = 490 * width / 800;
    public static float PLAY_MENU_PLAY_Y = 400 * height / 480;
    public static float PLAY_MENU_SOUND_X = 590 * width / 800;
    public static float PLAY_MENU_SOUND_Y = 400 * height / 480;
    public static float PLAY_MENU_QUIT_X = 690 * width / 800;
    public static float PLAY_MENU_QUIT_Y = 400 * height / 480;
    
    public static float PLAY_MENU_DEFENSE_1_X = 490 * width / 800;
    public static float PLAY_MENU_DEFENSE_1_Y = 250 * height / 480;
    public static float PLAY_MENU_DEFENSE_2_X = 590 * width / 800;
    public static float PLAY_MENU_DEFENSE_2_Y = 250 * height / 480;
    public static float PLAY_MENU_DEFENSE_3_X = 690 * width / 800;
    public static float PLAY_MENU_DEFENSE_3_Y = 250 * height / 480;
    /* Position of Main Play in Play Screen */
}
