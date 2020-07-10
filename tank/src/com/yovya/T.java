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
    public static void main(String[] args) {
        Frame frame  = new Frame();
        frame.setTitle("tank war");
        frame.setSize(800,600);
        frame.setVisible(true);

        // monitor close button
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
