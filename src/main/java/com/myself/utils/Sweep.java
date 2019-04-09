package com.myself.utils;

/**
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class Sweep {

    public static void sweep(int[] array, int i, int minIndex) {
        if (i == minIndex||array[i]==array[minIndex]) {
            return;
        }
        int tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
    }
}
