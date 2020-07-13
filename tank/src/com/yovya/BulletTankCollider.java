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
            //same group, can't fire
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            if (bullet.group == tank.group) {
                return true;
            }
            if (bullet.rectangle.intersects(tank.getRectangle())) {
                bullet.die();
                tank.die();
                return false;
            }
            return false;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return doCollide(o2, o1);
        }
        return true;
    }
}
