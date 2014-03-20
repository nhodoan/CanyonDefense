package com.game.canyondefense.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.object.AreaObject;
import com.game.canyondefense.object.AttackAirObject;
import com.game.canyondefense.object.AttackGroundObject;

public class PlayScreen extends BaseScreen implements InputProcessor {
	private final String TAG = "Play Screen";
	AtlasRegion bg;
	long timeStart = 0l;

	public static int map;
	public static int level;

	private AreaObject pause_button, sound_button;
	private AttackGroundObject hihiAttackGroundObject;
	private AttackAirObject heheAirObject;

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		Gdx.input.setCatchBackKey(true);
		Gdx.input.setInputProcessor(this);
		bg = GameControl.getAtlas().findRegion("data/loading");
		timeStart = System.currentTimeMillis();
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
		sb.end();
		stage.draw();
		update(arg0);
	}

	private void update(float time) {
		if (System.currentTimeMillis() - timeStart > 3000) {
			Gdx.app.log(TAG, "Exit Game");
			Gdx.app.exit();
		}

	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return super.touchDown(screenX, screenY, pointer, button);
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return super.touchUp(screenX, screenY, pointer, button);
	}

}
