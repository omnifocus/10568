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
    private boolean moving = true;
    private TankFrame tf;
    private boolean alive = true;
    private Group group = Group.BAD;



    private Random random = new Random();

    public Tank(int x, int y, int width, int height, Direction dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank(int x, int y,  Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = randomDir();
        this.group = group;
        this.tf = tf;
    }


    private Direction randomDir() {
        int len = Direction.values().length;
        return Direction.values()[(int)(Math.random()*len)];

    }

    public Tank(int x, int y, Direction dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {

        if (!alive) {
            //when tank dies, add Explodes!
            tf.getExplodes().add(new Explode(x,y,tf));
            this.tf.getEnemies().remove(this);
            return;
        }

        checkBorder();

        // if moving , then redraw
        if (moving)
            move();

        g.drawImage(getTankImage(), x, y, null);
        // time to fire
        if (random.nextInt(10) > 8) {
            fire();
        }
    }

    private void checkBorder() {
        if (x <= 0) {
            while (dir == Direction.LEFT) {
                dir = randomDir();
            }
        }
        if (x >= TankFrame.GAME_WIDTH - width) {
            while (dir == Direction.RIGHT) {
                dir = randomDir();
            }
        }

        if (y <= 20) {
            while (dir == Direction.UP) {
                dir = randomDir();
            }
        }

        if (y >= TankFrame.GAME_HEIGHT - height) {
            while (dir == Direction.DOWN) {
                dir = randomDir();
            }
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
        // when adding bullet, we have to decide it's the same group as the current Tank
        //this.getGroup()
        this.tf.getBullets().add(new Bullet(x+tankImg.getWidth()/2-bulletImg.getWidth()/2,y + tankImg.getHeight()/2, dir, this.getGroup(),tf));
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}



