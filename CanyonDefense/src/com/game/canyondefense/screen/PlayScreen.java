package com.game.canyondefense.screen;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.global.ManagerRegion;
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
    // private DefenseAirObject craker;

    private AreaObject play_game, sound_game, quit_play_game, play_attack,
	    sell_object, gun_1, gun_2, craker;
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
	gun_1 = new AreaObject(IDObject.PLAY_MENU_GUN_1);
	gun_2 = new AreaObject(IDObject.PLAY_MENU_GUN_2);
	craker = new AreaObject(IDObject.PLAY_MENU_CRAKER);

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

	/**
	 * Render menu bar here
	 */

	/* Render status bar game */
	sb.draw(play_game.getTexture(), play_game.getX(), play_game.getY(),
		play_game.getWidth(), play_game.getHeight());
	sb.draw(sound_game.getTexture(), sound_game.getX(), sound_game.getY(),
		sound_game.getWidth(), sound_game.getHeight());
	sb.draw(quit_play_game.getTexture(), quit_play_game.getX(),
		quit_play_game.getY(), quit_play_game.getWidth(),
		quit_play_game.getHeight());

	/* Render weakpon game */
	sb.draw(gun_1.getTexture(), gun_1.getX(), gun_1.getY(),
		gun_1.getWidth(), gun_1.getHeight());
	sb.draw(gun_2.getTexture(), gun_2.getX(), gun_2.getY(),
		gun_2.getWidth(), gun_2.getHeight());
	sb.draw(craker.getTexture(), craker.getX(), craker.getY(),
		craker.getWidth(), craker.getHeight());
		
	sb.draw(play_attack.getTexture(),play_attack.getX(),play_attack.getY(),play_attack.getWidth(),play_attack.getHeight());

	/**
	 * Render main play game
	 */

	/* Render attack object */
	for (AttackObject attackObject : list_attack_object) {
	    if (!attackObject.isDead()) {
		sb.draw(attackObject.getTexture(), attackObject.getX(),
			attackObject.getY(), attackObject.getWidth(),
			attackObject.getHeight());
	    }
	}
	/* Render defense object */
	for (DefenseObject defenseObject : list_defense_object) {
	    sb.draw(defenseObject.getTexture(), defenseObject.getX(),
		    defenseObject.getY(), defenseObject.getWidth(),
		    defenseObject.getHeight());
	    if (defenseObject.isPress()) {
		sb.draw(landmarkdenfense,
			defenseObject.getX() + defenseObject.getWidth() / 2
				- defenseObject.getRadius_attack(),
			defenseObject.getY() + defenseObject.getHeight() / 2
				- defenseObject.getRadius_attack(),
			2 * defenseObject.getRadius_attack(),
			2 * defenseObject.getRadius_attack());

	    }
	}

	/* Render bullet */
	for (Bullet bullet : list_bullet) {
	    bullet.draw(sb);
	}
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
	if(!isPlay){
	}else{
	if(play_game.isInBound(x,y)){
		play_game.setCanPress(false);
		return true;
	}else if(sound_game.isInBound(x,y)){
		sound_game.setCanPress(false);
		return true;
	}else if(quit_play_game.isInBound(x,y)){
		quit_play_game.setCanPress(false);
		return true;
	}else if(gun_1.isInBound(x,y)){
		gun_1.setCanPress(false);
		return true;
	}else if(gun_2.isInBound(x,y)){
		gun_2.setCanPress(false);
		return true;
	}else if(craker.isInBound(x,y)){
		craker.setCanPress(false);
		return true;
	}else if(gun_2.isInBound(x,y)){
		gun_2.setCanPress(false);
		return true;
	}
	for(DefenseObject defenseObject: list_defense_object){
		if(defenseObject.isInBound(x,y)){
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
	if(!play_game.canPress()){
		play_game.setCanPress(true);
		if(play_game.isInBound(x,y)){
			isPlay = !isPlay;			
			return true;
		}		
	}else if(!sound_game.canPress()){
		sound_game.setCanPress(true);
		if(sound_game.isInBound(x,y)){			
			return true;
		}
	}else if(!quit_play_game.canPress()){
		quit_play_game.setCanPress(true);
		if(quit_play_game.isInBound(x,y)){
			return true;	
		}
	}else if(!gun_1.canPress()){
		gun_1.setCanPress(true);
		if(gun_1.isInBound(x,y)){
			return true;	
		}
	}else if(!gun_2.canPress()){
		gun_2.setCanPress(true);
		if(gun_2.isInBound(x,y)){
			return true;	
		}
	}else if(!craker.canPress()){
		craker.setCanPress(true);
		if(craker.isInBound(x,y)){
			return true;	
		}
	}else if(!play_attack.canPress()){
		play_attack.setCanPress(true);
		if(play_attack.isInBound(x,y)){
			return true;	
		}
	}
	return super.touchUp(screenX, screenY, pointer, button);
    }

}
