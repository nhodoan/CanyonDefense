package com.game.canyondefense.utils;

import com.game.canyondefense.object.AttackObject;
import com.game.canyondefense.object.Bullet;

public class Collision {
	public static boolean isCollision(AttackObject attackObject, Bullet bullet) {
		if (isInBound(bullet.getX(), bullet.getY(), attackObject)
				|| isInBound(bullet.getX(), bullet.getY() + bullet.getHeight(),
						attackObject)
				|| isInBound(bullet.getX() + bullet.getWidth(), bullet.getY(),
						attackObject)
				|| isInBound(bullet.getX() + bullet.getWidth(), bullet.getY()
						+ bullet.getHeight(), attackObject)) {
			return true;
		}
		return false;
	}

	public static boolean isInBound(float x, float y, AttackObject r) {

		if (r.getX() < x && x < r.getX() + r.getWidth() && r.getY() < y
				&& y < r.getY() + r.getHeight()) {
			return true;
		}
		return false;
	}

}
