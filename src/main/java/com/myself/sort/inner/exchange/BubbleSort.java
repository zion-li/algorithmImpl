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

    /**
     * 理解：简单的冒泡排序算法就是从前到后两两比较，经过一轮循环找出当前的最大值放在最后。
     * 之后所有比较范围，进行下一轮循环，这样一直进行下去。
     * 过程：每一次遍历，都会把最大的元素放在最后，下一次循环重0到 上一次循环-1位置
     *
     * @param arry 遍历的数据
     * @param n    数据的个数
     */
    public void bubbleSort(int[] arry, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arry[j] > arry[j + 1]) {
                    Sweep.sweep(arry, j, j + 1);
                }
            }
        }
    }

    /**
     * 优化,如果已经是一个排好序的，就不就判断了
     */
    public void bubbleSortOptim(int[] arry, int n) {
        boolean flag;
        int pos = 0;
        int k = n - 1;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < k && arry[j] > arry[j + 1]; j++) {
                Sweep.sweep(arry, j, j + 1);
                flag = false;
                pos = j;
            }
            if (flag) {
                return;
            }
            k = pos;
        }
    }

}
