package com.design.factory.abstractfactory;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 9:13 PM
 * @Description: com.design.factory.abstractfactory
 * abstractfactory:it's easy to add new series of fixed things ,but only fixed things!
 * factory: it's easy to add new things (add Factory ,add new Type)
 * @version: 1.0
 */
public class AbstractFacMain {
    public static void main(String[] args) {
        ModernFactory modernFactory = ModernFactory.getInstance();
        Food food = modernFactory.createFood();
        Mount mount = modernFactory.createMount();
        Weapon weapon = modernFactory.createWeapon();
        food.printNmae();
        mount.go();
        weapon.shoot();

        MagicFactory mf = MagicFactory.getInstance();
        Food mfood = mf.createFood();
        Mount mfMount = mf.createMount();
        Weapon mw = mf.createWeapon();
        mfood.printNmae();
        mfMount.go();
        mw.shoot();
    }
}
