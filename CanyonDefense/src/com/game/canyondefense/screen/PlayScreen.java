package com.game.canyondefense.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.global.ManagerRegion;
import com.game.canyondefense.global.MapData;
import com.game.canyondefense.global.Position;
import com.game.canyondefense.object.AreaObject;
import com.game.canyondefense.object.AttackAirObject;
import com.game.canyondefense.object.AttackGroundObject;
import com.game.canyondefense.object.AttackObject;
import com.game.canyondefense.object.Bullet;
import com.game.canyondefense.object.DefenseAirObject;
import com.game.canyondefense.object.DefenseGroundObject;
import com.game.canyondefense.object.DefenseObject;

public class PlayScreen extends BaseScreen implements InputProcessor {
    private final String TAG = "Play Screen";
    AtlasRegion bg;
    long timeStart = 0l;

    public static int map;
    public static int level;
    public static int number_wave_current, number_wave_max;

    // private AttackGroundObject attack_ground_1, attack_ground_2;
    // private AttackAirObject attack_air;
    //
    // private DefenseGroundObject gun_1, gun_2;
    // private DefenseAirObject defense_3;

    private AreaObject play_game, sound_game, quit_play_game, play_attack,
	    sell_object, defense_1, defense_2, defense_3;
    private TextureRegion landmarkdenfense;

    private ArrayList<AttackObject> list_attack_object;
    private ArrayList<DefenseObject> list_defense_object;
    private ArrayList<Integer> list_attack_data;
    private ArrayList<Bullet> list_bullet;
    private boolean isPlay = true;
    private boolean isAttack = false;

    @Override
    public void show() {
	// TODO Auto-generated method stub
	super.show();
	Gdx.input.setCatchBackKey(true);
	Gdx.input.setInputProcessor(this);

	/* Init data */
	list_attack_object = new ArrayList<AttackObject>();
	list_attack_data = new ArrayList<Integer>();
	list_attack_data = new ArrayList<Integer>();
	list_bullet = new ArrayList<Bullet>();
	/* Init object */

	bg = GameControl.getAtlas().findRegion("data/loading");
	landmarkdenfense = ManagerRegion.landmarkdefense;
	/* Object control status game */
	play_game = new AreaObject(IDObject.PLAY_MENU_PLAY);
	sound_game = new AreaObject(IDObject.PLAY_MENU_SOUND);
	quit_play_game = new AreaObject(IDObject.PLAY_MENU_QUIT);

	/* Object select weakpon */
	defense_1 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_1);
	defense_2 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_2);
	defense_3 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_3);

	play_attack = new AreaObject(IDObject.PLAY_MENU_ATTACK);
	sell_object = new AreaObject(IDObject.PLAY_MENU_SELL);

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

	// Render here
	sb.begin();

	/* Render map */
	for (int i = 0; i < 12; i++) {
	    for (int j = 0; j < 12; j++) {
		if (MapData.map1[i * 12 + j] == 0) {
		    sb.draw(ManagerRegion.brick, j * Dimension.BRICK_W, height
			    - (i+1) * Dimension.BRICK_H, Dimension.BRICK_W,
			    Dimension.BRICK_H);
		}
	    }
	}

	/**
	 * Render menu bar here
	 */

	/* Render status bar game */
	sb.draw(ManagerRegion.menu_bg, Position.MENU_X, Position.MENU_Y,
		Dimension.MENU_W, Dimension.MENU_H);
	sb.draw(play_game.getTexture(), play_game.getX(), play_game.getY(),
		play_game.getWidth(), play_game.getHeight());
	sb.draw(sound_game.getTexture(), sound_game.getX(), sound_game.getY(),
		sound_game.getWidth(), sound_game.getHeight());
	sb.draw(quit_play_game.getTexture(), quit_play_game.getX(),
		quit_play_game.getY(), quit_play_game.getWidth(),
		quit_play_game.getHeight());

	/* Render weakpon game */
	sb.draw(defense_1.getTexture(), defense_1.getX(), defense_1.getY(),
		defense_1.getWidth(), defense_1.getHeight());
	sb.draw(defense_2.getTexture(), defense_2.getX(), defense_2.getY(),
		defense_2.getWidth(), defense_2.getHeight());
	sb.draw(defense_3.getTexture(), defense_3.getX(), defense_3.getY(),
		defense_3.getWidth(), defense_3.getHeight());

	// sb.draw(play_attack.getTexture(),play_attack.getX(),play_attack.getY(),play_attack.getWidth(),play_attack.getHeight());
	//
	// /**
	// * Render main play game
	// */
	//
	// /* Render attack object */
	// for (AttackObject attackObject : list_attack_object) {
	// if (!attackObject.isDead()) {
	// sb.draw(attackObject.getTexture(), attackObject.getX(),
	// attackObject.getY(), attackObject.getWidth(),
	// attackObject.getHeight());
	// }
	// }
	// /* Render defense object */
	// for (DefenseObject defenseObject : list_defense_object) {
	// sb.draw(defenseObject.getTexture(), defenseObject.getX(),
	// defenseObject.getY(), defenseObject.getWidth(),
	// defenseObject.getHeight());
	// if (defenseObject.isPress()) {
	// sb.draw(landmarkdenfense,
	// defenseObject.getX() + defenseObject.getWidth() / 2
	// - defenseObject.getRadius_attack(),
	// defenseObject.getY() + defenseObject.getHeight() / 2
	// - defenseObject.getRadius_attack(),
	// 2 * defenseObject.getRadius_attack(),
	// 2 * defenseObject.getRadius_attack());
	//
	// }
	// }

	/* Render bullet */
	// for (Bullet bullet : list_bullet) {
	// sb.draw(bullet.getTexture(), bullet.getX(), bullet.getY(),
	// bullet.getWidth(), bullet.getHeight());
	// }
	//

	sb.end();
	stage.draw();
	update(arg0);
    }

    private void update(float time) {

	if (isPlay) {

	}

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	float x = screenX;
	float y = height - screenY;
	if (!isPlay) {
	} else {
	    if (play_game.isInBound(x, y)) {
		play_game.setCanPress(false);
		return true;
	    } else if (sound_game.isInBound(x, y)) {
		sound_game.setCanPress(false);
		return true;
	    } else if (quit_play_game.isInBound(x, y)) {
		quit_play_game.setCanPress(false);
		return true;
	    } else if (defense_1.isInBound(x, y)) {
		defense_1.setCanPress(false);
		return true;
	    } else if (defense_2.isInBound(x, y)) {
		defense_2.setCanPress(false);
		return true;
	    } else if (defense_3.isInBound(x, y)) {
		defense_3.setCanPress(false);
		return true;
	    } else if (defense_2.isInBound(x, y)) {
		defense_2.setCanPress(false);
		return true;
	    }
	    for (DefenseObject defenseObject : list_defense_object) {
		if (defenseObject.isInBound(x, y)) {
		    defenseObject.setPress(false);
		    break;
		}
	    }
	}

	return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	float x = screenX;
	float y = height - screenY;
	if (!play_game.canPress()) {
	    play_game.setCanPress(true);
	    if (play_game.isInBound(x, y)) {
		isPlay = !isPlay;
		return true;
	    }
	} else if (!sound_game.canPress()) {
	    sound_game.setCanPress(true);
	    if (sound_game.isInBound(x, y)) {
		return true;
	    }
	} else if (!quit_play_game.canPress()) {
	    quit_play_game.setCanPress(true);
	    if (quit_play_game.isInBound(x, y)) {
		return true;
	    }
	} else if (!defense_1.canPress()) {
	    defense_1.setCanPress(true);
	    if (defense_1.isInBound(x, y)) {
		return true;
	    }
	} else if (!defense_2.canPress()) {
	    defense_2.setCanPress(true);
	    if (defense_2.isInBound(x, y)) {
		return true;
	    }
	} else if (!defense_3.canPress()) {
	    defense_3.setCanPress(true);
	    if (defense_3.isInBound(x, y)) {
		return true;
	    }
	} else if (!play_attack.canPress()) {
	    play_attack.setCanPress(true);
	    if (play_attack.isInBound(x, y)) {
		return true;
	    }
	}
	return super.touchUp(screenX, screenY, pointer, button);
    }

}
