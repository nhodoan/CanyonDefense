package com.game.canyondefense.object;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;

public class AttackAirObject extends AttackObject {

    private int pDown;

    public AttackAirObject(int id) {
	super(id);
	x = Dimension.BRICK_W * 4;
	pDown = 0;
	texture = new TextureRegion(allTextureRegion, pDown * 40, 150, 40, 50);
    }

    @Override
    public void move(float deltatime) {
	this.y -= deltatime * speed;
    }
}
