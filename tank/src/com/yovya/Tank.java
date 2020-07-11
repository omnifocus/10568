package com.yovya;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 3:25 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Tank {
    int x = 50, y = 50;
    int width = 50, height = 50;
    Direction dir = Direction.UP;
    final int SPEED = 10;
    // default state is not moving
    private boolean moving;
    private TankFrame tf;
    private boolean alive = true;

    private Random random = new Random();

    public Tank(int x, int y, int width, int height, Direction dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank(int x, int y, Direction dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!alive) {
            this.tf.getEnemies().remove(this);
            return;
        }
        // if moving , then redraw
        if (moving)
            move();

        g.drawImage(getTankImage(), x, y, null);
        // time to fire
        if (random.nextInt(10) > 8) {
            fire();
        }
    }


    private void move() {

        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;

                break;
            case LEFT:
                x -= SPEED;

                break;
            case RIGHT:
                x += SPEED;

                break;
        }
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        /**
         * show a bullet from tank
         */
        BufferedImage tankImg = getTankImage();
        BufferedImage bulletImg = getBulletImage();
        this.tf.getBullets().add(new Bullet(x+tankImg.getWidth()/2-bulletImg.getWidth()/2,y + tankImg.getHeight()/2, dir, tf));
    }


    public Rectangle getRectange() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    private BufferedImage getTankImage() {
        BufferedImage image = null;
        switch (dir) {
            case UP:
                image = ResourceMgr.tankU;
                break;
            case DOWN:
                image = ResourceMgr.tankD;

                break;
            case LEFT:
                image = ResourceMgr.tankL;

                break;
            case RIGHT:
                image = ResourceMgr.tankR;

                break;

        }
        return image;
    }

    private BufferedImage getBulletImage() {
        BufferedImage image = null;
        switch (dir) {
            case UP:
                image = ResourceMgr.bulletU;
                break;
            case DOWN:
                image = ResourceMgr.bulletD;

                break;
            case LEFT:
                image = ResourceMgr.bulletL;

                break;
            case RIGHT:
                image = ResourceMgr.bulletR;

                break;

        }
        return image;
    }

    public void die() {
        this.alive = false;
    }
}



