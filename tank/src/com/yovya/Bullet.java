package com.yovya;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 4:24 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Bullet extends GameObject {
    final int SPEED = 10;
    Direction dir = Direction.DOWN;
    String UUID;
    final static int POOLLENGHT = 500;
    static Bullet[] bulletPool = new Bullet[POOLLENGHT];
    static int poolIndex = 0;


    private Bullet(int x, int y, Direction dir, Group group) {
        this.w = ResourceMgr.bulletU.getWidth();
        this.h = ResourceMgr.bulletU.getHeight();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.rectangle = new Rectangle(x, y, w, h);
        GameModel.getInstance().addObject(this);
        UUID = java.util.UUID.randomUUID().toString();
    }

    public Bullet() {
    }

    public void paint(Graphics g) {


        if (!alive) {
//            this.tf.getBullets().remove(this);
            return;
        }

        //because the pictures not very ok, calculates every one each time
        BufferedImage image = null;
        switch (dir) {
            case UP:
                y -= SPEED;
                image = ResourceMgr.bulletU;
                break;
            case DOWN:
                y += SPEED;
                image = ResourceMgr.bulletD;
                break;
            case LEFT:
                x -= SPEED;
                image = ResourceMgr.bulletL;
                break;
            case RIGHT:
                x += SPEED;
                image = ResourceMgr.bulletR;
                break;
        }
        g.drawImage(image, x, y, null);
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//
//        g.fillOval(x, y, width, height);
//
//        g.setColor(c);

        // update rectangle after moves
        rectangle.x = x;
        rectangle.y = y;
        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) {
            this.die();
        }
    }


    public void die() {
        this.setAlive(false);
        //once die, remove from tf immediately
//        GameModel.getInstance().gos.remove(this);

        // not remove self, but put it to the pool

    }



    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public static Bullet getBullet(int x, int y, Direction dir, Group group) {
        Bullet bullet = null;
        for (int i = 0; i < POOLLENGHT; i++) {
            if (bulletPool[i] != null && !bulletPool[i].alive) {
                bullet = bulletPool[i];

                System.out.println("retrieving " + bullet);
            }
        }

        // if cannot find one , creat a new one
        if (bullet == null && poolIndex <= POOLLENGHT) {
            bullet = new Bullet(x, y, dir, group);
            // - - forget to add it
            bulletPool[poolIndex++] = bullet;
            System.out.println("newing " + bullet);
        }


        bullet.alive = true;
        bullet.x = x;
        bullet.y = y;
        bullet.dir = dir;
        bullet.group = group;


        return bullet;
    }

    @Override
    public String toString() {
        return "Bullet{" +
            "UUID='" + UUID + '\'' +
            '}';
    }
}
