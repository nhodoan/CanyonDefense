package com.game.canyondefense.screen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.GameControl;
import com.game.canyondefense.global.Dimension;
import com.game.canyondefense.global.IDObject;
import com.game.canyondefense.global.IDPerson;
import com.game.canyondefense.global.ManagerRegion;
import com.game.canyondefense.global.MapData;
import com.game.canyondefense.global.Position;
import com.game.canyondefense.global.Sale;
import com.game.canyondefense.object.AreaObject;
import com.game.canyondefense.object.AttackGroundObject;
import com.game.canyondefense.object.AttackObject;
import com.game.canyondefense.object.Bullet;
import com.game.canyondefense.object.DefenseAirObject;
import com.game.canyondefense.object.DefenseGroundObject;
import com.game.canyondefense.object.DefenseObject;
import com.game.canyondefense.utils.Collision;

public class PlayScreen extends BaseScreen implements InputProcessor {
    @SuppressWarnings("unused")
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

    private AreaObject play_game, play_attack, sell_object, popup_defense_1,
	    popup_defense_2, popup_defense_3;

    private ArrayList<AttackObject> list_attack_object;
    private ArrayList<DefenseObject> list_defense_object;
    private ArrayList<Bullet> list_bullet;

    private ArrayList<ArrayList<Integer>> allData;
    private boolean isPlay = true;

    // private AttackGroundObject list_attack_object.get(i);
    private long timeStartWave;
    private boolean startWave = true;

    private Integer[] mapData;
    private int sumAttack = 0;
    private boolean showPopupSelectDefense = false;

    private static int gold = 250;
    private static int heart = 20;

    private static int maxWave, currentWave;

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
	// list_attack_object.add(new Att)
	list_bullet = new ArrayList<Bullet>();
	allData = new ArrayList<ArrayList<Integer>>();

	loadData();
	maxWave = allData.size();
	currentWave = 1;
	// list_attack_object.get(i) = new
	// AttackGroundObject(IDPerson.ATTACK_GROUND_1);
	/* Init object */

	bg = GameControl.getAtlas().findRegion("data/loading");
	/* Object control status game */
	play_game = new AreaObject(IDObject.PLAY_MENU_PLAY);

	/* Object select weakpon */
	popup_defense_1 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_1);
	popup_defense_2 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_2);
	popup_defense_3 = new AreaObject(IDObject.PLAY_MENU_DEFENSE_3);

	play_attack = new AreaObject(IDObject.PLAY_MENU_ATTACK);
	sell_object = new AreaObject(IDObject.PLAY_MENU_SELL);
    }

    private void loadData() {
	try {
	    FileHandle file = Gdx.files.internal("MyData\\data\\game1.dat");
	    InputStream ips = file.read();
	    InputStreamReader ipsr = new InputStreamReader(ips);
	    BufferedReader br = new BufferedReader(ipsr);
	    String line;
	    while ((line = br.readLine()) != null) {
		ArrayList<Integer> loadOneWave = new ArrayList<Integer>();
		String[] splitLine = line.split(",");
		Gdx.app.log(TAG, line);
		for (String x : splitLine) {
		    loadOneWave.add(Integer.parseInt(x));
		}
		allData.add(loadOneWave);
	    }
	    br.close();
	} catch (Exception e) {
	    System.out.println(e.toString());
	}
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
		} else if (mapData[i * MapData.columns + j] == 2) {
		    sb.draw(ManagerRegion.tree, j * Dimension.BRICK_W, height
			    - (i + 1) * Dimension.BRICK_H, Dimension.BRICK_W,
			    Dimension.BRICK_H);
		} else {
		    sb.draw(ManagerRegion.ground, j * Dimension.BRICK_W, height
			    - (i + 1) * Dimension.BRICK_H, Dimension.BRICK_W,
			    Dimension.BRICK_H);
		}
	    }
	}

	/**
	 * Render menu bar here
	 */

	/* Render control bar game */
	sb.draw(play_game.getTexture(), play_game.getX(), play_game.getY(),
		play_game.getWidth(), play_game.getHeight());

	renderGold(sb);
	renderWave(sb);
	renderHeart(sb);
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

	/**
	 * Render main play game
	 */

	/* Render defense object */

	for (DefenseObject defenseObject : list_defense_object) {
	    sb.draw(defenseObject.getTexture(), defenseObject.getX(),
		    defenseObject.getY(), defenseObject.getWidth(),
		    defenseObject.getHeight());
	    if (defenseObject.isPress()) {
		Color c = sb.getColor();
		float oldAlpha = c.a;
		c.a = oldAlpha * 0.2f;
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

	/* Render bullet */
	for (Bullet bullet : list_bullet) {
	    sb.draw(bullet.getTexture(), bullet.getX(), bullet.getY(),
		    bullet.getWidth(), bullet.getHeight());
	}

	renderPopupSelectDefense(sb);

	sb.end();

	if (!isPlay) {
	    /* Render dialog show game is paused */
	}
	stage.draw();
	update(arg0);
    }

    public void renderGold(SpriteBatch sb) {
	sb.draw(ManagerRegion.gold_frame, Position.MENU_GOLD_FRAME_X,
		Position.MENU_GOLD_FRAME_Y, Dimension.MENU_GOLD_FRAME_W,
		Dimension.MENU_GOLD_FRAME_H);
	int countNumber = 0;
	if (gold > 0) {
	    countNumber = 1 + (int) Math.log10(gold);
	}
	int tempGold = gold;
	float xDraw = Position.MENU_GOLD_TEXT_X_START;
	for (int i = 0; i < countNumber; i++) {
	    int numberDraw = tempGold
		    / ((int) Math.pow(10, countNumber - i - 1));
	    /* Draw number here */
	    sb.draw(new TextureRegion(ManagerRegion.all_number,
		    numberDraw * 56, 0, 56, 50), xDraw, Position.MENU_TEXT_Y,
		    Dimension.MENU_TEXT_W, Dimension.MENU_TEXT_H);
	    xDraw += Dimension.MENU_TEXT_W * 9 / 10;
	    tempGold = tempGold - numberDraw
		    * (int) Math.pow(10, countNumber - i - 1);
	}

    }

    public void renderWave(SpriteBatch sb) {
	sb.draw(ManagerRegion.wave_frame, Position.MENU_WAVE_FRAME_X,
		Position.MENU_WAVE_FRAME_Y, Dimension.MENU_WAVE_FRAME_W,
		Dimension.MENU_WAVE_FRAME_H);

	float xDraw = Position.MENU_WAVE_TEXT_X_START;
	int firstCurrentWave = currentWave / 10;
	sb.draw(new TextureRegion(ManagerRegion.all_number,
		firstCurrentWave * 56, 0, 56, 50), xDraw, Position.MENU_TEXT_Y,
		Dimension.MENU_TEXT_W, Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	int secondCurrentWave = currentWave % 10;
	sb.draw(new TextureRegion(ManagerRegion.all_number,
		secondCurrentWave * 56, 0, 56, 50), xDraw,
		Position.MENU_TEXT_Y, Dimension.MENU_TEXT_W,
		Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W / 2;

	sb.draw(new TextureRegion(ManagerRegion.all_number, 10 * 56, 0, 56, 50),
		xDraw, Position.MENU_TEXT_Y, Dimension.MENU_TEXT_W,
		Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	int firstMaxWave = maxWave / 10;
	sb.draw(new TextureRegion(ManagerRegion.all_number, firstMaxWave * 56,
		0, 56, 50), xDraw, Position.MENU_TEXT_Y, Dimension.MENU_TEXT_W,
		Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	int secondMaxWave = maxWave % 10;
	sb.draw(new TextureRegion(ManagerRegion.all_number, secondMaxWave * 56,
		0, 56, 50), xDraw, Position.MENU_TEXT_Y, Dimension.MENU_TEXT_W,
		Dimension.MENU_TEXT_H);

    }

    public void renderHeart(SpriteBatch sb) {
	sb.draw(ManagerRegion.heart_frame, Position.MENU_HEART_FRAME_X,
		Position.MENU_HEART_FRAME_Y, Dimension.MENU_HEART_FRAME_W,
		Dimension.MENU_HEART_FRAME_H);

	float xDraw = Position.MENU_HEART_TEXT_X_START;
	int firstHeart = heart / 10;
	sb.draw(new TextureRegion(ManagerRegion.all_number, firstHeart * 56, 0,
		56, 50), xDraw, Position.MENU_TEXT_HEART_Y,
		Dimension.MENU_TEXT_W, Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	int secondHeart = heart % 10;
	sb.draw(new TextureRegion(ManagerRegion.all_number, secondHeart * 56,
		0, 56, 50), xDraw, Position.MENU_TEXT_HEART_Y,
		Dimension.MENU_TEXT_W, Dimension.MENU_TEXT_H);
    }

    public void renderPopupSelectDefense(SpriteBatch sb) {
	if (showPopupSelectDefense) {
	    sb.draw(ManagerRegion.circle_select, popup_defense_1.getX()
		    + Dimension.BRICK_W - Dimension.PLAY_MENU_CIRCLE_SELECT_W
		    / 2, popup_defense_1.getY() - Dimension.BRICK_H / 2
		    - Dimension.PLAY_MENU_CIRCLE_SELECT_H / 2,
		    Dimension.PLAY_MENU_CIRCLE_SELECT_W,
		    Dimension.PLAY_MENU_CIRCLE_SELECT_H);
	    sb.draw(popup_defense_1.getTexture(), popup_defense_1.getX(),
		    popup_defense_1.getY(), popup_defense_1.getWidth(),
		    popup_defense_1.getHeight());
	    sb.draw(popup_defense_2.getTexture(), popup_defense_2.getX(),
		    popup_defense_2.getY(), popup_defense_2.getWidth(),
		    popup_defense_2.getHeight());
	    sb.draw(popup_defense_3.getTexture(), popup_defense_3.getX(),
		    popup_defense_3.getY(), popup_defense_3.getWidth(),
		    popup_defense_3.getHeight());
	}
    }

    private void update(float time) {

	if (isPlay) {

	    // Control move of attack

	    if (System.currentTimeMillis() - timeStartWave > sumAttack * 1000
		    && (currentWave < maxWave)) {
		if (sumList(allData.get(currentWave - 1)) > 0) {
		    if (allData.get(currentWave - 1).get(0) > 0) {
			list_attack_object.add(new AttackGroundObject(
				IDPerson.ATTACK_GROUND_1));
			allData.get(currentWave - 1).set(0,
				allData.get(currentWave - 1).get(0) - 1);
		    } else if (allData.get(currentWave - 1).get(1) > 0) {
			list_attack_object.add(new AttackGroundObject(
				IDPerson.ATTACK_GROUND_2));
			allData.get(currentWave - 1).set(1,
				allData.get(currentWave - 1).get(1) - 1);
		    } else {
			list_attack_object.add(new AttackGroundObject(
				IDPerson.ATTACK_AIR));
			allData.get(currentWave - 1).set(2,
				allData.get(currentWave - 1).get(2) - 1);
		    }
		    // }
		} else {
		    // start new wave
		    // try {
		    // Thread.sleep(5000);
		    // } catch (InterruptedException e) {
		    // // TODO Auto-generated catch block
		    // e.printStackTrace();
		    // } finally {
		    // startWave = true;
		    // currentWave++;
		    // }

		    currentWave++;
		    if (currentWave < maxWave) {
			startWave = true;
		    }
		}
		sumAttack++;

	    }

	    if (startWave) {
		timeStartWave = System.currentTimeMillis();
		sumAttack = 0;
		startWave = false;
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

		    currentI = currentI / 2;
		    currentJ = MapData.rows - 1 - currentJ / 2;
		    if(currentI == MapData.columns - 1)
			checkDirection = false;
		    if (checkDirection) {

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
			if ((attackObject.getId() != IDPerson.ATTACK_AIR && defenseObject
				.getId() != IDPerson.DEFENSE_AIR)
				|| (attackObject.getId() == IDPerson.ATTACK_AIR && defenseObject
					.getId() == IDPerson.DEFENSE_AIR)) {
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
		// for (Bullet bullet : list_bullet) {
		// if (Collision.isCollision(attackObject, bullet)
		// && !attackObject.isDead()) {
		// attackObject.attack(bullet.getPower());
		// list_bullet.remove(bullet);
		// Gdx.app.log("Bullet", "Removed");
		// // bullet.setX(width + 10);
		// if (list_bullet.size() == 0)
		// break;
		// }
		// }
		for (Iterator<Bullet> it = list_bullet.iterator(); it.hasNext();) {
		    Bullet bullet = it.next();
		    if (Collision.isCollision(attackObject, bullet)
			    && !attackObject.isDead()) {
			attackObject.attack(bullet.getPower());
			it.remove();

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
		if (attackObject.isDead()) {
		    it.remove();
		    gold += attackObject.getGold();
		}
	    }
	    // for (AttackObject attackObject : list_attack_object) {
	    // if (attackObject.isDead())
	    // list_attack_object.remove(attackObject);
	    // if (list_attack_object.size() == 0)
	    // break;
	    // }
	    // Gdx.app.log("Circle", "-----------Ended one loop------------");

	} else {
	    if (timeStartWave > 1)
		timeStartWave += time;
	}

    }

    private int sumList(ArrayList<Integer> list) {
	int sum = 0;
	for (Integer i : list) {
	    sum += i;
	}
	return sum;
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

	    for (DefenseObject defenseObject : list_defense_object) {
		if (defenseObject.isInBound(x, y)) {
		    defenseObject.setPress(true);
		    return true;
		}
	    }

	    if (showPopupSelectDefense) {
		if (popup_defense_1.isInBound(x, y)) {
		    popup_defense_1.setCanPress(false);
		    return true;
		} else if (popup_defense_2.isInBound(x, y)) {
		    popup_defense_2.setCanPress(false);
		    return true;
		} else if (popup_defense_3.isInBound(x, y)) {
		    popup_defense_3.setCanPress(false);
		    return true;
		} else if (popup_defense_2.isInBound(x, y)) {
		    popup_defense_2.setCanPress(false);
		    return true;
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
	}
	if (showPopupSelectDefense) {
	    if (!popup_defense_1.canPress()) {
		popup_defense_1.setCanPress(true);
		if (popup_defense_1.isInBound(x, y)) {
		    Gdx.app.log("Add defense", "Added");
		    showPopupSelectDefense = false;
		    if (gold >= Sale.GROUND_1) {
			DefenseObject addDefense = new DefenseGroundObject(
				IDPerson.DEFENSE_GROUND_1);
			addDefense.setX(Position.genXFromFloat(popup_defense_1
				.getX() + Dimension.BRICK_W));
			addDefense.setY(Position.genYFromFloat(popup_defense_1
				.getY() - Dimension.BRICK_H / 2));
			list_defense_object.add(addDefense);
			gold -= Sale.GROUND_1;
			mapData[Position.genJ(addDefense.getY()
				+ Dimension.BRICK_H / 2)
				* MapData.columns
				+ Position.genI(addDefense.getX()
					+ Dimension.BRICK_W / 2)] = 5;
		    }
		}
	    } else if (!popup_defense_2.canPress()) {
		popup_defense_2.setCanPress(true);
		if (popup_defense_2.isInBound(x, y)) {
		    showPopupSelectDefense = false;
		    if (gold >= Sale.GROUND_2) {
			DefenseObject addDefense = new DefenseGroundObject(
				IDPerson.DEFENSE_GROUND_2);
			addDefense.setX(Position.genXFromFloat(popup_defense_1
				.getX() + Dimension.BRICK_W));
			addDefense.setY(Position.genYFromFloat(popup_defense_1
				.getY() - Dimension.BRICK_H / 2));
			list_defense_object.add(addDefense);
			gold -= Sale.GROUND_2;
			mapData[Position.genJ(addDefense.getY()
				+ Dimension.BRICK_H / 2)
				* MapData.columns
				+ Position.genI(addDefense.getX()
					+ Dimension.BRICK_W / 2)] = 5;
		    }
		}
	    } else if (!popup_defense_3.canPress()) {
		popup_defense_3.setCanPress(true);
		if (popup_defense_3.isInBound(x, y)) {
		    showPopupSelectDefense = false;
		    if (gold >= Sale.AIR) {
			DefenseObject addDefense = new DefenseAirObject(
				IDPerson.DEFENSE_AIR);
			addDefense.setX(Position.genXFromFloat(popup_defense_1
				.getX() + Dimension.BRICK_W));
			addDefense.setY(Position.genYFromFloat(popup_defense_1
				.getY() - Dimension.BRICK_H / 2));
			list_defense_object.add(addDefense);
			gold -= Sale.AIR;
			mapData[Position.genJ(addDefense.getY()
				+ Dimension.BRICK_H / 2)
				* MapData.columns
				+ Position.genI(addDefense.getX()
					+ Dimension.BRICK_W / 2)] = 5;
		    }
		}
	    }
	    showPopupSelectDefense = false;
	} else {
	    /* Check to show popup select new defense */
	    int i = (int) (screenX / Dimension.BRICK_W);
	    int j = (int) (screenY / Dimension.BRICK_H);
	    showPopupSelectDefense = false;
	    if (mapData[MapData.columns * j + i] == 1) {
		showPopupSelectDefense = true;
		popup_defense_1.setX(x - Dimension.BRICK_W);
		popup_defense_1.setY(y + Dimension.BRICK_H / 2);

		popup_defense_2.setX(popup_defense_1.getWidth()
			+ popup_defense_2.getWidth() + +popup_defense_1.getX());
		popup_defense_2.setY(y + Dimension.BRICK_H / 2);

		popup_defense_3.setX(x - Dimension.BRICK_W);
		popup_defense_3.setY(y - Dimension.BRICK_H * 3 / 2);
	    } else {

	    }
	}
	/* Check touch Up on all defenses */

	return super.touchUp(screenX, screenY, pointer, button);
    }
}
