package com.yovya.observer;

import com.yovya.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:41 AM
 * @Description: com.yovya.observer
 * @version: 1.0
 */
public class FireDown implements TankObserver {
    @Override
    public void fire(FireEvent event) {
        TankDecorator td = event.source;
        Bullet bullet = Bullet.getBullet(td.x + td.getW() / 2 - ResourceMgr.bulletU.getWidth() / 2, td.y + td.getH() / 2 - ResourceMgr.bulletU.getHeight() / 2, Direction.DOWN, Group.GOOD);
        new BulletTailDecorator(bullet);
    }
}
