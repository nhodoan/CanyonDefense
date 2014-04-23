package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;

public class Dimension {

    private static float width = Gdx.graphics.getWidth();
    private static float height = Gdx.graphics.getHeight();

    /**
     * Dimension of Start Screen
     */
    public static float START_PLAY_W = width * 150 / 800;
    public static float START_PLAY_H = height * 60 / 480;
    public static float START_HELP_W = width * 120 / 800;
    public static float START_HELP_H = height * 50 / 480;
    public static float START_HIGH_SCORE_W = width * 120 / 800;
    public static float START_HIGH_SCORE_H = height * 50 / 360;

    /**
     * Dimension of Level Screen
     */

    public static float MAP_1_W = width * 100 / 800;
    public static float MAP_1_H = width * 100 / 800;
    public static float MAP_2_W = width * 100 / 800;
    public static float MAP_2_H = width * 100 / 800;
    public static float MAP_3_W = width * 100 / 800;
    public static float MAP_3_H = width * 100 / 800;

    /**
     * Dimension of Difficult Select Screen
     */

    public static float DIFF_EASY_W = width * 100 / 800;
    public static float DIFF_EASY_H = width * 100 / 800;
    public static float DIFF_NORMAL_W = width * 100 / 800;
    public static float DIFF_NORMAL_H = width * 100 / 800;
    public static float DIFF_HARD_W = width * 100 / 800;
    public static float DIFF_HARD_H = width * 100 / 800;

    /**
     * Position of Play Screen
     */

    /* Position of Menu in Play Screen */

    public static float BRICK_W = 40 * width / 800;
    public static float BRICK_H = 40 * height / 480;
    
    public static float MENU_W = width * 320 / 800;
    public static float MENU_H = height;

    public static float PLAY_MENU_PLAY_W = width * 60 / 800;
    public static float PLAY_MENU_PLAY_H = height * 60 / 480;
    public static float PLAY_MENU_SOUND_W = width * 60 / 800;
    public static float PLAY_MENU_SOUND_H = height * 60 / 480;
    public static float PLAY_MENU_QUIT_W = width * 60 / 800;
    public static float PLAY_MENU_QUIT_H = height * 60 / 480;

    public static float PLAY_MENU_DEFENSE_1_W = width * 60 / 800;
    public static float PLAY_MENU_DEFENSE_1_H = height * 100 / 480;
    public static float PLAY_MENU_DEFENSE_2_W = width * 60 / 800;
    public static float PLAY_MENU_DEFENSE_2_H = height * 100 / 480;
    public static float PLAY_MENU_DEFENSE_3_W = width * 60 / 800;
    public static float PLAY_MENU_DEFENSE_3_H = height * 100 / 480;

    /* Position of Main Play in Play Screen */

}
