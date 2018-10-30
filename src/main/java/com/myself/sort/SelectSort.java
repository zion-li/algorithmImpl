package com.myself.sort;

import com.myself.utils.Sweep;

/**
 * 选择排序 O（n^2）
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
            Sweep.sweep(array, i, minIndex);
        }
    }


}
