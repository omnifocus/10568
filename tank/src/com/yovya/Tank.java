package com.yovya;

import com.yovya.changeskin.AbstractSkin;
import com.yovya.firestrategy.FireStrategy;
import com.yovya.firestrategy.FireStrategyDefault;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 3:25 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Tank {
    int x = 50, y = 50;
    public static int WIDTH = ResourceMgr.mainTankU.getWidth(), HEIGHT = ResourceMgr.mainTankU.getHeight();
    Direction dir = Direction.UP;
    final int SPEED = 5;


    private TankFrame tf;
    private boolean alive = true;
    private Group group = Group.BAD;
    private boolean moving = true;

    // every 3 step change pic
    private int step = 0;

    private Rectangle rectangle;

    private Random random = new Random();


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
        this.rectangle = new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g, AbstractSkin as) {

        if (!alive) {

            return;
        }

        checkBorder();

        // if moving , then redraw
        if (moving)
            move();

        // abstract factory
//        g.drawImage(getTankImage(), x, y, null);
        as.drawTank(g, this);

        /*
        // time to fire

         only enemy to fire

         */
        if (this.group != Group.GOOD) {
            if (random.nextInt(100) > 98)
                fire(FireStrategyDefault.getInstance());
        }
    }

    /* no need to change direction , cause changing direction inside every move */
    private void checkBorder() {

        if (x < 0) {
            x = 0;
        }
        if (x > TankFrame.GAME_WIDTH - WIDTH) {
            x = TankFrame.GAME_WIDTH - WIDTH;
        }

        if (y < 20) {
            y = 20;
        }

        if (y > TankFrame.GAME_HEIGHT - HEIGHT) {
            y = TankFrame.GAME_HEIGHT - HEIGHT;
        }
    }


    private void move() {
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

    // pass the strategy through parameter, make sure actual strategy be singleton.
    public void fire(FireStrategy fs) {
        if (group == Group.GOOD) {
            fs.fire(this);
        } else {
            try {
                Class clazz = Class.forName(PropertyMgr.getInstance().getProperty("badFS"));
                FireStrategy fs2 = (FireStrategy) clazz.getDeclaredMethod("getInstance").invoke(clazz);
                fs2.fire(this);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }


    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public BufferedImage getTankImage() {
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
        new Explode(x + WIDTH / 2 - Explode.EXPLODEWIDTH / 2, y + HEIGHT / 2 - Explode.EXPLODEHEIGHT / 2, tf);
        this.tf.getEnemies().remove(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }
}



