package com.design.factory.simple.im;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 8:46 PM
 * @Description: com.design.factory.simple.im
 * @version: 1.0
 */
public class PlaneFactory {
    public Moveable create() {
        return new Plane();
    }
}
