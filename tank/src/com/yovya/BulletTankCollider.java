package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:31 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean doCollide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            return !((Bullet) o1).doCollide((Tank) o2);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return !((Bullet) o2).doCollide((Tank) o1);
        }
        return false;
    }
}
