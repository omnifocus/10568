package com.yovya;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 6:12 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class GameModel {
    Tank mainTank;
    // add a list of bullets
    ArrayList<Bullet> bullets;
    ArrayList<Tank> enemies;
    // add a list of explode;
    ArrayList<Explode> explodes;

    public GameModel() {
        mainTank = new Tank(300, 400, Direction.UP, Group.GOOD, this);
        bullets = new ArrayList<>();
        explodes = new ArrayList<>();
        //read initialCount from config
        int initialCount = Integer.parseInt(PropertyMgr.getProperties("initialTankCount"));
        // add enemy tanks
        enemies = new ArrayList<Tank>();

        for (int i = 0; i < initialCount; i++) {
            enemies.add(new Tank(30 + i * 130, 100, Direction.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color origin = g.getColor();
        Color c = Color.WHITE;
        g.setColor(c);
        g.drawString("current bullets: " + bullets.size(), 20, 40);
        g.drawString("current enemies: " + enemies.size(), 20, 60);
        g.drawString("current explodes: " + explodes.size(), 20, 80);
        g.setColor(origin);

        /* paint : a tank knows exactly how to paint itself*/
        mainTank.paint(g);

        //java.util.ConcurrentModificationException
//        for (Bullet bullet : bullets) {
//            bullet.paint(g);
//        }

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            for (int j = 0; j < enemies.size(); j++) {
                bullet.hitTank(enemies.get(j));
            }
            bullet.paint(g);
        }

        for (int i = 0; i < enemies.size(); i++) {
            Tank enemy = enemies.get(i);
            enemy.paint(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

    }
}
