package com.yovya.firestrategy;

import com.yovya.Bullet;
import com.yovya.Direction;
import com.yovya.Tank;
import com.yovya.TankFrame;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:44 PM
 * @Description: com.yovya.firestrategy
 * @version: 1.0
 */
public class FireStrategyFourDirecionsFire implements FireStrategy {
    @Override
    public void fire(TankFrame tf, Tank tank) {
        int x = tank.getX() + tank.getWidth() / 2 - Bullet.BULLETWIDTH / 2;
        int y = tank.getY() + tank.getHeight() / 2 - Bullet.BULLETHEIGHT / 2;
        tf.getBullets().add(new Bullet(x, y, Direction.UP, tank.getGroup(), tf));
        tf.getBullets().add(new Bullet(x, y, Direction.DOWN, tank.getGroup(), tf));
        tf.getBullets().add(new Bullet(x, y, Direction.LEFT, tank.getGroup(), tf));
        tf.getBullets().add(new Bullet(x, y, Direction.RIGHT, tank.getGroup(), tf));


    }
}
