package com.design.factory.abstractfactory;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 9:11 PM
 * @Description: com.design.factory.abstractfactory
 * @version: 1.0
 */
public class MagicFactory extends AbstractFactory {
    private static MagicFactory magicFactory = new MagicFactory();

    private MagicFactory() {
    }

    public static MagicFactory getInstance() {
        return magicFactory;
    }

    @Override
    Food createFood() {
        return new Mushroom();
    }

    @Override
    Mount createMount() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
