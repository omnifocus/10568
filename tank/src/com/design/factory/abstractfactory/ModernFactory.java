package com.design.factory.abstractfactory;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 9:05 PM
 * @Description: com.design.factory.abstractfactory
 * @version: 1.0
 */
public class ModernFactory extends AbstractFactory {
    private static ModernFactory modernFactory = new ModernFactory();

    private ModernFactory() {
    }

    public static ModernFactory getInstance() {
        return modernFactory;
    }

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Mount createMount() {
        return new Benz();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
