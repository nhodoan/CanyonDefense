package com.game.canyondefense.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.object.AreaObject;

public class MapSelectScreen extends BaseScreen implements InputProcessor {
	@SuppressWarnings("unused")
	private final String TAG = "Level Select Screen";
	long timeStart = 0l;
	private AreaObject map_1, map_2, map_3;

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		Gdx.input.setCatchBackKey(true);
		/*Using for InputProcessor*/
		Gdx.input.setInputProcessor(this);
		timeStart = System.currentTimeMillis();
		map_1 = new AreaObject(IDObject.MAP_1);
		map_2 = new AreaObject(IDObject.MAP_2);
		map_3 = new AreaObject(IDObject.MAP_3);
		
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
		/* Draw Texure region here */
		sb.draw(map_1.getTexture(), map_1.getX(), map_1.getY(), map_1.getWidth(), map_1.getHeight());
		sb.draw(map_2.getTexture(), map_2.getX(), map_2.getY(), map_2.getWidth(), map_2.getHeight());
		sb.draw(map_3.getTexture(), map_3.getX(), map_3.getY(), map_3.getWidth(), map_3.getHeight());
		sb.end();
		stage.draw();
		update(arg0);
	}

	private void update(float time) {
		if (System.currentTimeMillis() - timeStart > 3000) {
//			Gdx.app.log(TAG, "Switch to Difficult Select Screen");
//			GameControl.getManagerScreen().creatScreen(
//					ManagerScreen.SCREEN_DIFF);
		}
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		// super.touchDown(screenX, screenY, pointer, button);
		if (map_1.isInBound(screenX, height - screenY)) {
			map_1.setCanPress(false);
		} else if (map_2.isInBound(screenX, height - screenY)) {
			map_2.setCanPress(false);
		} else if (map_3.isInBound(screenX, height - screenY)) {
			map_3.setCanPress(false);
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		// super.touchUp(screenX, screenY, pointer, button);

		if (map_1.isInBound(screenX, height - screenY)
				&& !map_1.canPress()) {
			GameControl.getManagerScreen().creatScreen(ManagerScreen.SCREEN_DIFF);
			super.touchUp(screenX, screenY, pointer, button);			
		} else if (map_2.isInBound(screenX, height - screenY)
				&& !map_2.canPress()) {
			super.touchUp(screenX, screenY, pointer, button);
		} else if (map_3.isInBound(screenX, height - screenY)
				&& !map_3.canPress()) {
			super.touchUp(screenX, screenY, pointer, button);
		}

		if (!map_1.canPress()) {
			map_1.setCanPress(true);
		}else if (!map_2.canPress()) {
			map_2.setCanPress(true);
		}else if (!map_3.canPress()) {
			map_3.setCanPress(true);
		}

		return false;
	}

}
