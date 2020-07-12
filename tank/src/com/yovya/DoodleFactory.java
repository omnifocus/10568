package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 1:02 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public class DoodleFactory extends AbstractFactory {
    private static DoodleFactory doodleFactory = new DoodleFactory();

    private DoodleFactory() {
    }

    public static DoodleFactory getInstance() {
        return doodleFactory;
    }

    @Override
    BaseTank createTank(int x, int y, Direction dir, Group group, TankFrame tf) {
        return new DoodleTank(x, y, dir, group, tf);
    }

    @Override
    BaseBullet createBullet(int x, int y, Direction dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    BaseExplode createExplode(int x, int y, TankFrame tf) {
        return null;
    }
}
