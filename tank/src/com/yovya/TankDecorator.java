package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 5:40 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TankDecorator extends Decorator {
    public Direction dir;
    public boolean moving = true;

    public TankDecorator(Tank go) {
        super(go);
        dir = go.dir;
        moving = go.isMoving();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!alive) return;
        Tank tank = (Tank) go;
        if (tank.group == Group.GOOD) {

            tank.moving = this.moving;
            tank.dir = this.dir;
        }


        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(go.x, go.y - 5, go.getW(), 5);
        g.setColor(c);
    }

    public void fire() {
        Tank tank = (Tank) super.go;
        tank.fire();
    }

    public void goBack() {
        Tank tank = (Tank) super.go;
        tank.goBack();
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
