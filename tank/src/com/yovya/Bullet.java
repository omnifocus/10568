package com.yovya;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 4:24 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Bullet {
    private int x = 50, y = 50, width = 12, height = 12;
    private final int SPEED = 10;
    private Direction dir = Direction.DOWN;
    private TankFrame tf;
    private boolean alive = true;

    public Bullet(int x, int y, int width, int height,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tf = tf;
    }

    public Bullet(int x, int y,Direction dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Bullet() {
    }

    public void paint(Graphics g) {

        if (!alive) {
            this.tf.getBullets().remove(this);
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
        g.drawImage(image,x, y,null);
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//
//        g.fillOval(x, y, width, height);
//
//        g.setColor(c);


        if (x <0 || x> TankFrame.GAME_WIDTH || y <0 || y> TankFrame.GAME_HEIGHT) {
            alive = false;
        }
    }

    public void hitTank(Tank enemy) {
        if ( this.getRectange().intersects(enemy.getRectange()) ) {
            this.die();
            //enemy.setAlive(false);
            //I don't know if there's the field
            enemy.die();
        }
    }

    private void die() {
        this.setAlive(false);
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
