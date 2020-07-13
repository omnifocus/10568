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
public class Bullet extends GameObject {
    int x = 50, y = 50;
    public static final int BULLETWIDTH = ResourceMgr.bulletU.getWidth(), BULLETHEIGHT = ResourceMgr.bulletU.getHeight();
    final int SPEED = 10;
    Direction dir = Direction.DOWN;
    boolean alive = true;
    Group group = Group.BAD;

    Rectangle rectangle;


    public Bullet(int x, int y, Direction dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.rectangle = new Rectangle(x, y, BULLETWIDTH, BULLETHEIGHT);
        GameModel.getInstance().addObject(this);
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
        GameModel.getInstance().gos.remove(this);
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
}
