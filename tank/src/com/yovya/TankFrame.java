package com.yovya;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: omnifocus
 * @Date: 2020/7/10 9:54 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800, GAME_HEIGHT = 600;

    GameModel gm = new GameModel();


    public TankFrame() throws HeadlessException {


        setTitle("tank war");
        setSize(GAME_WIDTH, GAME_HEIGHT);
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
                        gm.mainTank.setDir(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        gm.mainTank.setDir(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        gm.mainTank.setDir(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        gm.mainTank.setDir(Direction.RIGHT);
                        break;
                }

                // only when up down left right pressed, mainTank 's moving is true
                int selectedKeyCode = e.getKeyCode();
                if (selectedKeyCode == KeyEvent.VK_UP || selectedKeyCode == KeyEvent.VK_DOWN || selectedKeyCode == KeyEvent.VK_LEFT || selectedKeyCode == KeyEvent.VK_RIGHT) {
                    gm.mainTank.setMoving(true);
                }

            }

            // only when up down left right released, mainTank 's moving is false
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:

                    case KeyEvent.VK_DOWN:

                    case KeyEvent.VK_LEFT:

                    case KeyEvent.VK_RIGHT:
                        gm.mainTank.setMoving(false);
                        break;

                    case KeyEvent.VK_CONTROL:
                        gm.mainTank.fire();
                        break;
                }
            }


        });


    }


    /**
     * when minimize and restore the frame, this method will be invoked!
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {


        gm.paint(g);


    }



    /* double buffer to eliminate flicking */
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        paint(gOffScreen);
        gOffScreen.setColor(c);
        g.drawImage(offScreenImage, 0, 0, null);

    }


}
