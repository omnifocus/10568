package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 3:48 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Decorator extends GameObject {
    GameObject go;

    public Decorator(GameObject go) {
        GameModel instance = GameModel.getInstance();
        instance.gos.remove(go);
        instance.addObject(this);
        this.x = go.x;
        this.y = go.y;
        this.w = go.w;
        this.h = go.h;
        this.go = go;
        this.group = go.group;
        this.rectangle = go.rectangle;
        this.alive = go.alive;
    }

    public void paint(Graphics g) {


        if (!alive) {

            return;
        }

        go.paint(g);


    }

    public void die() {
        alive = false;
        go.die();
        GameModel.getInstance().gos.remove(this);
    }

    public GameObject getGo() {
        return go;
    }

    public Group getGroup() {
        return go.group;
    }

    public Rectangle getRectangle() {
        return go.rectangle;
    }
}
