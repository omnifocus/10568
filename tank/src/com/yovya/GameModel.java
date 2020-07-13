package com.yovya;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 6:12 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class GameModel {
    private static GameModel gm;
    ColliderChain chain;
    Tank mainTank;

    static {
        gm = new GameModel();
        gm.init();
    }

    private GameModel() {

    }

    public static GameModel getInstance() {
        return gm;
    }

    private void init() {
        mainTank = new Tank(300, 400, Direction.UP, Group.GOOD);
        //read initialCount from config
        int initialCount = Integer.parseInt(PropertyMgr.getProperties("initialTankCount"));
        // add enemy tanks

        for (int i = 0; i < initialCount; i++) {
            new Tank(30 + i * 100, 100, Direction.DOWN, Group.BAD);
        }

        new Wall(100, 30);
        chain = new ColliderChain();
    }



    ArrayList<GameObject> gos = new ArrayList<>();


    void addObject(GameObject go) {
        gos.add(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("objects: " + gos.size(), 30, 40);
        g.setColor(c);

        mainTank.paint(g);
        for (int i = 0; i < gos.size(); i++) {
            gos.get(i).paint(g);
        }


        for (int i = 0; i < gos.size(); i++) {
            for (int j = i + 1; j < gos.size(); j++) {
                GameObject o1 = gos.get(i);
                GameObject o2 = gos.get(j);
                chain.doCollide(o1, o2);
            }
        }

    }
}
