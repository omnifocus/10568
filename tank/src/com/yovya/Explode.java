package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 9:04 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class Explode {
    private int x, y;
    private TankFrame tf;
    private int step = 0;
    public static final int EXPLODEHEIGHT = ResourceMgr.exImages[0].getHeight(), EXPLODEWIDTH = ResourceMgr.exImages[0].getWidth();

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
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
//            step = 0;
            this.tf.getExplodes().remove(this);
        } else {
            g.drawImage(ResourceMgr.exImages[step++],x,y,null);
        }
    }

}
