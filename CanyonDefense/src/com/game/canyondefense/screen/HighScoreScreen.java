package com.game.canyondefense.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.ManagerRegion;

public class HighScoreScreen extends BaseScreen {
    private String TAG = "High score screen";

    @Override
    public void show() {
	// TODO Auto-generated method stub
	super.show();
	Gdx.input.setCatchBackKey(true);
	/* Using for InputProcessor */
	Gdx.input.setInputProcessor(this);
	Gdx.app.log(TAG, "Start showing start screen");
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
	/* End Draw */
	sb.draw(ManagerRegion.star_bg, 0, 0, width, height);
//	sb.draw(ManagerRegion.high_score_table, x, y, arg0, arg0);
	sb.end();
	stage.draw();
	update(arg0);
    }

    /**
     * Update Status Of Object
     * 
     * @param time
     */
    private void update(float time) {
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	// super.touchDown(screenX, screenY, pointer, button);
	return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	// super.touchUp(screenX, screenY, pointer, button);
	return false;
    }

    @Override
    public boolean keyDown(int keycode) {
	if (keycode == Keys.BACK) {
	    GameControl.getManagerScreen().creatScreen(
		    ManagerScreen.SCREEN_START);
	}
	return super.keyDown(keycode);
    }
}
