package com.myself.sort.inner.exchange;

import com.myself.utils.Sweep;

/**
 * [快速排序] O(nlogn)
 * 选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），
 * 比基准值大的都在右边（一般是无序的）。一般选择序列的第一个元素。
 * 左侧 arr[l+1...j]  arr[l]  arr[j+1...i-1]
 * <p>
 * 平均：O(nlogn)
 * 最好：O(nlogn)
 * 最坏：O(n^2)
 *
 * @author Created by zion
 * @Date 2018/11/12.
 */
public class FastSort {

    public void fastSort(int[] array, int n) {
        fastSort(array, 0, array.length - 1);
    }

    private void fastSort(int[] array, int l, int r) {
        if (l < r) {
            int p = partition(array, l, r);
            fastSort(array, l, p - 1);
            fastSort(array, p + 1, r);
        }
    }

    /**
     * 调用此函数之后，使得p前的元素全部小于p，p位置之后的元素全部大于p
     *
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partition(int[] array, int l, int r) {
        //标准元素
        int e = array[l];
        //j为小于e的区间，即刚开始的时候，小于e的元素区间为空
        int j = l;
        //分成两个部分，但是两个部分可以是无序的，i为将要移动的元素的下标
        //大于e的区间是[j+1  j+1)所以大于e的区间也是空的
        for (int i = l + 1; i <= r; i++) {
            //不需要处理当前元素大于e的情况，这个时候只需要进行i++就可以了，
            //仅仅需要处理元素小于e的情况
            if (array[i] < e) {
                Sweep.sweep(array, i, ++j);
            }
        }
        Sweep.sweep(array, l, j);
        return j;
    }
}
