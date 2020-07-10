package com.yovya;

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

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Bullet(int x, int y,Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Bullet() {
    }

    public void paint(Graphics g) {
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
    }
}
