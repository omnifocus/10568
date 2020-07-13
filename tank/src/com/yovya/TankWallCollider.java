package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/13 8:07 AM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean doCollide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if (tank.getRectangle().intersects(wall.getRectangle())) {
                tank.goBack();
                return true;
            }
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            Tank tank = (Tank) o2;
            Wall wall = (Wall) o1;
            if (tank.getRectangle().intersects(wall.getRectangle())) {
                tank.goBack();
                return true;
            }
        }
        return true;
    }
}
