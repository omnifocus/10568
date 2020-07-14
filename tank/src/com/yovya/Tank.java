package com.yovya;

import com.yovya.observer.*;
import observer.Observer;

import java.awt.*;
import java.awt.desktop.FilesEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 3:25 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Tank extends GameObject {
    Direction dir = Direction.UP;
    final int SPEED = 5;

    public boolean moving = true;

    // every 3 step change pic
    private int step = 0;


    private Random random = new Random();

    // original main Tank position
    private int prevX = 300, prevY = 400;

    ArrayList<TankObserver> observers;

    private Direction randomDir() {
        int len = Direction.values().length;

        return Direction.values()[(int) (Math.random() * len)];

    }

    public Tank(int x, int y, Direction dir, Group group) {
        this.w = ResourceMgr.mainTankU.getWidth();
        this.h = ResourceMgr.mainTankU.getHeight();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.moving = group == Group.BAD ? true : false;
        this.rectangle = new Rectangle(x, y, w, h);
        GameModel.getInstance().addObject(this);


    }

    public void paint(Graphics g) {

        if (!alive) {

            return;
        }

        g.drawImage(getTankImage(), x, y, null);
        // if moving , then redraw
        if (moving)
            move();


        /*
        // time to fire

         only enemy to fire

         */
        if (this.group != Group.GOOD) {
            if (random.nextInt(100) > 98)
                fire();
        }
    }

    /* no need to change direction , cause changing direction inside every move */
    private void checkBorder() {

        if (x < 0) {
            x = 0;
        }
        if (x > TankFrame.GAME_WIDTH - w) {
            x = TankFrame.GAME_WIDTH - w;
        }

        if (y < 20) {
            y = 20;
        }

        if (y > TankFrame.GAME_HEIGHT - h) {
            y = TankFrame.GAME_HEIGHT - h;
        }
    }


    public void goBack() {
        this.x = prevX;
        this.y = prevY;

    }

    private void move() {
        prevX = x;
        prevY = y;
        // check border inside move
        checkBorder();
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

        // update tank's rectangle after moves
        rectangle.x = x;
        rectangle.y = y;
        // after move, decide next dir
        // not the mainTank
        // give it an opportunity to change Direction
        if (group != Group.GOOD && random.nextInt(80) > 30)
            dir = randomDir();


        step++;
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
        // get bullet from the bullet pool
        Bullet bullet = Bullet.getBullet(x + w / 2 - ResourceMgr.bulletU.getWidth() / 2, y + h / 2 - ResourceMgr.bulletU.getHeight() / 2, dir, this.getGroup());
        new BulletRectDecorator(new BulletTailDecorator(bullet));

    }


    public Rectangle getRectangle() {
        return rectangle;
    }



    private BufferedImage getTankImage() {
        BufferedImage image = null;
        switch (dir) {
            case UP:
                if (step % 3 == 0) {
                    image = group == Group.GOOD ? ResourceMgr.main2TankU : ResourceMgr.bad2TankU;
                } else {
                    image = group == Group.GOOD ? ResourceMgr.mainTankU : ResourceMgr.badTankU;

                }

                break;
            case DOWN:
                if (step % 3 == 0) {
                    image = group == Group.GOOD ? ResourceMgr.main2TankD : ResourceMgr.bad2TankD;
                } else {
                    image = group == Group.GOOD ? ResourceMgr.mainTankD : ResourceMgr.badTankD;

                }
                break;
            case LEFT:
                if (step % 3 == 0) {
                    image = group == Group.GOOD ? ResourceMgr.main2TankL : ResourceMgr.bad2TankL;
                } else {
                    image = group == Group.GOOD ? ResourceMgr.mainTankL : ResourceMgr.badTankL;

                }

                break;
            case RIGHT:
                if (step % 3 == 0) {
                    image = group == Group.GOOD ? ResourceMgr.main2TankR : ResourceMgr.bad2TankR;
                } else {
                    image = group == Group.GOOD ? ResourceMgr.mainTankR : ResourceMgr.badTankR;

                }

                break;

        }
        return image;
    }


    public void die() {
        this.alive = false;
        //when tank dies, add Explodes!
        new Explode(x + w / 2 - ResourceMgr.exImages[0].getWidth() / 2, y + h / 2 - ResourceMgr.exImages[0].getHeight() / 2);
        GameModel.getInstance().gos.remove(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}



