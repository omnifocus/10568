package com.yovya.changeskin;

import com.yovya.Bullet;
import com.yovya.Explode;
import com.yovya.Tank;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:11 AM
 * @Description: com.yovya.changeskin
 * @version: 1.0
 */
public abstract class AbstractSkin {
    abstract public void drawExplode(Graphics g, Explode explode);

    abstract public void drawBullet(Graphics g, Bullet bullet);

    abstract public void drawTank(Graphics g, Tank tank);
}
