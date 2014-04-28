package com.game.canyondefense.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.object.AreaObject;

public class DifficultSelectScreen extends BaseScreen implements InputProcessor {

    @SuppressWarnings("unused")
    private final String TAG = "Difficule Select Screen";
    AtlasRegion bg;
    long timeStart = 0l;
    private AreaObject diff_easy, diff_normal, diff_hard;

    @Override
    public void show() {
	// TODO Auto-generated method stub
	super.show();
	Gdx.input.setCatchBackKey(true);
	Gdx.input.setInputProcessor(this);
	bg = GameControl.getAtlas().findRegion("data/loading");
	timeStart = System.currentTimeMillis();

	diff_easy = new AreaObject(IDObject.DIFF_EASY);
	diff_normal = new AreaObject(IDObject.DIFF_NORMAL);
	diff_hard = new AreaObject(IDObject.DIFF_HARD);
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
	/* Draw all texure here */
	sb.draw(diff_easy.getTexture(), diff_easy.getX(), diff_easy.getY(),
		diff_easy.getWidth(), diff_easy.getHeight());
	sb.draw(diff_normal.getTexture(), diff_normal.getX(),
		diff_normal.getY(), diff_normal.getWidth(),
		diff_normal.getHeight());
	sb.draw(diff_hard.getTexture(), diff_hard.getX(), diff_hard.getY(),
		diff_hard.getWidth(), diff_hard.getHeight());

	/* End Draw Texture */

	sb.end();
	stage.draw();
	update(arg0);
    }

    private void update(float time) {
	// if(System.currentTimeMillis() - timeStart > 3000){
	// Gdx.app.log(TAG, "Switch to Play Screen");
	// GameControl.getManagerScreen().creatScreen(ManagerScreen.SCREEN_PLAY);
	// }
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub

	if (diff_easy.isInBound(screenX, height - screenY)) {
	    diff_easy.setCanPress(false);
	} else if (diff_normal.isInBound(screenX, height - screenY)) {
	    diff_normal.setCanPress(false);
	} else if (diff_hard.isInBound(screenX, height - screenY)) {
	    diff_hard.setCanPress(false);
	}
	return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	// super.touchUp(screenX, screenY, pointer, button);
	if (diff_easy.isInBound(screenX, height - screenY)
		&& !diff_easy.canPress()) {
	    super.touchUp(screenX, screenY, pointer, button);
	} else if (diff_normal.isInBound(screenX, height - screenY)
		&& !diff_normal.canPress()) {
	    super.touchUp(screenX, screenY, pointer, button);
	} else if (diff_hard.isInBound(screenX, height - screenY)
		&& !diff_hard.canPress()) {
	    super.touchUp(screenX, screenY, pointer, button);
	}

	if (!diff_easy.canPress()) {
	    diff_easy.setCanPress(true);
	} else if (!diff_normal.canPress()) {
	    diff_normal.setCanPress(true);
	} else if (!diff_hard.canPress()) {
	    diff_hard.setCanPress(true);
	}

	GameControl.getManagerScreen().creatScreen(ManagerScreen.SCREEN_PLAY);

	return false;
    }

    @Override
    public boolean keyDown(int keycode) {
	// TODO Auto-generated method stub
	if (keycode == Keys.BACK) {
	    GameControl.getManagerScreen()
		    .creatScreen(ManagerScreen.SCREEN_MAP);
	}
	return super.keyDown(keycode);
    }

}
