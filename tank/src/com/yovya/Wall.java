package com.yovya;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 7:52 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Wall extends GameObject {
    private BufferedImage image = ResourceMgr.wall;
    private Rectangle rectangle;
    private int width = 25, height = 200;

    Wall(int x, int y) {
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x, y, width, height);
        GameModel.getInstance().addObject(this);
    }

    @Override
    void paint(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
