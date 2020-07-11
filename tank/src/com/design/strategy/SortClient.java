package com.design.strategy;


import java.util.Arrays;

/**
 * @author: omnifocus
 * @Date: 2020/7/11 5:17 PM
 * @Description: com.design.strategy
 * @version: 1.0
 */
public class SortClient<T> {

    public void sort(T[] ts, Comparator<T> comparator) {
        for (int i = 0; i < ts.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < ts.length; j++) {
                if (comparator.compare(ts[index], ts[j]) == 1) {
                    index = j;
                }
            }
            if (i != index) {
                swap(ts, i, index);
            }
        }
        System.out.println(Arrays.toString(ts));
    }

    void swap(T[] ts, int i, int index) {
        T temp = ts[i];
        ts[i] = ts[index];
        ts[index] = temp;
    }

    public static void main(String[] args) {
        SortClient<Cat> sc = new SortClient<>();
        Cat[] cats = {new Cat(10, 2), new Cat(7, 5), new Cat(8, 4), new Cat(9, 3),};
//        sc.sort(cats, new CatHeightComparator());
        sc.sort(cats, new CatWeightComparator());
    }
}
