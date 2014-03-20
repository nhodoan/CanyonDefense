package com.game.canyondefense.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.ManagerRegion;

/**
 * @author Mats Svensson
 */
public class LoadingScreen implements Screen {

	private Stage stage;
	private SpriteBatch sb;
	private TextureRegion loadingFrame, loadingBar, screenBg;
	private float percent;
	private long timeOffset;
	private float width, height;
	private AssetManager manager;

	public LoadingScreen() {

		manager = new AssetManager();
	}

	@Override
	public void show() {
		// Tell the manager to load assets for the loading screen
		manager.load("MyDataPacker/MoTa.pack", TextureAtlas.class);
		stage = new Stage();
		sb = stage.getSpriteBatch();

		TextureAtlas atlas = new TextureAtlas(
				Gdx.files.internal("LoadingPacker/Loading.pack"));

		loadingFrame = atlas.findRegion("loadingframe");
		loadingBar = atlas.findRegion("loadingbar");
		screenBg = atlas.findRegion("loading");
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		Gdx.app.log("tag", "Loading...");
		
	}

	@Override
	public void resize(int width, int height) {
		// Set our screen to always be XXX x 480 in size

	}

	@Override
	public void render(float delta) {
		// Clear the screen
		if (manager.update()) {

		}
		// Gdx.app.log("tag", "Drawing");

		percent = Interpolation.linear.apply(percent, manager.getProgress(),
				0.1f);
		timeOffset += delta * 1000;
		if (timeOffset > 7000) {
			timeOffset = 7000;
		}

		sb.begin();
		sb.draw(screenBg, 0, 0, width, height);

		// sb.draw(loadingBar, 100 * width / 720, 300 * height / 1280, (percent
		// * maxLength + timeOffset / 5)
		// * width / 720, 100 * height / 1280);
		sb.draw(loadingBar, 150 * width / 720, 300 * height / 1280, percent
				* 200 * width / 720 + timeOffset * 200 * width / 720 / 7000,
				100 * height / 1280);

		sb.draw(loadingFrame, 100 * width / 720, 300 * height / 1280,
				500 * width / 720, 100 * height / 1280);
		sb.end();
		if (percent * 1000 > 999.99 && timeOffset == 7000) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
				GameControl.atlas = manager.get("MyDataPacker/MoTa.pack",
						TextureAtlas.class);
				ManagerRegion.init();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					GameControl.getManagerScreen().creatScreen(
							ManagerScreen.SCREEN_START);
				}
				
//			}
		}
		Gdx.app.log("percent", String.valueOf(percent * 100) + " %");

	}

	@Override
	public void hide() {
		// Dispose the loading assets as we no longer need them

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
