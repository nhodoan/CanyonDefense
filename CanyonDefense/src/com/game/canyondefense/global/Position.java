package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;

public class Position {
	public static float width = Gdx.graphics.getWidth();
	public static float height = Gdx.graphics.getHeight();

	/**
	 * Positon of Start Screen
	 */
	public static float START_PLAY_X = width * 220 / 640;
	public static float START_PLAY_Y = height * 240 / 360;
	public static float START_HELP_X = width * 240 / 640;
	public static float START_HELP_Y = height * 160 / 360;
	public static float START_HIGH_SCORE_X = width * 240 / 640;
	public static float START_HIGH_SCORE_Y = height * 80 / 360;

	/**
	 * Position of Level Screen
	 */
	public static float MAP_1_X = width * 70 / 640;
	public static float MAP_1_Y = height * 200 / 360;
	public static float MAP_2_X = width * 270 / 640;
	public static float MAP_2_Y = height * 200 / 360;;
	public static float MAP_3_X = width * 470 / 640;
	public static float MAP_3_Y = height * 200 / 360;;

	/**
	 * Position of Difficult Screen
	 */
	public static float DIFF_EASY_X;
	public static float DIFF_EASY_Y;
	public static float DIFF_NORMAL_X;
	public static float DIFF_NORMAL_Y;
	public static float DIFF_HARD_X;
	public static float DIFF_HARD_Y;
}
