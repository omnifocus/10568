package com.design.factory.abstractfactory;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 8:59 PM
 * @Description: com.design.factory.simple
 * @version: 1.0
 */
public abstract class AbstractFactory {
    abstract Food createFood();

    abstract Mount createMount();

    abstract Weapon createWeapon();
}
