package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 12:43 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class DefaultFactory extends AbstractFactory {

    private static DefaultFactory defaultFactory = new DefaultFactory();

    private DefaultFactory() {
    }

    public static DefaultFactory getInstance() {
        return defaultFactory;
    }

    @Override
    BaseTank createTank(int x, int y, Direction dir, Group group, TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }

    @Override
    BaseBullet createBullet(int x, int y, Direction dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }

    @Override
    BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }


}
