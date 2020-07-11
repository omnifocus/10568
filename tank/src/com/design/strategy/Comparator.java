package com.design.strategy;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:17 PM
 * @Description: com.design.strategy
 * @version: 1.0
 */
public interface Comparator<T> {
    int compare(T t1, T t2);
}
