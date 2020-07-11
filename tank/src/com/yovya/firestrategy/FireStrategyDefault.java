package com.yovya.firestrategy;

import com.yovya.Bullet;
import com.yovya.Tank;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:40 PM
 * @Description: com.yovya.firestrategy  make it singleton
 * @version: 1.0
 */
public class FireStrategyDefault implements FireStrategy {
    private static FireStrategy fs = new FireStrategyDefault();

    public static FireStrategy getInstance() {
        return fs;
    }

    private FireStrategyDefault() {
    }

    @Override
    public void fire(Tank tank) {
        new Bullet(tank.getX() + Tank.WIDTH / 2 - Bullet.BULLETWIDTH / 2, tank.getY() + Tank.HEIGHT / 2 - Bullet.BULLETHEIGHT / 2, tank.getDir(), tank.getGroup(), tank.getTf());
        playMusic();
    }
}
