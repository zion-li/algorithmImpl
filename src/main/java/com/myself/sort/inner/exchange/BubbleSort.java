package com.myself.sort.inner.exchange;

import com.myself.utils.Sweep;

/**
 * 冒泡排序
 * 平均：O(n^2)
 * 最好：O(n)
 * 最坏：O(n^2)
 * 每次循环找到最大值放在最后，注意边界问题
 *
 * @author Created by zion
 * @Date 2018/10/30
 */
public class BubbleSort {

    public void bubbleSort(int[] arry, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arry[j] > arry[j + 1]) {
                    Sweep.sweep(arry, j, j + 1);
                }
            }
        }
    }


}
