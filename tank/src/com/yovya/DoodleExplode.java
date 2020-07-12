package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 1:13 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class DoodleExplode extends BaseExplode {
    private int x, y;
    private TankFrame tf;
    private int step = 0;
    public static int height = ResourceMgr.exImages[0].getHeight(), width = ResourceMgr.exImages[0].getWidth();


    public DoodleExplode(int x, int y, TankFrame tf) {
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
        if (step >= 3) {
            //after 3 freshes, it's gone
            this.tf.explodes.remove(this);
        } else {
            Color c = g.getColor();
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, width, height);
            g.setColor(c);
            step++;
        }
    }
}
