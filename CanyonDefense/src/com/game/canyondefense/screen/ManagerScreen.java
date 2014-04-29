package com.game.canyondefense.screen;

import com.badlogic.gdx.Screen;

public class ManagerScreen {
	
	/*Manage id screen*/
	public static int SCREEN_LOAD = 0;
	public static int SCREEN_START = 1;
	public static int SCREEN_MAP = 2;	
	public static int SCREEN_DIFF = 3;
	public static int SCREEN_PLAY = 4;
	public static int SCREEN_HIGH = 5;
	public static int SCREEN_HELP = 6;

	private int idMomentScreen;

	private Screen momentScreen;

	public ManagerScreen() {

	}

	/**
	 * Get Moment Screen is showing
	 * @return 
	 */
	public Screen getMomentScreen() {
		if (momentScreen == null) {
			momentScreen.show();
		}
		return momentScreen;
	}

	/**
	 * Get id of moment Screen
	 * @return
	 */
	public int getIdMomentScreen() {
		return this.idMomentScreen;
	}

	/**
	 * Creat new screen and set to moment Screen
	 * @param select
	 * @return
	 */
	public Screen creatScreen(int select) {
		switch (select) {

		case 0:
			clearScreen();
			idMomentScreen = -1;
			momentScreen = new LoadingScreen();
			momentScreen.show();
			return momentScreen;
		case 1:
			clearScreen();
			idMomentScreen = -1;
			momentScreen = new StartScreen();
			momentScreen.show();
			return momentScreen;
		case 2:
			clearScreen();
			idMomentScreen = -1;
			momentScreen = new MapSelectScreen();
			momentScreen.show();
			return momentScreen;
		case 3:
			clearScreen();
			idMomentScreen = -1;
			momentScreen = new DifficultSelectScreen();
			momentScreen.show();
			return momentScreen;
		case 4:
			clearScreen();
			idMomentScreen = -1;
			momentScreen = new PlayScreen();
			momentScreen.show();
			return momentScreen;
		case 5:
			clearScreen();
			idMomentScreen = -1;
			momentScreen = new HighScoreScreen();
			momentScreen.show();
			return momentScreen;
		case 6:
			clearScreen();
			idMomentScreen = -1;
			momentScreen = new HelpScreen();
			momentScreen.show();
			return momentScreen;
		}

		return momentScreen;
	}

	/**
	 * Clear moment screen
	 */
	public void clearScreen() {
		if (momentScreen != null) {
			momentScreen.dispose();
		}
	}

}
