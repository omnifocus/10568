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
        if (o1 instanceof BulletDecorator && o2 instanceof TankDecorator) {
            //same group, can't fire
            BulletDecorator bullet = (BulletDecorator) o1;
            TankDecorator tank = (TankDecorator) o2;
            if (bullet.getGroup() == tank.group) {
                return true;
            }
            if (bullet.getRectangle().intersects(tank.getRectangle())) {
                tank.die();
                bullet.die();

                return false;
            }
            return false;
        } else if (o1 instanceof TankDecorator && o2 instanceof BulletDecorator) {
            return doCollide(o2, o1);
        }
        return true;
    }
}
