package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:37 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean doCollide(GameObject o1, GameObject o2) {
        if (o1 instanceof TankDecorator && o2 instanceof TankDecorator) {
            TankDecorator t1 = (TankDecorator) o1;
            TankDecorator t2 = (TankDecorator) o2;
            if (t1.rectangle.intersects(t2.rectangle)) {
                t1.goBack();
                t2.goBack();
            }

        }
        return true;
    }

}
