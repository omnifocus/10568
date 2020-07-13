package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 4:19 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class BulletDecorator extends Decorator {
    public BulletDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //if cross wall, die
        alive = go.alive;
        if (!alive) {
            die();
            return;
        }
    }
}
