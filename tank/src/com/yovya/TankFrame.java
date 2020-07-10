package com.yovya;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 9:54 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TankFrame extends Frame {

    public TankFrame() throws HeadlessException {

        setTitle("tank war");
        setSize(800,600);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(100,100,100,50);
    }

}
