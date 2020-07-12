package com.yovya;

import java.awt.*;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 12:36 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public abstract class BaseBullet {
    abstract void paint(Graphics g);

    abstract void hitTank(Tank enemy);
}
