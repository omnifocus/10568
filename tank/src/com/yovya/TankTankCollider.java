package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:37 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TankTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            ((Tank) o1).collide((Tank) o2);
        } else {
            return;
        }
    }
}
