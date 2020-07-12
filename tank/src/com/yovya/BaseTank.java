package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 12:36 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public abstract class BaseTank {
    Direction dir = Direction.UP;
    boolean moving = true;
    Group group = Group.BAD;
    Rectangle rectangle;

    abstract void paint(Graphics g);

    abstract void fire();

    abstract void die();


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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
