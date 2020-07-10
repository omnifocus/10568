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

    private Tank mainTank;

    public TankFrame() throws HeadlessException {
        mainTank = new Tank(300, 200, 100, 100, Direction.UP);
        setTitle("tank war");
        setSize(800, 600);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    /*
    because decided only to use four directions, so no need to use other 4 boolean variables.
     */
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        mainTank.setDir(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        mainTank.setDir(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        mainTank.setDir(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        mainTank.setDir(Direction.RIGHT);
                        break;

                }
            }
        });


    }


    /**
     * when minimize and resotre the frame, this method will be invoked!
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        /* paint : a tank knows exactly how to paint itself*/
        mainTank.paint(g);
    }

}
