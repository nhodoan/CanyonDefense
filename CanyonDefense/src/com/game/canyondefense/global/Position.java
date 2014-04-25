package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;
import com.game.canyondefense.GameControl;

public class Position {

    private static float W = GameControl.WIDTH_DEBUG;
    private static float H = GameControl.HEIGHT_DEBUG;
    public static float width = Gdx.graphics.getWidth();
    public static float height = Gdx.graphics.getHeight();

    /**
     * Positon of Start Screen
     */
    public static float START_PLAY_X = width * 240 / W;
    public static float START_PLAY_Y = height * 240 / H;
    public static float START_HELP_X = width * 260 / W;
    public static float START_HELP_Y = height * 160 / H;
    public static float START_HIGH_SCORE_X = width * 260 / W;
    public static float START_HIGH_SCORE_Y = height * 80 / H;

    /**
     * Position of Level Screen
     */
    public static float MAP_1_X = width * 70 / W;
    public static float MAP_1_Y = height * 200 / H;
    public static float MAP_2_X = width * 270 / W;
    public static float MAP_2_Y = height * 200 / H;;
    public static float MAP_3_X = width * 470 / W;
    public static float MAP_3_Y = height * 200 / H;;

    /**
     * Position of Difficult Screen
     */
    public static float DIFF_EASY_X = width * 70 / W;
    public static float DIFF_EASY_Y = height * 200 / H;
    public static float DIFF_NORMAL_X = width * 270 / W;
    public static float DIFF_NORMAL_Y = height * 200 / H;
    public static float DIFF_HARD_X = width * 470 / W;
    public static float DIFF_HARD_Y = height * 200 / H;

    /**
     * Position of Play Screen
     */

    /* Position of Menu in Play Screen */

    public static float MENU_X = H * width / W;
    public static float MENU_Y = 0;

    public static float PLAY_MENU_PLAY_X = 490 * width / W;
    public static float PLAY_MENU_PLAY_Y = 420 * height / H;
    public static float PLAY_MENU_SOUND_X = 540 * width / W;
    public static float PLAY_MENU_SOUND_Y = 420 * height / H;
    public static float PLAY_MENU_QUIT_X = 590 * width / W;
    public static float PLAY_MENU_QUIT_Y = 420 * height / H;

    public static float PLAY_MENU_DEFENSE_1_X = 482 * width / W;
    public static float PLAY_MENU_DEFENSE_1_Y = 300 * height / H;
    public static float PLAY_MENU_DEFENSE_2_X = 534 * width / W;
    public static float PLAY_MENU_DEFENSE_2_Y = 300 * height / H;
    public static float PLAY_MENU_DEFENSE_3_X = 586 * width / W;
    public static float PLAY_MENU_DEFENSE_3_Y = 300 * height / H;

    /* Position of Main Play in Play Screen */

    public static float genX(int x) {
	return Dimension.BRICK_W * x;
    }

    public static float genY(int y) {
	return Dimension.BRICK_H * (MapData.rows -1 - y);
    }
}
