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
    public static float START_PLAY_X = width / 2 - Dimension.START_PLAY_W / 2;
    public static float START_PLAY_Y = height * 240 / H;
    public static float START_HELP_X = width / 2 - Dimension.START_HELP_W / 2;
    public static float START_HELP_Y = height * 160 / H;
    public static float START_HIGH_SCORE_X = width / 2
	    - Dimension.START_HIGH_SCORE_W / 2;
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

    public static float PLAY_MENU_PLAY_X = 5 * width / W;
    public static float PLAY_MENU_PLAY_Y = 435 * height / H;

    public static float MENU_GOLD_FRAME_X = 535 * width / W;
    public static float MENU_GOLD_FRAME_Y = 440 * height / H;

    public static float MENU_GOLD_TEXT_X_START = 565 * width / W;
    public static float MENU_TEXT_Y = 448 * height / H;

    public static float MENU_WAVE_FRAME_X = 420 * width / W;
    public static float MENU_WAVE_FRAME_Y = 440 * height / H;
    public static float MENU_WAVE_TEXT_X_START = 455 * width / W;

    public static float MENU_HEART_FRAME_X = 10 * width / W;
    public static float MENU_HEART_FRAME_Y = 10 * height / H;
    public static float MENU_TEXT_HEART_Y = 20 * height / H;
    public static float MENU_HEART_TEXT_X_START = 50 * width / W;

    public static float PLAY_MENU_FIRE_1_X = 510 * width / W;
    public static float PLAY_MENU_FIRE_2_X = 570 * width / W;
    public static float PLAY_MENU_FIRE_Y = 10 * height / H;

    public static float PLAY_MENU_SOUND_X = 600 * width / W;
    public static float PLAY_MENU_SOUND_Y = 420 * height / H;
    public static float PLAY_MENU_QUIT_X = 590 * width / W;
    public static float PLAY_MENU_QUIT_Y = 420 * height / H;

    public static float PLAY_MENU_DEFENSE_1_X = 482 * width / W;
    public static float PLAY_MENU_DEFENSE_1_Y = 300 * height / H;
    public static float PLAY_MENU_DEFENSE_2_X = 534 * width / W;
    public static float PLAY_MENU_DEFENSE_2_Y = 300 * height / H;
    public static float PLAY_MENU_DEFENSE_3_X = 586 * width / W;
    public static float PLAY_MENU_DEFENSE_3_Y = 300 * height / H;

    public static float PLAY_ATTACK_X = 20 * width / W;
    public static float PLAY_ATTACK_Y = 310 * height / H;

    public static float ICON_STATUS_GAME_X = width / 2
	    - Dimension.ICON_STATUS_GAME_W / 2;
    public static float ICON_STATUS_GAME_Y = 330 * height / H;

    public static float REPLAY_GAME_X = width / 2 - Dimension.REPLAY_GAME_W / 2;
    public static float REPLAY_GAME_Y = 200 * height / H;

    public static float CONT_GAME_X = width / 2 - Dimension.CONT_GAME_W / 2;
    public static float CONT_GAME_Y = 270 * height / H;

    public static float BACK_MENU_X = width / 2 - Dimension.BACK_MENU_W / 2;
    public static float BACK_MENU_Y = 110 * height / H;

    public static float GUI_NEXT_X = 600 * width / W;
    public static float GUI_NEXT_Y = 200 * height / H;
    public static float GUI_PREV_X = 10 * width / W;

    /* Position of Main Play in Play Screen */

    public static int genI(float x) {
	return (int) (x / Dimension.BRICK_W);
    }

    public static int genJ(float y) {
	return MapData.rows - 1 - (int) (y / Dimension.BRICK_H);
    }

    public static float genXFromFloat(float x) {
	return Dimension.BRICK_W * ((int) (x / Dimension.BRICK_W));
    }

    public static float genYFromFloat(float y) {
	return Dimension.BRICK_H * ((int) (y / Dimension.BRICK_H));
    }
}
