package com.game.canyondefense.screen;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.global.IDPerson;
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
import com.game.canyondefense.utils.Collision;

public class PlayScreen extends BaseScreen implements InputProcessor {
    private final String TAG = "Play Screen";
    AtlasRegion bg;;

    public static boolean isSound = true;
    public static int map;
    public static int level;
    public static int number_wave_current, number_wave_max;

    // private AttackGroundObject attack_ground_1, attack_ground_2;
    // private AttackAirObject attack_air;
    //
    // private DefenseGroundObject gun_1, gun_2;
    // private DefenseAirObject defense_3;

    private AreaObject play_game, play_attack, sell_object, defense_1,
	    defense_2, defense_3;
    private TextureRegion landmarkdenfense;

    private ArrayList<AttackObject> list_attack_object;
    private ArrayList<DefenseObject> list_defense_object;
    private ArrayList<Integer> list_attack_data;
    private ArrayList<Bullet> list_bullet;
    private boolean isPlay = true;
    private boolean isAttack = false;

    // private AttackGroundObject list_attack_object.get(i);
    private long timeStartWave;
    private boolean startWave = true;

    private boolean select_defense_1, select_defense_2, select_defense_3;

    private Integer[] mapData;
    private int sumAttack = 0;

    // private DefenseGroundObject testDefense;

    @Override
    public void show() {
	// TODO Auto-generated method stub
	super.show();
	Gdx.input.setCatchBackKey(true);
	Gdx.input.setInputProcessor(this);

	/* Init data */
	mapData = MapData.map1;
	list_attack_object = new ArrayList<AttackObject>();
	list_defense_object = new ArrayList<DefenseObject>();
	select_defense_1 = select_defense_2 = select_defense_3 = false;
	// list_attack_object.add(new Att)
	list_attack_data = new ArrayList<Integer>();
	list_bullet = new ArrayList<Bullet>();
	DefenseObject testDefense1 = new DefenseGroundObject(
		IDPerson.DEFENSE_GROUND_1);
	testDefense1.setX(Position.genX(6));
	testDefense1.setY(Position.genY(4));
	list_defense_object.add(testDefense1);

	DefenseObject testDefense2 = new DefenseGroundObject(
		IDPerson.DEFENSE_GROUND_2);
	testDefense2.setX(Position.genX(8));
	testDefense2.setY(Position.genY(8));
	list_defense_object.add(testDefense2);

	DefenseObject testDefense3 = new DefenseAirObject(IDPerson.DEFENSE_AIR);
	testDefense3.setX(Position.genX(5));
	testDefense3.setY(Position.genY(4));
	list_defense_object.add(testDefense3);

	// list_attack_object.get(i) = new
	// AttackGroundObject(IDPerson.ATTACK_GROUND_1);
	/* Init object */

	bg = GameControl.getAtlas().findRegion("data/loading");
	landmarkdenfense = ManagerRegion.landmarkdefense;
	/* Object control status game */
	play_game = new AreaObject(IDObject.PLAY_MENU_PLAY);

	/* Object select weakpon */
	defense_1 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_1);
	defense_2 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_2);
	defense_3 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_3);

	play_attack = new AreaObject(IDObject.PLAY_MENU_ATTACK);
	sell_object = new AreaObject(IDObject.PLAY_MENU_SELL);

	// timeStart = System.currentTimeMillis();
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
	for (int i = 0; i < MapData.rows; i++) {
	    for (int j = 0; j < MapData.columns; j++) {
		if (mapData[i * MapData.columns + j] == 0) {
		    sb.draw(ManagerRegion.brick, j * Dimension.BRICK_W, height
			    - (i + 1) * Dimension.BRICK_H, Dimension.BRICK_W,
			    Dimension.BRICK_H);
		} else if (mapData[i * MapData.columns + j] == 1) {
		    sb.draw(ManagerRegion.ground, j * Dimension.BRICK_W, height
			    - (i + 1) * Dimension.BRICK_H, Dimension.BRICK_W,
			    Dimension.BRICK_H);
		} else {
		    sb.draw(ManagerRegion.tree, j * Dimension.BRICK_W, height
			    - (i + 1) * Dimension.BRICK_H, Dimension.BRICK_W,
			    Dimension.BRICK_H);
		}
	    }
	}

	/**
	 * Render menu bar here
	 */

	/* Render control bar game */
	// sb.draw(ManagerRegion.menu_bg, Position.MENU_X, Position.MENU_Y,
	// Dimension.MENU_W, Dimension.MENU_H);
	sb.draw(play_game.getTexture(), play_game.getX(), play_game.getY(),
		play_game.getWidth(), play_game.getHeight());
	// if (isSound) {
	// sound_game.setMyTexture(ManagerRegion.play_menu_sound_on_normal);
	// sound_game.setMyTextureWait(ManagerRegion.play_menu_sound_on_press);
	//
	// } else {
	// sound_game.setMyTexture(ManagerRegion.play_menu_sound_off_normal);
	// sound_game
	// .setMyTextureWait(ManagerRegion.play_menu_sound_off_press);
	//
	// }
	// sb.draw(sound_game.getTexture(), sound_game.getX(),
	// sound_game.getY(),
	// sound_game.getWidth(), sound_game.getHeight());
	// sb.draw(quit_play_game.getTexture(), quit_play_game.getX(),
	// quit_play_game.getY(), quit_play_game.getWidth(),
	// quit_play_game.getHeight());

	// /* Render weakpon game */
	// sb.draw(defense_1.getTexture(), defense_1.getX(), defense_1.getY(),
	// defense_1.getWidth(), defense_1.getHeight());
	// sb.draw(defense_2.getTexture(), defense_2.getX(), defense_2.getY(),
	// defense_2.getWidth(), defense_2.getHeight());
	// sb.draw(defense_3.getTexture(), defense_3.getX(), defense_3.getY(),
	// defense_3.getWidth(), defense_3.getHeight());

	/* Test attack move */

	for (int i = 0; i < list_attack_object.size(); i++) {
	    sb.draw(list_attack_object.get(i).getTexture(), list_attack_object
		    .get(i).getX(), list_attack_object.get(i).getY(),
		    list_attack_object.get(i).getWidth(), list_attack_object
			    .get(i).getHeight());
	    sb.draw(ManagerRegion.frame_blood,
		    list_attack_object.get(i).getX(), list_attack_object.get(i)
			    .getY() + Dimension.ATTACK_H, Dimension.ATTACK_W,
		    Dimension.ATTACK_H / 10);
	    sb.draw(ManagerRegion.blood, list_attack_object.get(i).getX(),
		    list_attack_object.get(i).getY() + Dimension.ATTACK_H,
		    Dimension.ATTACK_W * list_attack_object.get(i).getBlood()
			    / list_attack_object.get(i).getMax_blood(),
		    Dimension.ATTACK_H / 10);
	}

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

	for (DefenseObject defenseObject : list_defense_object) {
	    sb.draw(defenseObject.getTexture(), defenseObject.getX(),
		    defenseObject.getY(), defenseObject.getWidth(),
		    defenseObject.getHeight());
	    if (defenseObject.isPress()) {
		Color c = sb.getColor();
		float oldAlpha = c.a;
		c.a = oldAlpha * 0.5f;
		sb.setColor(c);
		sb.draw(ManagerRegion.circle_attack,
			defenseObject.getX() + defenseObject.getWidth() / 2
				- defenseObject.getRadius_attack(),
			defenseObject.getY() + defenseObject.getHeight() / 2
				- defenseObject.getRadius_attack(),
			2 * defenseObject.getRadius_attack(),
			2 * defenseObject.getRadius_attack());
		c.a = oldAlpha;
		sb.setColor(c);
	    }
	}
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
	for (Bullet bullet : list_bullet) {
	    sb.draw(bullet.getTexture(), bullet.getX(), bullet.getY(),
		    bullet.getWidth(), bullet.getHeight());
	}

	sb.end();

	if (!isPlay) {
	    /* Render dialog show game is paused */
	}
	stage.draw();
	update(arg0);
    }

    private void update(float time) {

	if (isPlay) {

	    // Control move of attack
	    if (startWave) {
		timeStartWave = System.currentTimeMillis();
		startWave = false;
	    }
	    if (System.currentTimeMillis() - timeStartWave > sumAttack * 500) {
		if (list_attack_object.size() % 5 == 0) {
		    list_attack_object.add(new AttackAirObject(
			    IDPerson.ATTACK_AIR));
		} else {
		    list_attack_object.add(new AttackGroundObject(
			    IDPerson.ATTACK_GROUND_2));
		}
		sumAttack++;
	    }

	    for (int i = 0; i < list_attack_object.size(); i++) {

		if (list_attack_object.get(i).getId() != IDPerson.ATTACK_AIR) {
		    int currentI = (int) (list_attack_object.get(i).getX() * 2 / Dimension.BRICK_W);
		    int currentJ = (int) (list_attack_object.get(i).getY() * 2 / Dimension.BRICK_H);

		    boolean checkDirection = false;
		    if (currentJ % 2 == 0) {
			if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.DOWN) {
			    checkDirection = true;
			}
		    } else {
			if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.UP) {
			    checkDirection = true;
			}
		    }

		    if (currentI % 2 == 0) {
			if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.RIGHT) {
			    checkDirection = true;
			}
		    } else {
			if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.LEFT) {
			    checkDirection = true;
			}
		    }
		    if (checkDirection) {
			currentI = currentI / 2;
			currentJ = MapData.rows - 1 - currentJ / 2;
			if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.DOWN) {
			    if (mapData[currentI + (currentJ + 1)
				    * MapData.columns] != 0) {
				if (mapData[currentI + 1 + currentJ
					* MapData.columns] == 0) {
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.RIGHT);
				    list_attack_object.get(i).setY(
					    (MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				} else {
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.LEFT);
				    list_attack_object.get(i).setY(
					    (MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				}
			    }

			} else if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.UP) {
			    if (mapData[currentI + (currentJ - 1)
				    * MapData.columns] != 0) {
				if (mapData[currentI + 1 + currentJ
					* MapData.columns] == 0) {
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.RIGHT);
				    list_attack_object.get(i).setY(
					    (MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				} else {
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.LEFT);
				    list_attack_object.get(i).setY(
					    (MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				}
			    }
			} else if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.RIGHT) {
			    if (mapData[currentI + 1 + currentJ
				    * MapData.columns] != 0) {
				if (mapData[currentI + (currentJ + 1)
					* MapData.columns] == 0) {
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.DOWN);
				    list_attack_object.get(i).setX(
					    currentI * Dimension.BRICK_W);
				    ;
				} else {
				    list_attack_object.get(i).setX(
					    currentI * Dimension.BRICK_W);
				    ;
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.UP);
				}
			    }
			} else if (list_attack_object.get(i).getStatusMove() == AttackGroundObject.LEFT) {
			    if (mapData[currentI - 1 + currentJ
				    * MapData.columns] != 0) {
				if (mapData[currentI + (currentJ + 1)
					* MapData.columns] == 0) {
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.DOWN);
				    list_attack_object.get(i).setX(
					    currentI * Dimension.BRICK_W);
				    ;
				} else {
				    list_attack_object.get(i).setStatusMove(
					    AttackGroundObject.UP);
				    list_attack_object.get(i).setX(
					    currentI * Dimension.BRICK_W);
				    ;
				}
			    }
			}
		    }
		}

		list_attack_object.get(i).move(time);
	    }
	    /* End control move of attacks */

	    /* Control defense attack */
	    for (DefenseObject defenseObject : list_defense_object) {
		if (System.currentTimeMillis() - defenseObject.getTimeOldFire() > 1000) {
		    for (AttackObject attackObject : list_attack_object) {
			if ((attackObject.getId() != IDPerson.ATTACK_AIR && defenseObject.getId() != IDPerson.DEFENSE_AIR) 
			    || (attackObject.getId() == IDPerson.ATTACK_AIR && defenseObject.getId() == IDPerson.DEFENSE_AIR)) {
			    if (defenseObject.isInRadius(attackObject.getX(),
				    attackObject.getY())) {
				Bullet bullet = new Bullet();
				bullet.setX(defenseObject.getX()
					+ defenseObject.getWidth() / 2);
				bullet.setY(defenseObject.getY()
					+ defenseObject.getHeight() / 2);
				bullet.genRoute(
					attackObject.getX()
						+ attackObject.getWidth() / 2,
					attackObject.getY()
						+ attackObject.getHeight() / 2);
				defenseObject.setTimeOldFire(System
					.currentTimeMillis());
				list_bullet.add(bullet);
				Gdx.app.log("Bullet", "Added");
				break;

			    }
			}
		    }
		}
	    }

	    /* Check collision */
	    for (AttackObject attackObject : list_attack_object) {
		for (Bullet bullet : list_bullet) {
		    if (Collision.isCollision(attackObject, bullet)
			    && !attackObject.isDead()) {
			attackObject.attack(bullet.getPower());
			list_bullet.remove(bullet);
			Gdx.app.log("Bullet", "Removed");
			// bullet.setX(width + 10);
			if (list_bullet.size() == 0)
			    break;
		    }
		}
	    }
	    /* Move bullet */
	    for (Bullet bullet : list_bullet) {
		bullet.move(time);
	    }

	    /* Check bullet */
	    for (Iterator<Bullet> it = list_bullet.iterator(); it.hasNext();) {
		Bullet bullet = it.next();
		if (bullet.getX() < 0 || bullet.getX() > width
			|| bullet.getY() < 0 || bullet.getY() > height) {
		    it.remove();

		}
	    }
	    // for (Bullet bullet : list_bullet) {
	    // if (bullet.getX() < 0 || bullet.getX() > width
	    // || bullet.getY() < 0 || bullet.getY() > height)
	    // list_bullet.remove(bullet);
	    // if (list_bullet.size() == 0)
	    // break;
	    // }

	    /* Check attack object */

	    for (Iterator<AttackObject> it = list_attack_object.iterator(); it
		    .hasNext();) {
		AttackObject attackObject = it.next();
		if (attackObject.isDead())
		    it.remove();
	    }
	    // for (AttackObject attackObject : list_attack_object) {
	    // if (attackObject.isDead())
	    // list_attack_object.remove(attackObject);
	    // if (list_attack_object.size() == 0)
	    // break;
	    // }
	    //Gdx.app.log("Circle", "-----------Ended one loop------------");

	}

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	float x = screenX;
	float y = height - screenY;
	if (play_game.isInBound(x, y)) {
	    play_game.setCanPress(false);
	    return true;
	}
	if (!isPlay) {

	} else {

	    for (DefenseObject defenseObject : list_defense_object) {

		defenseObject.setPress(false);

	    }
	    if (defense_1.isInBound(x, y)) {
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
		    defenseObject.setPress(true);
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
	} else if (!defense_1.canPress()) {
	    defense_1.setCanPress(true);
	    if (defense_1.isInBound(x, y)) {
		select_defense_1 = !select_defense_1;
		if (select_defense_1) {
		    select_defense_2 = select_defense_3 = false;
		}
		return true;
	    }
	} else if (!defense_2.canPress()) {
	    defense_2.setCanPress(true);
	    if (defense_2.isInBound(x, y)) {
		select_defense_2 = !select_defense_2;
		if (select_defense_2) {
		    select_defense_1 = select_defense_3 = false;
		}
		return true;
	    }
	} else if (!defense_3.canPress()) {
	    defense_3.setCanPress(true);
	    if (defense_3.isInBound(x, y)) {
		select_defense_3 = !select_defense_3;
		if (select_defense_3) {
		    select_defense_2 = select_defense_1 = false;
		}
		return true;
	    }
	} else if (!play_attack.canPress()) {
	    play_attack.setCanPress(true);
	    if (play_attack.isInBound(x, y)) {
		return true;
	    }
	}
	/* Check touch Up on all defenses */

	return super.touchUp(screenX, screenY, pointer, button);
    }

}
