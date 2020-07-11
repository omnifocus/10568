package com.design.strategy;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:26 PM
 * @Description: com.design.strategy
 * @version: 1.0
 */
public class Cat {
    int height, weight;

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }
}
