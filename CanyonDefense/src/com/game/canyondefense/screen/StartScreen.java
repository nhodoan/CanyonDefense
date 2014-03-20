package com.game.canyondefense.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.object.AreaObject;

public class StartScreen extends BaseScreen implements InputProcessor {
	AtlasRegion bg;
	long timeStart = 0l;
	private final String TAG = "Start Screen";

	private AreaObject start_play, start_help, start_high_score;

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		Gdx.input.setCatchBackKey(true);
		/*Using for InputProcessor*/
		Gdx.input.setInputProcessor(this);
		Gdx.app.log(TAG, "Start showing start screen");
		bg = GameControl.getAtlas().findRegion("data/loading");

		start_play = new AreaObject(IDObject.START_PLAY);
		start_help = new AreaObject(IDObject.START_HELP);
		start_high_score = new AreaObject(IDObject.START_HIGH_SCORE);

	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		super.render(arg0);
		Gdx.gl.glClearColor(0.5f, 0.6f, 0.5f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		stage.act(arg0);
		sb.begin();

		/* Draw Texture Region here */
		sb.draw(start_play.getTexture(), start_play.getX(), start_play.getY(),
				start_play.getWidth(), start_play.getHeight());
		sb.draw(start_help.getTexture(), start_help.getX(), start_help.getY(),
				start_help.getWidth(), start_help.getHeight());
		sb.draw(start_high_score.getTexture(), start_high_score.getX(),
				start_high_score.getY(), start_high_score.getWidth(),
				start_high_score.getHeight());
		/* End Draw */
		sb.end();
		stage.draw();
		update(arg0);
	}

	/**
	 * Update Status Of Object
	 * @param time
	 */
	private void update(float time) {
		if (System.currentTimeMillis() - timeStart > 3000) {
			// Gdx.app.log(TAG, "Switch to Level Select Screen");
			// GameControl.getManagerScreen().creatScreen(
			// ManagerScreen.SCREEN_LEVEL);
		}
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		// super.touchDown(screenX, screenY, pointer, button);
		if (start_play.isInBound(screenX, height - screenY)) {
			start_play.setCanPress(false);
		} else if (start_help.isInBound(screenX, height - screenY)) {
			start_help.setCanPress(false);
		} else if (start_high_score.isInBound(screenX, height - screenY)) {
			start_high_score.setCanPress(false);
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		// super.touchUp(screenX, screenY, pointer, button);

		if (start_play.isInBound(screenX, height - screenY)
				&& !start_play.canPress()) {
			GameControl.getManagerScreen().creatScreen(ManagerScreen.SCREEN_MAP);
			super.touchUp(screenX, screenY, pointer, button);			
		} else if (start_help.isInBound(screenX, height - screenY)
				&& !start_help.canPress()) {
			super.touchUp(screenX, screenY, pointer, button);
		} else if (start_high_score.isInBound(screenX, height - screenY)
				&& !start_high_score.canPress()) {
			super.touchUp(screenX, screenY, pointer, button);
		}

		if (!start_play.canPress()) {
			start_play.setCanPress(true);
		}else if (!start_help.canPress()) {
			start_help.setCanPress(true);
		}else if (!start_high_score.canPress()) {
			start_high_score.setCanPress(true);
		}

		return false;
	}

}
