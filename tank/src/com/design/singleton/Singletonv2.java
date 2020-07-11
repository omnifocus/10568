package com.design.singleton;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 4:05 PM
 * @Description: com.design
 * static inner class, JVM ensures singleton,lazy loading:
 * when  outer class loaded ,inner class not loaded.
 * @version: 2.0
 */
public class Singletonv2 {


    private Singletonv2() {}

    private static class Singletonv2Holder {
        private static final Singletonv2 singletonv2Holder = new Singletonv2();
    }

    public static Singletonv2 getInstance() {
        return Singletonv2Holder.singletonv2Holder;
    }

    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0;i<100;i++) {
                System.out.println(Singletonv3.INSTANCE.hashCode());
            }
        }).start();
    }

}
