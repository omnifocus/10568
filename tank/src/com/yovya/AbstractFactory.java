package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 12:40 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public abstract class AbstractFactory {
    abstract BaseTank createTank(int x, int y, Direction dir, Group group, TankFrame tf);

    abstract BaseBullet createBullet(int x, int y, Direction dir, Group group, TankFrame tf);

    abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
