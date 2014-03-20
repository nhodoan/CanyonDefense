package com.game.canyondefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MySkin extends Skin {
    public MySkin(){
	super(Gdx.files.internal("MySkinPacker/uiskin.json"),
		new TextureAtlas(Gdx.files.internal("MySkinPacker/MoTa.txt")));
    }
}
