package com.myself.sort.inner.insert;

import com.myself.utils.Sweep;

/**
 * 插入排序算法
 * 平均：O(n^2)
 * 最好：O(n)
 * 最坏：O(n^2)
 * 理论上应该比选择排序块一点点
 *
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class InsertionSort {

    public void insertSort(int[] array, int n) {
        //从第二个元素开始
        for (int i = 1; i < n; i++) {
            //寻找array[i]应该插入[0,i-1]的哪一个位置
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                //第二层循环可以提前结束
                Sweep.sweep(array, j, j - 1);
            }
        }
    }

    /**
     * 改进算法，将多次sweep变成赋值操作
     *
     * @param array 输入数组
     * @param n     数组长度
     */
    public void insertSortOptimize(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int e = array[i];
            int j;
            //寻找array[i]应该插入[0,i-1]的哪一个位置
            for (j = i; j > 0 && array[j - 1] > e; j--) {
                array[j] = array[j - 1];
            }
            array[j] = e;
        }
    }
}
