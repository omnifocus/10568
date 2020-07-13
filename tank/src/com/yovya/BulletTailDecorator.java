package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 3:49 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class BulletTailDecorator extends BulletDecorator {
    public BulletTailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // let BulletRectDecorator get the update x & y
        // cause for BulletRectDecorator, BulletTailDecorator acts as go
        // if x & y not change, BulletRectDecorator 'x & y not change either
        x = go.x;
        y = go.y;
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(go.x, go.y, go.x + 5, go.y + 5);
        g.setColor(c);
    }


}
