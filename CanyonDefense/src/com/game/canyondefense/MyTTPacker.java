package com.game.canyondefense;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class MyTTPacker {
    public static void main(String[] args) {
	Settings tt = new Settings();
	tt.maxWidth = 2048;
	tt.maxHeight = 2048;
	
	TexturePacker2.process(tt, "../CanyonDefense-android/assets/MyData/",
		"../CanyonDefense-android/assets/MyDataPacker/", "MoTa.pack");
	
	TexturePacker2.process(tt, "../CanyonDefense-android/assets/data/",
		"../CanyonDefense-android/assets/LoadingPacker/", "Loading.pack");

	TexturePacker2.process(tt, "../CanyonDefense-android/assets/MySkin/",
		"../CanyonDefense-android/assets/MySkinPacker/", "MoTa.txt");
	
    }
}