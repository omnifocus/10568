package com.design.factory.simple;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 8:31 PM
 * @Description: com.design.factory.simple
 * not good , each time add a new Type to SimpleFactory, needs to add new code
 * @version: 1.0
 */
public class SimpleFactoryMain {
    public static void main(String[] args) {
        SimpleFactory sf = new SimpleFactory();
        sf.createCar();
        sf.createPlane();
    }
}
