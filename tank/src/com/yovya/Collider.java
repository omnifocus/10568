package com.yovya;

/**
 * @author: omnifocus
 * @Date: 2020/7/12 7:30 PM
 * @Description: com.yovya
 * @version: 1.0
 */
public interface Collider {
    // true means can carry on
    boolean doCollide(GameObject o1, GameObject o2);
}
