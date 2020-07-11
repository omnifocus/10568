package com.design;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 3:58 PM
 * @Description: com.design
 * @version: 1.0
 */
public class Singleton {
    // volatile to avoid JIT
    private static volatile  Singleton singleton;

    private Singleton() {}

    public  static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                //double check, ensure only get one singleton
                if (singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }
}
