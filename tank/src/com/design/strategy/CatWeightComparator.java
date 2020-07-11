package com.design.strategy;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:31 PM
 * @Description: com.design.strategy
 * @version: 1.0
 */
public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        if (t1.weight > t2.weight) return -1;
        else if (t1.weight < t2.weight) return 1;
        else return 0;
    }
}
