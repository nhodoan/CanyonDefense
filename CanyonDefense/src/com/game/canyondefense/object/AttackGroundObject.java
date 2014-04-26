package com.game.canyondefense.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;

public class AttackGroundObject extends AttackObject {

    private int pRight, pLeft, pDown, pUp;

    public AttackGroundObject(int id) {
	super(id);
	type = Bullet.TYPE_GROUND;
	pUp = pDown = pLeft = pRight = 0;
	texture = new TextureRegion(allTextureRegion, pDown * 40, 150, 40, 50);
	x = - Dimension.BRICK_W;
	y = Gdx.graphics.getHeight() - 4 * Dimension.BRICK_H;

    }

    /**
     * 
     * @param direction
     *            : 0 - right, 1 - left, 2 - down, 3 - up
     */
    @Override
    public void move(float deltatime) {
	switch (statusMove) {
	case 0:
	    pRight++;
	    if (pRight == 20)
		pRight = 0;
	    texture = new TextureRegion(allTextureRegion, (pRight / 5) * 40,
		    100, 40, 50);
	    x = x + speed * deltatime;
	    break;
	case 1:
	    pLeft++;
	    if (pLeft == 20)
		pLeft = 0;
	    texture = new TextureRegion(allTextureRegion, (pLeft / 5) * 40, 50,
		    40, 50);

	    x = x - speed * deltatime;
	    break;
	case 2:
	    pDown++;
	    if (pDown == 20)
		pDown = 0;
	    texture = new TextureRegion(allTextureRegion, (pDown / 5) * 40, 0,
		    40, 50);
	    y = y - speed * deltatime;
	    break;
	case 3:
	    pUp++;
	    if (pUp == 20)
		pUp = 0;
	    texture = new TextureRegion(allTextureRegion, (pUp / 5) * 40, 150,
		    40, 50);

	    y = y + speed * deltatime;
	    break;
	}

    }

}
