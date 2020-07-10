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
    int width, height;
    Direction dir = Direction.UP;
    final int SPEED = 10;

    public Tank(int x, int y, int width, int height, Direction dir) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dir = dir;
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
        g.fillRect(x, y, width, height);
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
