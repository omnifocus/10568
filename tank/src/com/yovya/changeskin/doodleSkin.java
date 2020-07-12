package com.yovya.changeskin;

import com.yovya.Bullet;
import com.yovya.Explode;
import com.yovya.Tank;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 8:09 AM
 * @Description: com.yovya.changeskin
 * @version: 1.0
 */
public class doodleSkin extends AbstractSkin {
    @Override
    public void drawExplode(Graphics g, Explode explode) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawOval(explode.getX(), explode.getY(), Explode.EXPLODEWIDTH, Explode.EXPLODEHEIGHT);
        g.setColor(c);
    }

    @Override
    public void drawBullet(Graphics g, Bullet bullet) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(bullet.getX(), bullet.getY(), Bullet.BULLETWIDTH, Bullet.BULLETHEIGHT);
        g.setColor(c);
    }

    @Override
    public void drawTank(Graphics g, Tank tank) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        g.setColor(c);
    }
}
