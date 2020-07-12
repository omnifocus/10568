package com.yovya;

import com.yovya.changeskin.AbstractSkin;

import java.awt.*;
import java.awt.image.BufferedImage;

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
        this.tf.getExplodes().add(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //not block main thread
                new Audio("audio/explode.wav").play();
            }
        }).start();
    }

    public void paint(Graphics g, AbstractSkin as) {
        if (step >= ResourceMgr.exImages.length) {
//            step = 0;
            this.tf.getExplodes().remove(this);
        } else {
            //          use abstract factory
//            g.drawImage(getExplodeImage(),x,y,null);
            as.drawExplode(g, this);
            step++;
        }
    }

    public BufferedImage getExplodeImage() {
        return ResourceMgr.exImages[step++];
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
