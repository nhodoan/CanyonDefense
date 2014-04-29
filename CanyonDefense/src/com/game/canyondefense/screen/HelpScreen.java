package com.game.canyondefense.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.global.ManagerRegion;
import com.game.canyondefense.object.AreaObject;

public class HelpScreen extends BaseScreen {
    private String TAG = "High score screen";
    private int id = 1;
    private TextureRegion bg;
    private AreaObject next, prev;

    @Override
    public void show() {
	// TODO Auto-generated method stub
	super.show();
	Gdx.input.setCatchBackKey(true);
	/* Using for InputProcessor */
	Gdx.input.setInputProcessor(this);
	Gdx.app.log(TAG, "Start showing start screen");
	next = new AreaObject(IDObject.GUI_NEXT);
	prev = new AreaObject(IDObject.GUI_PREV);
    }

    @Override
    public void render(float arg0) {
	// TODO Auto-generated method stub
	super.render(arg0);
	Gdx.gl.glClearColor(0.5f, 0.6f, 0.5f, 1);
	Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	update(arg0);
	camera.update();
	stage.act(arg0);
	sb.begin();
	/* End Draw */
	sb.draw(bg, 0, 0, width, height);
	if (id == 1 || id == 2) {
	    sb.draw(next.getTexture(), next.getX(), next.getY(),
		    next.getWidth(), next.getHeight());
	}
	if (id == 2 || id == 3) {
	    sb.draw(prev.getTexture(), prev.getX(), prev.getY(),
		    prev.getWidth(), prev.getHeight());
	}
	sb.end();
	stage.draw();

    }

    /**
     * Update Status Of Object
     * 
     * @param time
     */
    private void update(float time) {
	if (id == 1) {
	    bg = ManagerRegion.gui_1;
	} else if (id == 2) {
	    bg = ManagerRegion.gui_2;
	} else {
	    bg = ManagerRegion.gui_3;
	}
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	// super.touchDown(screenX, screenY, pointer, button);
	float x = screenX;
	float y = screenY;
	if (next.isInBound(x, y) && (id == 1 || id == 2)) {
	    next.setCanPress(false);
	} else if (prev.isInBound(x, y) && (id == 2 || id == 3)) {
	    prev.setCanPress(false);
	}
	return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	// super.touchUp(screenX, screenY, pointer, button);
	float x = screenX;
	float y = screenY;
	if (!next.canPress()) {
	    if (next.isInBound(x, y)) {
		id++;
	    }
	    next.setCanPress(true);
	} else if (!prev.canPress()) {
	    if (prev.isInBound(x, y)) {
		id--;
	    }
	}
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
