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
    int width = ResourceMgr.mainTankU.getWidth(), height = ResourceMgr.mainTankU.getHeight();
    Direction dir = Direction.UP;
    final int SPEED = 5;


    private TankFrame tf;
    private boolean alive = true;
    private Group group = Group.BAD;
    private boolean moving = true;

    // every 3 step change pic
    private int step = 0;

    private Random random = new Random();

    public Tank(int x, int y, int width, int height, Direction dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dir = dir;
        this.tf = tf;
        this.moving = group == Group.BAD ? true : false;
    }

    public Tank(int x, int y, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = randomDir();
        this.group = group;
        this.tf = tf;
        this.moving = group == Group.BAD ? true : false;
    }


    private Direction randomDir() {
        int len = Direction.values().length;
        return Direction.values()[(int) (Math.random() * len)];

    }

    public Tank(int x, int y, Direction dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        this.moving = group == Group.BAD ? true : false;
    }

    public void paint(Graphics g) {

        if (!alive) {
            //when tank dies, add Explodes!
            tf.getExplodes().add(new Explode(x + width / 2 - Explode.EXPLODEWIDTH / 2, y + height / 2 - Explode.EXPLODEHEIGHT / 2, tf));
            this.tf.getEnemies().remove(this);
            return;
        }

        checkBorder();

        // if moving , then redraw
        if (moving)
            move();

        g.drawImage(getTankImage(), x, y, null);
        /*
        // time to fire

         only enemy to fire

         */
        if (this.group != Group.GOOD) {
            if (random.nextInt(100) > 98)
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

        // after move, decide next dir
        // not the mainTank
        // give it an opportunity to change Direction
        if (group != Group.GOOD && random.nextInt(100) > 95)
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
        /**
         * show a bullet from tank
         */

        // when adding bullet, we have to decide it's the same group as the current Tank
        //this.getGroup()
        this.tf.getBullets().add(new Bullet(x + width / 2 - Bullet.BULLETWIDTH / 2, y + height / 2 - Bullet.BULLETHEIGHT / 2, dir, this.getGroup(), tf));
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
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}



