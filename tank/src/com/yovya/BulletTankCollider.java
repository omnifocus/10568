package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:31 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class BulletTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            ((Bullet) o1).hitTank((Tank) o2);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            ((Bullet) o2).hitTank((Tank) o1);
        }
    }
}
