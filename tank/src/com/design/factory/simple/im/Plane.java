package com.design.factory.simple.im;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 8:45 PM
 * @Description: com.design.factory.simple.im
 * @version: 1.0
 */
public class Plane implements Moveable {
    @Override
    public void move() {
        System.out.println("Plane.move");
    }
}
