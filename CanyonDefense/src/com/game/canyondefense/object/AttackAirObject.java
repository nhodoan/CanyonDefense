package com.game.canyondefense.object;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;

public class AttackAirObject extends AttackObject {

    private int pDown;

    public AttackAirObject(int id) {
	super(id);
	Random random = new Random();
	type = Bullet.TYPE_AIR;
	x = 0;
	y = Gdx.graphics.getHeight() - (4+random.nextInt(7)) * Dimension.BRICK_H;
	pDown = 0;
	texture = new TextureRegion(allTextureRegion, pDown * 40, 150, 40, 50);
    }

    @Override
    public void move(float deltatime) {
	this.x += deltatime * speed;
    }
}
