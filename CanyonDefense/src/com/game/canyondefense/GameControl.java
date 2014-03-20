package com.game.canyondefense;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.game.canyondefense.screen.ManagerScreen;

public class GameControl extends Game {
	public static TextureAtlas atlas;
	private static MySkin mySkin;
	private static ManagerScreen managerScreen;
	private static BitmapFont font;
	public GameControl() {
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		// AssetManager manager = new AssetManager();
//		 manager.load("data/loading.pack", TextureAtlas.class);
//		atlas = new TextureAtlas(Gdx.files.internal("MyDataPacker/MoTa.pack"));
//		 TextureAtlas myAtlas = manager.get("data/loading.pack");

		mySkin = new MySkin();
		managerScreen = new ManagerScreen();
//		dataPreference = new DataPreference();
		font = new BitmapFont(Gdx.files.internal("MyData/font/font.fnt"),
				Gdx.files.internal("MyData/font/font.png"), false);

		// this.setScreen(managerScreen.creatScreen(ManagerScreen.SCREEN_START));
		this.setScreen(managerScreen.creatScreen(ManagerScreen.SCREEN_LOAD));
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		if (managerScreen.getMomentScreen() != null)
			managerScreen.getMomentScreen().render(Gdx.graphics.getDeltaTime());
	}
	@Override
	public void setScreen(Screen screen) {
		// TODO Auto-generated method stub
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		// TODO Auto-generated method stub
		return super.getScreen();
	}

	public static TextureAtlas getAtlas() {
		return atlas;
	}

	public static BitmapFont getBitmapFont() {
		return font;
	}

	public static MySkin getSkin() {
		return mySkin;
	}

	public static ManagerScreen getManagerScreen() {
		return managerScreen;
	}
}