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
    int x = 50, y = 50;

    int speed = 10;
    /*
        After press two keys, at first ,the computer can detect both,
       after a while ,the computer can only detect the last key.
       So these four variables remember the state of the combined keys when
       the computer detects both
        */
    boolean bU = false;
    boolean bD = false;
    boolean bL = false;
    boolean bR = false;

    public TankFrame() throws HeadlessException {

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

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        bU = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        bL = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = true;
                        break;

                }
                changeDirection();


            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        bU = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        bD = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        bL = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        bR = false;
                        break;

                }
                changeDirection();

            }


        });
    }

    private void changeDirection() {
        if (bU) {
            y -= speed;
        }
        if (bU && bL) {
            y -= speed;
            x -= speed;
        }
        if (bU && bR) {
            y -= speed;
            x += speed;
        }
        if (bD) {
            y += speed;
        }
        if (bD && bL) {
            y += speed;
            x -= speed;
        }
        if (bD && bR) {
            y += speed;
            x += speed;
        }
        if (bL) {
            x -= speed;
        }
        if (bR) {
            x += speed;
        }

    }


    /**
     * when minimize and resotre the frame, this method will be invoked!
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 100, 50);
    }

}
