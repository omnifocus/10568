package com.yovya.observer;

import com.yovya.TankDecorator;

/**
 * @author: omnifocus
 * @Date: 2020/7/14 10:32 AM
 * @Description: com.yovya.observer
 * @version: 1.0
 */
public class FireEvent {
    long when;
    TankDecorator source;

    public FireEvent(long when, TankDecorator source) {
        this.when = when;
        this.source = source;
    }
}
