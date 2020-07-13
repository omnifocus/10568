package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 9:04 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Explode extends GameObject {
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        this.w = ResourceMgr.exImages[0].getHeight();
        this.h = ResourceMgr.exImages[0].getWidth();
        GameModel.getInstance().addObject(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                //not block main thread
                new Audio("audio/explode.wav").play();
            }
        }).start();
    }

    public void paint(Graphics g) {
        if (step >= ResourceMgr.exImages.length) {
            GameModel.getInstance().gos.remove(this);
        } else {
            g.drawImage(ResourceMgr.exImages[step++],x,y,null);
        }
    }

}
