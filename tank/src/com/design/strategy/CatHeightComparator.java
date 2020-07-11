package com.design.strategy;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:27 PM
 * @Description: com.design.strategy
 * @version: 1.0
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        if (t1.height > t2.height) return -1;
        else if (t1.height < t2.height) return 1;
        else return 0;
    }
}
