package com.yovya;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 9:44 AM
 * @Description: com.yovya, create a useless Frame
 * @version: 1.0
 */
public class T {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        // refresh automatically every 50ms
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
