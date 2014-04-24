package com.game.canyondefense.anim;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationMove {
    private TextureRegion allTexture;
    private int maxAnimation;
    private int position;
    private int width, height;

    public AnimationMove(TextureRegion allTexure, int maxAnimation) {
	this.maxAnimation = maxAnimation;
	this.position = 0;
	this.allTexture = allTexure;
	this.width = allTexure.getRegionWidth() / maxAnimation;
	this.height = allTexure.getRegionHeight();
//	Gdx.app.log("WIDTH", String.valueOf(width));
//	Gdx.app.log("HEIGHT", String.valueOf(height));
    }

    public TextureRegion getTexture() {
	position++;
	if (position >= 20 * maxAnimation) {
	    position = 0;
	}
	return new TextureRegion(allTexture, width * ((int) position / 20), 0,
		width, height);

    }

    public boolean endPosition() {
	return position == (maxAnimation - 1) * 20;
    }

}
