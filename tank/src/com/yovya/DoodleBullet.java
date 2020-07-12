package com.yovya;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 4:24 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class DoodleBullet extends BaseBullet {
    private int x = 50, y = 50;
    public static final int BULLETWIDTH = ResourceMgr.bulletU.getWidth(), BULLETHEIGHT = ResourceMgr.bulletU.getHeight();
    private final int SPEED = 30;
    private Direction dir = Direction.DOWN;
    private TankFrame tf;
    private boolean alive = true;
    private Group group = Group.BAD;

    private Rectangle rectangle;


    public DoodleBullet(int x, int y, Direction dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        this.rectangle = new Rectangle(x, y, BULLETWIDTH, BULLETHEIGHT);

    }

    public DoodleBullet() {
    }

    public void paint(Graphics g) {


        if (!alive) {
//            this.tf.getBullets().remove(this);
            return;
        }

        //because the pictures not very ok, calculates every one each time
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
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, BULLETWIDTH, BULLETHEIGHT);
        g.setColor(c);
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

    public void hitTank(BaseTank enemy) {
        //same group, can't fire
        if (this.group == enemy.getGroup()) {
            return;
        }
        if (this.rectangle.intersects(enemy.getRectangle())) {
            this.die();
            //enemy.setAlive(false);
            //I don't know if there's the field
            enemy.die();
        }
    }

    private void die() {
        this.setAlive(false);
        //once die, remove from tf immediately
        this.tf.bullets.remove(this);
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
