package com.game.canyondefense.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.canyondefense.global.Dimension;

public class AttackGroundObject extends AttackObject {

    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int UP = 3;
    private int pRight, pLeft, pDown, pUp;
    private TextureRegion texture;

    private int statusMove;

    public AttackGroundObject(int id) {
	super(id);
	pUp = pDown = pLeft = pRight = 0;
	texture = new TextureRegion(allTextureRegion, pDown * 40, 150, 40, 50);
	x = Dimension.BRICK_W;
	y = Gdx.graphics.getHeight() - Dimension.BRICK_H * 3 / 2;
	statusMove = DOWN;
    }

    /**
     * 
     * @param direction
     *            : 0 - right, 1 - left, 2 - down, 3 - up
     */
    public void move(float deltatime) {
	switch (statusMove) {
	case 0:
	    pRight++;
	    if (pRight == 20)
		pRight = 0;
	    texture = new TextureRegion(allTextureRegion, (pRight/5) * 40, 100, 40,
		    50);
	    x = x + speed * deltatime;
	    break;
	case 1:
	    pLeft++;
	    if (pLeft == 20)
		pLeft = 0;
	    texture = new TextureRegion(allTextureRegion, (pLeft/5) * 40, 50, 40,
		    50);
	    
	    x = x - speed * deltatime;
	    break;
	case 2:
	    pDown++;
	    if (pDown == 20)
		pDown = 0;
	    texture = new TextureRegion(allTextureRegion, (pDown/5) * 40, 0, 40,
		    50);
	    y = y - speed * deltatime;
	    break;
	case 3:
	    pUp++;
	    if (pUp == 20)
		pUp = 0;
	    texture = new TextureRegion(allTextureRegion, (pUp/5) * 40, 150, 40,
		    50);
	    
	    y = y + speed * deltatime;
	    break;
	}

    }

    public int getStatusMove() {
	return statusMove;
    }

    public void setStatusMove(int statusMove) {
	this.statusMove = statusMove;
    }

    public TextureRegion getTexture() {
	return this.texture;
    }

}
