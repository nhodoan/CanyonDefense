package com.game.canyondefense.screen;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
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
import com.game.canyondefense.object.AttackAirObject;
import com.game.canyondefense.object.AttackGroundObject;
import com.game.canyondefense.object.AttackObject;
import com.game.canyondefense.object.Bullet;
import com.game.canyondefense.object.DefenseAirObject;
import com.game.canyondefense.object.DefenseGroundObject;
import com.game.canyondefense.object.DefenseObject;
import com.game.canyondefense.object.Fire;
import com.game.canyondefense.object.FireAttack;
import com.game.canyondefense.object.GoldAdd;
import com.game.canyondefense.utils.Collision;

public class PlayScreen extends BaseScreen implements InputProcessor {
    private final String TAG = "Play Screen";
    AtlasRegion bg;;

    public static boolean isSound = true;
    public static int map;
    public static int level;

    private AreaObject play_game, play_attack, popup_defense_ground_1,
	    popup_defense_ground_2, popup_defense_air_1, popup_defense_air_2;
    private Fire fire_power_1, fire_power_2;

    private AreaObject replay_game, back_menu, continue_game;

    private ArrayList<AttackObject> list_attack_object;
    private ArrayList<DefenseObject> list_defense_object;
    private ArrayList<Bullet> list_bullet;

    private ArrayList<ArrayList<Integer>> allData;
    private boolean isPlay = true;

    // private AttackGroundObject list_attack_object.get(i);
    private long timeStartWave;
    private boolean startWave = false;

    private Integer[] mapData;
    private String fileData, fileMap;
    private int sumAttack = 0;
    private boolean showPopupSelectDefense = false;
    private boolean select_defense = false;
    private boolean gameOver = false;
    private boolean gameWin = false;

    private int gold = 1000;
    private int heart = 20;
    private int positionSelectI, positionSelectJ;

    private int maxWave, currentWave;
    private boolean isShowNewAttack = false;

    private ArrayList<FireAttack> listfireAttack;

    // private DefenseGroundObject testDefense;
    private ArrayList<ParticleEffect> listEffect;
    private ArrayList<GoldAdd> listGoldAdd;

    private TextureRegion[] arrayTextureNumber = { ManagerRegion.number0,
	    ManagerRegion.number1, ManagerRegion.number2,
	    ManagerRegion.number3, ManagerRegion.number4,
	    ManagerRegion.number5, ManagerRegion.number6,
	    ManagerRegion.number7, ManagerRegion.number8,
	    ManagerRegion.number9, ManagerRegion.gach_xien };

    @Override
    public void show() {
	// TODO Auto-generated method stub
	super.show();
	Gdx.input.setCatchBackKey(true);
	Gdx.input.setInputProcessor(this);

	/* Init data */
	if (map == 1) {
	    fileMap = "MyData\\data\\map1.dat";
	} else if (map == 2) {
	    fileMap = "MyData\\data\\map2.dat";
	} else {
	    fileMap = "MyData\\data\\map3.dat";
	}
	if (level == 1) {
	    fileData = "MyData\\data\\game1.dat";
	} else if (level == 2) {
	    fileData = "MyData\\data\\game1.dat";
	} else {
	    fileData = "MyData\\data\\game1.dat";
	}
	list_attack_object = new ArrayList<AttackObject>();
	list_defense_object = new ArrayList<DefenseObject>();
	// list_attack_object.add(new Att)
	list_bullet = new ArrayList<Bullet>();
	allData = new ArrayList<ArrayList<Integer>>();
	listEffect = new ArrayList<ParticleEffect>();

	loadDataGame();
	loadDataMap();
	maxWave = allData.size() - 1;
	currentWave = 0;
	// list_attack_object.get(i) = new
	// AttackGroundObject(IDPerson.ATTACK_GROUND_1);
	/* Init object */

	bg = GameControl.getAtlas().findRegion("data/loading");
	/* Object control status game */
	play_game = new AreaObject(IDObject.PLAY_MENU_PLAY);

	/* Object select weakpon */
	popup_defense_ground_1 = new AreaObject(
		IDObject.PLAY_POPUP_DEFENSE_GROUND_1);
	popup_defense_ground_2 = new AreaObject(
		IDObject.PLAY_POPUP_DEFENSE_GROUND_2);
	popup_defense_air_1 = new AreaObject(IDObject.PLAY_POPUP_DEFENSE_AIR_1);
	popup_defense_air_2 = new AreaObject(IDObject.PLAY_POPUP_DEFENSE_AIR_2);
	play_attack = new AreaObject(IDObject.PLAY_ATTACK);
	fire_power_1 = new Fire(IDObject.PLAY_MENU_FIRE_1);
	fire_power_2 = new Fire(IDObject.PLAY_MENU_FIRE_2);

	listfireAttack = new ArrayList<FireAttack>();

	replay_game = new AreaObject(IDObject.REPLAY);
	back_menu = new AreaObject(IDObject.BACK_MENU);
	continue_game = new AreaObject(IDObject.CONT_GAME);

	listGoldAdd = new ArrayList<GoldAdd>();
	// for (int i = 0; i < MapData.rows; i++) {
	// for (int j = 0; j < MapData.columns; j++) {
	// System.out.print(mapData[i * MapData.columns + j]);
	// }
	// System.out.println();
	// }
    }

    private void loadDataMap() {
	mapData = new Integer[MapData.rows * MapData.columns];
	try {
	    FileHandle file = Gdx.files.internal(fileMap);
	    InputStream ips = file.read();
	    InputStreamReader ipsr = new InputStreamReader(ips);
	    BufferedReader br = new BufferedReader(ipsr);
	    String line;
	    int count = 0;
	    while ((line = br.readLine()) != null) {
		String[] splitLine = line.split(",");
		for (String x : splitLine) {
		    mapData[count] = Integer.parseInt(x);
		    count++;
		}
	    }
	    br.close();
	} catch (Exception e) {
	    System.out.println(e.toString());
	}
    }

    private void loadDataGame() {
	try {
	    FileHandle file = Gdx.files.internal(fileData);
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
	renderMap(sb);

	/**
	 * Render menu bar here
	 */

	/* Render control bar game */
	sb.draw(play_game.getTexture(), play_game.getX(), play_game.getY(),
		play_game.getWidth(), play_game.getHeight());

	renderGold(sb);
	renderWave(sb);
	renderHeart(sb);

	/**
	 * Render main play game
	 */

	/* Render defense object */

	renderDefense(sb);
	renderAttack(sb);

	/* Render bullet */
	renderBullet(sb);

	/* Render golds add */
	for (GoldAdd goldAdd : listGoldAdd) {
	    renderNumberGold(sb, goldAdd.getX(), goldAdd.getY(),
		    goldAdd.getGold());
	}

	renderPopupSelectDefense(sb);
	for (ParticleEffect particleEffect : listEffect) {
	    if (!particleEffect.isComplete()) {
		particleEffect.draw(sb, arg0);
		Gdx.app.log(TAG, "Drawing effect");
	    }

	}

	if (isShowNewAttack) {
	    sb.draw(play_attack.getTexture(), play_attack.getX(),
		    play_attack.getY(), play_attack.getWidth(),
		    play_attack.getHeight());
	}
	if (!isPlay) {
	    /* Render dialog show game is paused */
	    Color c = sb.getColor();
	    float oldAlpha = c.a;
	    c.a = oldAlpha * 0.2f;
	    sb.setColor(c);
	    sb.draw(ManagerRegion.bg_status, 0, 0, width, height);
	    c.a = oldAlpha;
	    sb.setColor(c);
	    sb.draw(ManagerRegion.pause_icon, Position.ICON_STATUS_GAME_X,
		    Position.ICON_STATUS_GAME_Y, Dimension.ICON_STATUS_GAME_W,
		    Dimension.ICON_STATUS_GAME_H);
	    sb.draw(continue_game.getTexture(), continue_game.getX(),
		    continue_game.getY(), continue_game.getWidth(),
		    continue_game.getHeight());
	    sb.draw(replay_game.getTexture(), replay_game.getX(),
		    replay_game.getY(), replay_game.getWidth(),
		    replay_game.getHeight());
	    sb.draw(back_menu.getTexture(), back_menu.getX(), back_menu.getY(),
		    back_menu.getWidth(), back_menu.getHeight());
	}
	if (gameOver) {
	    /* Draw dialog game over */
	    Color c = sb.getColor();
	    float oldAlpha = c.a;
	    c.a = oldAlpha * 0.2f;
	    sb.setColor(c);
	    sb.draw(ManagerRegion.bg_status, 0, 0, width, height);
	    c.a = oldAlpha;
	    sb.setColor(c);
	    sb.draw(ManagerRegion.lose_icon, Position.ICON_STATUS_GAME_X,
		    Position.ICON_STATUS_GAME_Y, Dimension.ICON_STATUS_GAME_W,
		    Dimension.ICON_STATUS_GAME_H);
	    sb.draw(replay_game.getTexture(), replay_game.getX(),
		    replay_game.getY(), replay_game.getWidth(),
		    replay_game.getHeight());
	    sb.draw(back_menu.getTexture(), back_menu.getX(), back_menu.getY(),
		    back_menu.getWidth(), back_menu.getHeight());
	}
	if (gameWin) {
	    /* Draw dialog game win */
	    Color c = sb.getColor();
	    float oldAlpha = c.a;
	    c.a = oldAlpha * 0.5f;
	    sb.setColor(c);
	    sb.draw(ManagerRegion.bg_status, 0, 0, width, height);
	    c.a = oldAlpha;
	    sb.setColor(c);
	    sb.draw(ManagerRegion.win_icon, Position.ICON_STATUS_GAME_X,
		    Position.ICON_STATUS_GAME_Y, Dimension.ICON_STATUS_GAME_W,
		    Dimension.ICON_STATUS_GAME_H);
	    sb.draw(replay_game.getTexture(), replay_game.getX(),
		    replay_game.getY(), replay_game.getWidth(),
		    replay_game.getHeight());
	    sb.draw(back_menu.getTexture(), back_menu.getX(), back_menu.getY(),
		    back_menu.getWidth(), back_menu.getHeight());
	}

	sb.end();

	stage.draw();
	update(arg0);
    }

    public void renderBullet(SpriteBatch sb) {
	for (Bullet bullet : list_bullet) {
	    sb.draw(bullet.getTexture(), bullet.getX(), bullet.getY(),
		    bullet.getWidth(), bullet.getHeight());
	}
	sb.draw(fire_power_1.getTexture(), fire_power_1.getX() - 10,
		fire_power_1.getY(), fire_power_1.getWidth(),
		fire_power_1.getHeight());
	sb.draw(fire_power_2.getTexture(), fire_power_2.getX(),
		fire_power_2.getY(), fire_power_2.getWidth(),
		fire_power_2.getHeight());
    }

    public void renderNumberGold(SpriteBatch sb, float x, float y, int number) {
	int countNumber = 0;
	if (number > 0) {
	    countNumber = 1 + (int) Math.log10(number);
	}
	sb.draw(ManagerRegion.plus, x, y, Dimension.MENU_TEXT_W * 2 / 3,
		Dimension.MENU_TEXT_H * 2 / 3);
	x += Dimension.MENU_TEXT_W * 2 / 3;
	for (int i = 0; i < countNumber; i++) {
	    int numberDraw = number / ((int) Math.pow(10, countNumber - i - 1));
	    /* Draw number here */
	    sb.draw(arrayTextureNumber[numberDraw], x, y,
		    Dimension.MENU_TEXT_W * 2 / 3,
		    Dimension.MENU_TEXT_H * 2 / 3);
	    x += Dimension.MENU_TEXT_W * 2 / 3;
	    number = number - numberDraw
		    * (int) Math.pow(10, countNumber - i - 1);
	}
    }

    public void renderDefense(SpriteBatch sb) {
	select_defense = false;
	for (DefenseObject defenseObject : list_defense_object) {
	    sb.draw(defenseObject.getTexture(), defenseObject.getX(),
		    defenseObject.getY(), defenseObject.getWidth(),
		    defenseObject.getHeight());

	    if (defenseObject.isPress()) {
		select_defense = true;
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
	if (!select_defense) {

	}
    }

    public void renderAttack(SpriteBatch sb) {
	for (int i = 0; i < list_attack_object.size(); i++) {
	    sb.draw(list_attack_object.get(i).getTexture(), list_attack_object
		    .get(i).getX(), list_attack_object.get(i).getY(),
		    list_attack_object.get(i).getWidth(), list_attack_object
			    .get(i).getHeight());
	    sb.draw(ManagerRegion.frame_blood, list_attack_object.get(i).getX()
		    + Dimension.ATTACK_W / 5, list_attack_object.get(i).getY()
		    + Dimension.ATTACK_H, Dimension.ATTACK_W,
		    Dimension.ATTACK_H / 10);
	    sb.draw(ManagerRegion.blood, list_attack_object.get(i).getX()
		    + Dimension.ATTACK_W / 5, list_attack_object.get(i).getY()
		    + Dimension.ATTACK_H, Dimension.ATTACK_W
		    * list_attack_object.get(i).getBlood()
		    / list_attack_object.get(i).getMax_blood(),
		    Dimension.ATTACK_H / 10);
	}
    }

    public void renderMap(SpriteBatch sb) {
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
		    if (showPopupSelectDefense && j == positionSelectI
			    && i == positionSelectJ) {
			Color c = sb.getColor();
			float oldAlpha = c.a;
			c.a = oldAlpha * 1.1f;
			sb.setColor(c);

			sb.draw(ManagerRegion.ground, j * Dimension.BRICK_W,
				height - (i + 1) * Dimension.BRICK_H,
				Dimension.BRICK_W, Dimension.BRICK_H);
			c.a = oldAlpha;
			sb.setColor(c);
		    } else {
			sb.draw(ManagerRegion.ground, j * Dimension.BRICK_W,
				height - (i + 1) * Dimension.BRICK_H,
				Dimension.BRICK_W, Dimension.BRICK_H);
		    }
		}
	    }
	}
    }

    public void renderGold(SpriteBatch sb) {
	sb.draw(ManagerRegion.gold_frame, Position.MENU_GOLD_FRAME_X,
		Position.MENU_GOLD_FRAME_Y, Dimension.MENU_GOLD_FRAME_W,
		Dimension.MENU_GOLD_FRAME_H);
	int countNumber = 1;
	if (gold > 0) {
	    countNumber = 1 + (int) Math.log10(gold);
	}
	int tempGold = gold;
	float xDraw = Position.MENU_GOLD_TEXT_X_START;
	for (int i = 0; i < countNumber; i++) {
	    int numberDraw = tempGold
		    / ((int) Math.pow(10, countNumber - i - 1));
	    /* Draw number here */
	    sb.draw(arrayTextureNumber[numberDraw], xDraw,
		    Position.MENU_TEXT_Y, Dimension.MENU_TEXT_W,
		    Dimension.MENU_TEXT_H);
	    xDraw += Dimension.MENU_TEXT_W;
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
	sb.draw(arrayTextureNumber[firstCurrentWave], xDraw,
		Position.MENU_TEXT_Y, Dimension.MENU_TEXT_W,
		Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	int secondCurrentWave = currentWave % 10;
	sb.draw(arrayTextureNumber[secondCurrentWave], xDraw,
		Position.MENU_TEXT_Y, Dimension.MENU_TEXT_W,
		Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	sb.draw(arrayTextureNumber[10], xDraw, Position.MENU_TEXT_Y,
		Dimension.MENU_TEXT_W, Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	int firstMaxWave = maxWave / 10;
	sb.draw(arrayTextureNumber[firstMaxWave], xDraw, Position.MENU_TEXT_Y,
		Dimension.MENU_TEXT_W, Dimension.MENU_TEXT_H);
	xDraw += Dimension.MENU_TEXT_W;

	int secondMaxWave = maxWave % 10;
	sb.draw(arrayTextureNumber[secondMaxWave], xDraw, Position.MENU_TEXT_Y,
		Dimension.MENU_TEXT_W, Dimension.MENU_TEXT_H);

    }

    public void renderHeart(SpriteBatch sb) {
	sb.draw(ManagerRegion.heart_frame, Position.MENU_HEART_FRAME_X,
		Position.MENU_HEART_FRAME_Y, Dimension.MENU_HEART_FRAME_W,
		Dimension.MENU_HEART_FRAME_H);

	if (heart >= 0) {
	    float xDraw = Position.MENU_HEART_TEXT_X_START;
	    int firstHeart = heart / 10;
	    sb.draw(arrayTextureNumber[firstHeart], xDraw,
		    Position.MENU_TEXT_HEART_Y, Dimension.MENU_TEXT_W,
		    Dimension.MENU_TEXT_H);
	    xDraw += Dimension.MENU_TEXT_W;
	    int secondHeart = heart % 10;
	    sb.draw(arrayTextureNumber[secondHeart], xDraw,
		    Position.MENU_TEXT_HEART_Y, Dimension.MENU_TEXT_W,
		    Dimension.MENU_TEXT_H);
	}
    }

    public void renderPopupSelectDefense(SpriteBatch sb) {
	if (showPopupSelectDefense) {
	    sb.draw(ManagerRegion.circle_select, popup_defense_ground_1.getX()
		    + Dimension.BRICK_W - Dimension.PLAY_MENU_CIRCLE_SELECT_W
		    / 2, popup_defense_ground_1.getY() - Dimension.BRICK_H / 2
		    - Dimension.PLAY_MENU_CIRCLE_SELECT_H / 2,
		    Dimension.PLAY_MENU_CIRCLE_SELECT_W,
		    Dimension.PLAY_MENU_CIRCLE_SELECT_H);
	    sb.draw(popup_defense_ground_1.getTexture(),
		    popup_defense_ground_1.getX(),
		    popup_defense_ground_1.getY(),
		    popup_defense_ground_1.getWidth(),
		    popup_defense_ground_1.getHeight());
	    sb.draw(popup_defense_ground_2.getTexture(),
		    popup_defense_ground_2.getX(),
		    popup_defense_ground_2.getY(),
		    popup_defense_ground_2.getWidth(),
		    popup_defense_ground_2.getHeight());
	    sb.draw(popup_defense_air_1.getTexture(),
		    popup_defense_air_1.getX(), popup_defense_air_1.getY(),
		    popup_defense_air_1.getWidth(),
		    popup_defense_air_1.getHeight());
	    sb.draw(popup_defense_air_2.getTexture(),
		    popup_defense_air_2.getX(), popup_defense_air_2.getY(),
		    popup_defense_air_2.getWidth(),
		    popup_defense_air_2.getHeight());
	}
    }

    private void update(float time) {

	if (isPlay && !gameOver && !gameWin) {

	    // Control move of attack

	    if (System.currentTimeMillis() - timeStartWave > sumAttack * 1000
		    && (currentWave <= maxWave)) {
		if (sumList(allData.get(currentWave)) > 0) {
		    if (allData.get(currentWave).get(0) > 0) {

			Gdx.app.log("Added attack",
				String.valueOf(System.currentTimeMillis()));
			list_attack_object.add(new AttackGroundObject(
				IDPerson.ATTACK_GROUND_1));
			allData.get(currentWave).set(0,
				allData.get(currentWave).get(0) - 1);
		    } else if (allData.get(currentWave).get(1) > 0) {
			list_attack_object.add(new AttackGroundObject(
				IDPerson.ATTACK_GROUND_2));
			allData.get(currentWave).set(1,
				allData.get(currentWave).get(1) - 1);
		    } else if (allData.get(currentWave).get(2) > 0) {
			list_attack_object.add(new AttackAirObject(
				IDPerson.ATTACK_AIR_1));
			allData.get(currentWave).set(2,
				allData.get(currentWave).get(2) - 1);
		    } else {
			list_attack_object.add(new AttackAirObject(
				IDPerson.ATTACK_AIR_2));
			allData.get(currentWave).set(3,
				allData.get(currentWave).get(3) - 1);
		    }
		    sumAttack++;

		} else {

		    if (list_attack_object.size() == 0) {
			if (currentWave == maxWave) {
			    gameWin = true;
			    GameControl.androidInterface.soundWin();
			    Gdx.app.log(TAG, "Game Win");
			} else {
			    isShowNewAttack = true;
			}
		    }
		    // currentWave++;
		    // if (currentWave < maxWave) {
		    // startWave = true;
		    // }
		}

	    }

	    if (startWave) {
		sumAttack = 0;
		startWave = false;
	    }
	    for (Iterator<AttackObject> it = list_attack_object.iterator(); it
		    .hasNext();) {
		AttackObject attackObject = it.next();
		int currentI = (int) (attackObject.getX() * 2 / Dimension.BRICK_W);
		int currentJ = (int) (attackObject.getY() * 2 / Dimension.BRICK_H);
		if (currentI == MapData.columns * 2 - 2) {
		    it.remove();
		    heart--;
		    GameControl.androidInterface.soundHeartDie();
		    Gdx.app.log(TAG, "End route");
		    if (heart < 0) {
			gameOver = true;
			GameControl.androidInterface.soundLose();
			Gdx.app.log(TAG, "Game Over");
		    }

		    continue;
		}
		if (attackObject.getId() != IDPerson.ATTACK_AIR_1
			&& attackObject.getId() != IDPerson.ATTACK_AIR_2) {

		    boolean checkDirection = false;
		    if (currentJ % 2 == 0) {
			if (attackObject.getStatusMove() == AttackGroundObject.DOWN) {
			    checkDirection = true;
			}
		    } else {
			if (attackObject.getStatusMove() == AttackGroundObject.UP) {
			    checkDirection = true;
			}
		    }

		    if (currentI % 2 == 0) {
			if (attackObject.getStatusMove() == AttackGroundObject.RIGHT) {
			    checkDirection = true;
			}
		    } else {
			if (attackObject.getStatusMove() == AttackGroundObject.LEFT) {
			    checkDirection = true;
			}
		    }

		    currentI = currentI / 2;
		    currentJ = MapData.rows - 1 - currentJ / 2;

		    if (checkDirection) {

			if (attackObject.getStatusMove() == AttackGroundObject.DOWN) {
			    if (mapData[currentI + (currentJ + 1)
				    * MapData.columns] != 0) {
				if (mapData[currentI + 1 + currentJ
					* MapData.columns] == 0) {
				    attackObject
					    .setStatusMove(AttackGroundObject.RIGHT);
				    attackObject
					    .setY((MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				} else {
				    attackObject
					    .setStatusMove(AttackGroundObject.LEFT);
				    attackObject
					    .setY((MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				}
			    }

			} else if (attackObject.getStatusMove() == AttackGroundObject.UP) {
			    if (mapData[currentI + (currentJ - 1)
				    * MapData.columns] != 0) {
				if (mapData[currentI + 1 + currentJ
					* MapData.columns] == 0) {
				    attackObject
					    .setStatusMove(AttackGroundObject.RIGHT);
				    attackObject
					    .setY((MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				} else {
				    attackObject
					    .setStatusMove(AttackGroundObject.LEFT);
				    attackObject
					    .setY((MapData.rows - 1 - currentJ)
						    * Dimension.BRICK_H);
				    ;
				}
			    }
			} else if (attackObject.getStatusMove() == AttackGroundObject.RIGHT) {
			    if (mapData[currentI + 1 + currentJ
				    * MapData.columns] != 0) {
				if (mapData[currentI + (currentJ + 1)
					* MapData.columns] == 0) {
				    attackObject
					    .setStatusMove(AttackGroundObject.DOWN);
				    attackObject.setX(currentI
					    * Dimension.BRICK_W);
				    ;
				} else {
				    attackObject.setX(currentI
					    * Dimension.BRICK_W);
				    ;
				    attackObject
					    .setStatusMove(AttackGroundObject.UP);
				}
			    }
			} else if (attackObject.getStatusMove() == AttackGroundObject.LEFT) {
			    if (mapData[currentI - 1 + currentJ
				    * MapData.columns] != 0) {
				if (mapData[currentI + (currentJ + 1)
					* MapData.columns] == 0) {
				    attackObject
					    .setStatusMove(AttackGroundObject.DOWN);
				    attackObject.setX(currentI
					    * Dimension.BRICK_W);
				    ;
				} else {
				    attackObject
					    .setStatusMove(AttackGroundObject.UP);
				    attackObject.setX(currentI
					    * Dimension.BRICK_W);
				    ;
				}
			    }
			}
		    }
		}

		attackObject.move(time);
	    }

	    /* End control move of attacks */

	    /* Control defense attack */
	    for (DefenseObject defenseObject : list_defense_object) {
		if (System.currentTimeMillis() - defenseObject.getTimeOldFire() > 1000) {
		    for (AttackObject attackObject : list_attack_object) {
			if (defenseObject.getType() == attackObject.getType()) {

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
				bullet.setType(defenseObject.getType());
				bullet.setPower(defenseObject.getPower());
				list_bullet.add(bullet);
				break;

			    }

			}
		    }
		}
	    }

	    for (Iterator<FireAttack> it = listfireAttack.iterator(); it
		    .hasNext();) {
		FireAttack fireAttack = it.next();
		for (AttackObject attackObject : list_attack_object) {
		    if (fireAttack.isAttacked(attackObject)) {
			attackObject.attack(fireAttack.getPower());

			Gdx.app.log(TAG, "Attacking fire");
		    }
		}

		it.remove();
	    }
	    /* Check collision */
	    for (AttackObject attackObject : list_attack_object) {

		for (Iterator<Bullet> it = list_bullet.iterator(); it.hasNext();) {
		    Bullet bullet = it.next();
		    if (Collision.isCollision(attackObject, bullet)
			    && !attackObject.isDead()
			    && bullet.getType() == attackObject.getType()) {
			GameControl.androidInterface.soundDefense();
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

	    /* Control animation golds add */
	    for (Iterator<GoldAdd> it = listGoldAdd.iterator(); it.hasNext();) {
		GoldAdd goldAdd = it.next();
		if (goldAdd.getY() > Position.MENU_GOLD_FRAME_Y) {
		    it.remove();
		} else {
		    goldAdd.move();
		}
	    }

	    /* Check attack object */

	    for (Iterator<AttackObject> it = list_attack_object.iterator(); it
		    .hasNext();) {
		AttackObject attackObject = it.next();
		if (attackObject.isDead()) {
		    it.remove();
		    gold += attackObject.getGold();
		    listGoldAdd.add(new GoldAdd(attackObject.getGold()));
		}
	    }

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

	if (gameWin || gameOver || !isPlay) {
	    if (replay_game.isInBound(x, y)) {
		replay_game.setCanPress(false);
		return true;
	    } else if (back_menu.isInBound(x, y)) {

		back_menu.setCanPress(false);
		return true;
	    } else if (continue_game.isInBound(x, y) && !isPlay) {
		continue_game.setCanPress(false);
		return true;
	    }
	} else {
	    if (play_game.isInBound(x, y)) {
		play_game.setCanPress(false);
		return true;
	    }

	    for (DefenseObject defenseObject : list_defense_object) {

		defenseObject.setPress(false);

	    }

	    for (int i = 0; i < list_defense_object.size(); i++) {
		DefenseObject defenseObject = list_defense_object.get(i);
		if (defenseObject.isInBound(x, y)) {
		    defenseObject.setPress(true);
		    return true;
		}
	    }

	    if (fire_power_1.isSelect()) {
		if (fire_power_1.isInBound(x, y)) {
		    fire_power_1.setSelect(false);
		}
		return true;
	    } else if (fire_power_2.isSelect()) {
		if (fire_power_2.isInBound(x, y)) {
		    fire_power_2.setSelect(false);
		}
		return true;
	    } else {

	    }

	    if (isShowNewAttack) {
		if (play_attack.isInBound(x, y)) {
		    play_attack.setCanPress(false);
		}
	    }
	    if (showPopupSelectDefense) {
		if (popup_defense_ground_1.isInBound(x, y)) {
		    popup_defense_ground_1.setCanPress(false);
		    return true;
		} else if (popup_defense_ground_2.isInBound(x, y)) {
		    popup_defense_ground_2.setCanPress(false);
		    return true;
		} else if (popup_defense_air_1.isInBound(x, y)) {
		    popup_defense_air_1.setCanPress(false);
		    return true;
		} else if (popup_defense_air_2.isInBound(x, y)) {
		    popup_defense_air_2.setCanPress(false);
		    return true;
		}
	    }
	    // fire_power_1.setSelect(false);
	    // fire_power_2.setSelect(false);
	    if (fire_power_1.isInBound(x, y)) {
		fire_power_1.setCanPress(false);
	    } else if (fire_power_2.isInBound(x, y)) {
		fire_power_2.setCanPress(false);
	    }

	}

	return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	float x = screenX;
	float y = height - screenY;

	if (gameWin || gameOver || !isPlay) {

	    if (!replay_game.canPress() && replay_game.isInBound(x, y)) {
		GameControl.getManagerScreen().creatScreen(
			ManagerScreen.SCREEN_PLAY);
	    } else if (!back_menu.canPress() && back_menu.isInBound(x, y)) {
		GameControl.getManagerScreen().creatScreen(
			ManagerScreen.SCREEN_START);
	    } else if (!continue_game.canPress()
		    && continue_game.isInBound(x, y)) {
		isPlay = true;
	    }
	    continue_game.setCanPress(true);
	    replay_game.setCanPress(true);
	    back_menu.setCanPress(true);
	    return true;

	} else {
	    if (!play_game.canPress()) {
		play_game.setCanPress(true);
		if (play_game.isInBound(x, y)) {
		    isPlay = !isPlay;
		    return true;
		}
	    }
	    if (fire_power_1.isSelect()) {
		fire_power_1.setSelect(false);
		if (gold >= Sale.FIRE_1) {
		    FireAttack fireAttack = new FireAttack(IDPerson.FIRE_1);
		    fireAttack.setX(x);
		    fireAttack.setY(y);
		    listfireAttack.add(fireAttack);
		    ParticleEffect p = new ParticleEffect();
		    p.load(Gdx.files
			    .internal("MyData\\playscreen\\bullet\\effect.p"),
			    Gdx.files.internal("MyData\\playscreen\\bullet"));
		    p.setPosition(x, y);
		    p.start();

		    listEffect.add(p);
		    // p.findEmitter("smoke").setContinuous(true);
		    gold -= Sale.FIRE_1;
		    GameControl.androidInterface.soundFire();
		    Gdx.app.log(TAG, "Fire !!!! ");
		} else {
		    Gdx.app.log(TAG, "Not enough money");
		}

		return true;
	    } else if (fire_power_2.isSelect()) {
		fire_power_2.setSelect(false);
		if (gold >= Sale.FIRE_2) {
		    FireAttack fireAttack = new FireAttack(IDPerson.FIRE_2);
		    fireAttack.setX(x);
		    fireAttack.setY(y);
		    listfireAttack.add(fireAttack);
		    ParticleEffect p = new ParticleEffect();
		    p.load(Gdx.files
			    .internal("MyData\\playscreen\\bullet\\effect2.p"),
			    Gdx.files.internal("MyData\\playscreen\\bullet"));
		    p.setPosition(x, y);
		    p.start();

		    listEffect.add(p);
		    gold -= Sale.FIRE_2;
		    GameControl.androidInterface.soundFire();
		    Gdx.app.log(
			    TAG,
			    "Fire !!!! : Number = "
				    + String.valueOf(listfireAttack.size()));
		} else {
		    Gdx.app.log(TAG, "Not enough money");
		}
		return true;
	    }
	    if (isShowNewAttack && !play_attack.canPress()
		    && play_attack.isInBound(x, y)) {
		currentWave++;
		play_attack.setCanPress(true);
		if (currentWave <= maxWave) {
		    startWave = true;
		    isShowNewAttack = false;
		    GameControl.androidInterface.soundStartWave();
		    timeStartWave = System.currentTimeMillis();
		}
	    }
	    if (showPopupSelectDefense) {
		if (!popup_defense_ground_1.canPress()) {
		    popup_defense_ground_1.setCanPress(true);
		    if (popup_defense_ground_1.isInBound(x, y)) {
			Gdx.app.log("Add defense", "Added");
			showPopupSelectDefense = false;
			if (gold >= Sale.GROUND_1) {
			    DefenseObject addDefense = new DefenseGroundObject(
				    IDPerson.DEFENSE_GROUND_1);
			    addDefense.setX(Position
				    .genXFromFloat(popup_defense_ground_1
					    .getX() + Dimension.BRICK_W));
			    addDefense.setY(Position
				    .genYFromFloat(popup_defense_ground_1
					    .getY() - Dimension.BRICK_H / 2));
			    addDefense.setPress(true);
			    list_defense_object.add(addDefense);
			    gold -= Sale.GROUND_1;
			    mapData[Position.genJ(addDefense.getY()
				    + Dimension.BRICK_H / 2)
				    * MapData.columns
				    + Position.genI(addDefense.getX()
					    + Dimension.BRICK_W / 2)] = 5;
			}
		    }
		} else if (!popup_defense_ground_2.canPress()) {
		    popup_defense_ground_2.setCanPress(true);
		    if (popup_defense_ground_2.isInBound(x, y)) {
			showPopupSelectDefense = false;
			if (gold >= Sale.GROUND_2) {
			    DefenseObject addDefense = new DefenseGroundObject(
				    IDPerson.DEFENSE_GROUND_2);
			    addDefense.setX(Position
				    .genXFromFloat(popup_defense_ground_1
					    .getX() + Dimension.BRICK_W));
			    addDefense.setY(Position
				    .genYFromFloat(popup_defense_ground_1
					    .getY() - Dimension.BRICK_H / 2));
			    addDefense.setPress(true);
			    list_defense_object.add(addDefense);
			    gold -= Sale.GROUND_2;
			    mapData[Position.genJ(addDefense.getY()
				    + Dimension.BRICK_H / 2)
				    * MapData.columns
				    + Position.genI(addDefense.getX()
					    + Dimension.BRICK_W / 2)] = 5;
			}
		    }
		} else if (!popup_defense_air_1.canPress()) {
		    popup_defense_air_1.setCanPress(true);
		    if (popup_defense_air_1.isInBound(x, y)) {
			showPopupSelectDefense = false;
			if (gold >= Sale.AIR_1) {
			    DefenseObject addDefense = new DefenseAirObject(
				    IDPerson.DEFENSE_AIR_1);
			    addDefense.setX(Position
				    .genXFromFloat(popup_defense_ground_1
					    .getX() + Dimension.BRICK_W));
			    addDefense.setY(Position
				    .genYFromFloat(popup_defense_ground_1
					    .getY() - Dimension.BRICK_H / 2));
			    addDefense.setPress(true);
			    list_defense_object.add(addDefense);
			    gold -= Sale.AIR_1;
			    mapData[Position.genJ(addDefense.getY()
				    + Dimension.BRICK_H / 2)
				    * MapData.columns
				    + Position.genI(addDefense.getX()
					    + Dimension.BRICK_W / 2)] = 5;
			}
		    }
		} else if (!popup_defense_air_2.canPress()) {
		    popup_defense_air_2.setCanPress(true);
		    if (popup_defense_air_2.isInBound(x, y)) {
			showPopupSelectDefense = false;
			if (gold >= Sale.AIR_2) {
			    DefenseObject addDefense = new DefenseAirObject(
				    IDPerson.DEFENSE_AIR_2);
			    addDefense.setX(Position
				    .genXFromFloat(popup_defense_ground_1
					    .getX() + Dimension.BRICK_W));
			    addDefense.setY(Position
				    .genYFromFloat(popup_defense_ground_1
					    .getY() - Dimension.BRICK_H / 2));
			    addDefense.setPress(true);
			    list_defense_object.add(addDefense);
			    gold -= Sale.AIR_2;
			    mapData[Position.genJ(addDefense.getY()
				    + Dimension.BRICK_H / 2)
				    * MapData.columns
				    + Position.genI(addDefense.getX()
					    + Dimension.BRICK_W / 2)] = 5;
			}
		    }
		}
		showPopupSelectDefense = false;
	    } else if (fire_power_1.isInBound(x, y) && !fire_power_1.canPress()) {
		fire_power_1.setCanPress(true);
		fire_power_1.setSelect(true);
	    } else if (fire_power_2.isInBound(x, y) && !fire_power_2.canPress()) {
		fire_power_2.setCanPress(true);
		fire_power_2.setSelect(true);
	    } else {
		/* Check to show popup select new defense */
		int i = (int) (screenX / Dimension.BRICK_W);
		int j = (int) (screenY / Dimension.BRICK_H);
		positionSelectI = i;
		positionSelectJ = j;
		showPopupSelectDefense = false;
		if (mapData[MapData.columns * j + i] == 1) {
		    showPopupSelectDefense = true;
		    GameControl.androidInterface.soundShowPopup();
		    popup_defense_ground_1.setX(x - Dimension.BRICK_W);
		    popup_defense_ground_1.setY(y + Dimension.BRICK_H / 2);

		    popup_defense_ground_2.setX(popup_defense_ground_1
			    .getWidth()
			    + popup_defense_ground_2.getWidth()
			    + +popup_defense_ground_1.getX());
		    popup_defense_ground_2.setY(y + Dimension.BRICK_H / 2);

		    popup_defense_air_1.setX(x - Dimension.BRICK_W);
		    popup_defense_air_1.setY(y - Dimension.BRICK_H * 3 / 2);

		    popup_defense_air_2.setX(popup_defense_ground_1.getWidth()
			    + popup_defense_ground_2.getWidth()
			    + +popup_defense_ground_1.getX());
		    popup_defense_air_2.setY(y - Dimension.BRICK_H * 3 / 2);
		} else {

		}
	    }
	}
	/* Check touch Up on all defenses */

	return true;
    }

    @Override
    public boolean keyDown(int keycode) {
	// TODO Auto-generated method stub
	if (keycode == Keys.BACK) {
	    if (isPlay) {
		isPlay = false;
	    }
	}
	return super.keyDown(keycode);
    }

    @Override
    public void pause() {
	// TODO Auto-generated method stub
	super.pause();
    }

    @Override
    public void resume() {
	// TODO Auto-generated method stub
	super.resume();
    }

    // @Override
    // public void dispose() {
    // // TODO Auto-generated method stub
    // super.dispose();
    //
    // list_defense_object.clear();
    // Gdx.app.log(TAG,
    // "-----------------------Disposcreen========================");
    // }

}
