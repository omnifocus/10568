package com.yovya;

import javax.swing.*;
import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 4:24 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Bullet {
    private int x = 50, y = 50, width = 50, height = 50;
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

        g.fillOval(x, y, width, height);

        g.setColor(c);

        if (x <0 || x> TankFrame.GAME_WIDTH || y <0 || y> TankFrame.GAME_HEIGHT) {
            alive = false;
        }
    }
}
