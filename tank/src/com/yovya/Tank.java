package com.yovya;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 3:25 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Tank {
    int x = 50, y = 50;
    int width=100, height=100;
    Direction dir = Direction.UP;
    final int SPEED = 10;
    // default state is not moving
    private boolean moving;
    private TankFrame tf;
    private boolean alive = true;

    public Tank(int x, int y, int width, int height, Direction dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dir = dir;
        this.tf = tf;
    }

    public Tank(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!alive) {
            this.tf.getEnemies().remove(this);
            return;
        }
        // if moving , then redraw
        if (moving)
            move();


        g.drawImage(ResourceMgr.imageU, x, y, null);
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
        this.tf.getBullets().add(new Bullet(x, y, dir, tf));
    }




    public Rectangle getRectange() {
        return new Rectangle(x,y,width,height);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}



