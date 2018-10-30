package com.myself.sort;

/**
 * 选择排序
 *
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class SelectSort {

    public void selectSort(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            sweep(array, i, minIndex);
        }
    }

    private void sweep(int[] array, int i, int minIndex) {
        int tmp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = tmp;
    }

}
