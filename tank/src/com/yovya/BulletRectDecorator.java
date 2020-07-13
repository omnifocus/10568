package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 8:54 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class BulletRectDecorator extends BulletDecorator {
    public BulletRectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(go.x, go.y, go.getW(), go.getH());
        g.setColor(c);
    }
}
