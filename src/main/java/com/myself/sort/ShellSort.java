package com.myself.sort;

import com.myself.utils.Sweep;

/**
 * 希尔排序
 * 希尔排序是非稳定排序算法
 *
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class ShellSort {

    public void shellSort(int[] array, int n) {
        //增量
        int incrementNum = array.length / 2;
        while (incrementNum >= 1) {
            for (int i = 0; i < array.length; i++) {
                for (int j = i; j < array.length - incrementNum; j += incrementNum) {
                    if (array[j] > array[j + incrementNum]) {
                        Sweep.sweep(array, j, j + incrementNum);
                    }
                }
            }
            //设置新的增量
            incrementNum = incrementNum / 2;
        }
    }
}
