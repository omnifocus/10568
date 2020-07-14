package com.yovya.observer;

import com.yovya.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:41 AM
 * @Description: com.yovya.observer
 * @version: 1.0
 */
public class FireLeft implements TankObserver {
    @Override
    public void fire(FireEvent event) {
        TankDecorator td = event.source;
        new BulletTailDecorator(new Bullet(td.x + td.getW() / 2 - ResourceMgr.bulletU.getWidth() / 2, td.y + td.getH() / 2 - ResourceMgr.bulletU.getHeight() / 2, Direction.LEFT, Group.GOOD));
    }
}
