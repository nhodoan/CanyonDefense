package com.game.canyondefense.global;

import com.badlogic.gdx.Gdx;

public class Dimension {

	private static float width = Gdx.graphics.getWidth();
	private static float height = Gdx.graphics.getHeight();

	/**
	 * Dimension of Start Screen
	 */
	public static float START_PLAY_W = width * 150 / 640;
	public static float START_PLAY_H = height * 60 / 360;
	public static float START_HELP_W = width * 120 / 640;
	public static float START_HELP_H = height * 50 / 360;
	public static float START_HIGH_SCORE_W = width * 120 / 640;
	public static float START_HIGH_SCORE_H = height * 50 / 360;

	/**
	 * Dimension of Level Screen
	 */

	public static float MAP_1_W = width * 100 / 640;
	public static float MAP_1_H = width * 100 / 640;
	public static float MAP_2_W = width * 100 / 640;
	public static float MAP_2_H = width * 100 / 640;
	public static float MAP_3_W = width * 100 / 640;
	public static float MAP_3_H = width * 100 / 640;

	/**
	 * Dimension of Difficult Select Screen
	 */

	public static float DIFF_EASY_W;
	public static float DIFF_EASY_H;
	public static float DIFF_NORMAL_W;
	public static float DIFF_NORMAL_H;
	public static float DIFF_HARD_W;
	public static float DIFF_HARD_H;

}
