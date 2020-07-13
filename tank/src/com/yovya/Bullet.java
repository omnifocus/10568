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
    private int x = 50, y = 50;
    public static final int BULLETWIDTH = ResourceMgr.bulletU.getWidth(), BULLETHEIGHT = ResourceMgr.bulletU.getHeight();
    private final int SPEED = 10;
    private Direction dir = Direction.DOWN;
    private GameModel gm;
    private boolean alive = true;
    private Group group = Group.BAD;

    private Rectangle rectangle;


    public Bullet(int x, int y, Direction dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;
        this.rectangle = new Rectangle(x, y, BULLETWIDTH, BULLETHEIGHT);

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

    public boolean doCollide(Tank enemy) {
        //same group, can't fire
        if (this.group == enemy.getGroup()) {
            return false;
        }
        if (this.rectangle.intersects(enemy.getRectangle())) {
            this.die();
            //enemy.setAlive(false);
            //I don't know if there's the field
            enemy.die();
            return true;
        }
        return false;
    }

    public void die() {
        this.setAlive(false);
        //once die, remove from tf immediately
        this.gm.gos.remove(this);
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
