package com.yovya.firestrategy;

import com.yovya.Bullet;
import com.yovya.Direction;
import com.yovya.Tank;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:44 PM
 * @Description: com.yovya.firestrategy  make it singleton
 * @version: 1.0
 */
public class FireStrategyFourDirecionsFire implements FireStrategy {
    private FireStrategyFourDirecionsFire() {
    }

    private static FireStrategy fs = new FireStrategyFourDirecionsFire();

    public static FireStrategy getInstance() {
        return fs;
    }

    @Override
    public void fire(Tank tank) {
        int x = tank.getX() + Tank.WIDTH / 2 - Bullet.BULLETWIDTH / 2;
        int y = tank.getY() + Tank.HEIGHT / 2 - Bullet.BULLETHEIGHT / 2;
        new Bullet(x, y, Direction.UP, tank.getGroup(), tank.getTf());
        new Bullet(x, y, Direction.DOWN, tank.getGroup(), tank.getTf());
        new Bullet(x, y, Direction.LEFT, tank.getGroup(), tank.getTf());
        new Bullet(x, y, Direction.RIGHT, tank.getGroup(), tank.getTf());
        playMusic();


    }
}
