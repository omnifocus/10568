package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:23 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public abstract class GameObject {
    public int x, y;
    public int w, h;
    public Group group;
    public Rectangle rectangle;
    public boolean alive = true;

    abstract void paint(Graphics g);

    public void die() {
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
