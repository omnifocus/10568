package com.design.factory.abstractfactory;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 9:09 PM
 * @Description: com.design.factory.abstractfactory
 * @version: 1.0
 */
public class MagicStick extends Weapon {

    @Override
    public void shoot() {
        System.out.println("MagicStick.shoot");
    }
}
