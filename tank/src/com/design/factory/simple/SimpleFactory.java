package com.design.factory.simple;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 8:36 PM
 * @Description: com.design.factory.simple
 * @version: 1.0
 */
public class SimpleFactory {
    Car createCar() {

        System.out.println("doing initialize..");
        return new Car();
    }

    Plane createPlane() {
        System.out.println("doing initialize..");
        return new Plane();
    }
}
