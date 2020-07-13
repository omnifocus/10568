package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 7:58 AM
 * @Description: com.yovya
 * if bullet dies, no need to carry on other collider!
 * @version: 1.0
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean doCollide(GameObject o1, GameObject o2) {
        if (o1 instanceof BulletDecorator && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.getRectangle().intersects(wall.getRectangle())) {
                bullet.die();
                return false;
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return doCollide(o2, o1);
        }
        return true;
    }
}
