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
    //mainTank's default direction is up
    Direction dir = Direction.UP;

    final int SPEED = 10;


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

        addKeyListener(new MyKeyListener());


    }


    /**
     * when minimize and resotre the frame, this method will be invoked!
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
        }
        g.fillRect(x, y, 100, 50);

    }


    class MyKeyListener extends KeyAdapter {

        /* these boolean variables should be inside MyKeyListener, TankFrame does not care about thme */
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

        private void changeDirection() {

            // not right , if bU and bL are true, then the first two conditions will be true!
//        if (bU) {
//            y -= speed;
//        }
//        if (bU && bL) {
//            y -= speed;
//            x -= speed;
//        }
//        if (bU && bR) {
//            y -= speed;
//            x += speed;
//        }
//        if (bD) {
//            y += speed;
//        }
//        if (bD && bL) {
//            y += speed;
//            x -= speed;
//        }
//        if (bD && bR) {
//            y += speed;
//            x += speed;
//        }
//        if (bL) {
//            x -= speed;
//        }
//        if (bR) {
//            x += speed;
//        }


            if (bU)
                dir = Direction.UP;

            if (bD)
                dir = Direction.DOWN;

            if (bL)
                dir = Direction.LEFT;

            if (bR)
                dir = Direction.RIGHT;


        }

    }

}
