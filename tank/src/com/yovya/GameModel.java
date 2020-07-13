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
    private static GameModel gm = new GameModel();

    private GameModel() {
        //read initialCount from config
        int initialCount = Integer.parseInt(PropertyMgr.getProperties("initialTankCount"));
        // add enemy tanks

        for (int i = 0; i < initialCount; i++) {
            addObject(new Tank(30 + i * 100, 100, Direction.DOWN, Group.BAD, this));
        }
        chain = new ColliderChain();
        gos.add(new Wall(100, 30));
    }

    public static GameModel getInstance() {
        return gm;
    }

    ArrayList<GameObject> gos = new ArrayList<>();
    Tank mainTank = new Tank(300, 400, Direction.UP, Group.GOOD, this);
    ColliderChain chain;


    void addObject(GameObject go) {
        gos.add(go);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < gos.size(); i++) {
            gos.get(i).paint(g);
        }
        mainTank.paint(g);

        for (int i = 0; i < gos.size(); i++) {
            for (int j = i + 1; j < gos.size(); j++) {
                GameObject o1 = gos.get(i);
                GameObject o2 = gos.get(j);
                chain.doCollide(o1, o2);
            }
        }

    }
}
