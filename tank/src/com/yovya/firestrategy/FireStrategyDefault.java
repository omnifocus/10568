package com.yovya.firestrategy;

import com.yovya.Bullet;
import com.yovya.Tank;
import com.yovya.TankFrame;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:40 PM
 * @Description: com.yovya.firestrategy
 * @version: 1.0
 */
public class FireStrategyDefault implements FireStrategy {
    @Override
    public void fire(TankFrame tf, Tank tank) {
        tf.getBullets().add(new Bullet(tank.getX() + tank.getWidth() / 2 - Bullet.BULLETWIDTH / 2, tank.getY() + tank.getHeight() / 2 - Bullet.BULLETHEIGHT / 2, tank.getDir(), tank.getGroup(), tf));
    }
}
