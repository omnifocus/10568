package com.yovya;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 9:54 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TankFrame extends Frame {
    int x=50 ,y=50;
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

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                x += 30;
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }


        });
    }

    /**
     * when minimize and resotre the frame, this method will be invoked!
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(x,y,100,50);
    }

}
