package com.design.factory.simple.im;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 8:46 PM
 * @Description: com.design.factory.simple.im
 * just add Factory and Type (implements an interface)
 * @version: 1.0
 */
public class SimpleFactoryIm {
    public static void main(String[] args) {
        CarFactory cf = new CarFactory();
        cf.create();
        PlaneFactory pf = new PlaneFactory();
        pf.create();
    }
}
