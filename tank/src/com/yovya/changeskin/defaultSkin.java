package com.yovya.changeskin;

import com.yovya.Bullet;
import com.yovya.Explode;
import com.yovya.Tank;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:27 AM
 * @Description: com.yovya.changeskin
 * @version: 1.0
 */
public class defaultSkin extends AbstractSkin {


    @Override
    public void drawExplode(Graphics g, Explode explode) {
        g.drawImage(explode.getExplodeImage(), explode.getX(), explode.getY(), null);
    }

    @Override
    public void drawBullet(Graphics g, Bullet bullet) {
        g.drawImage(bullet.getBulletImage(), bullet.getX(), bullet.getY(), null);

    }

    @Override
    public void drawTank(Graphics g, Tank tank) {
        g.drawImage(tank.getTankImage(), tank.getX(), tank.getY(), null);
    }


}
