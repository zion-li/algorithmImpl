package com.myself.sort.inner.exchange;

import com.myself.sort.inner.insert.InsertionSort;
import com.myself.utils.Sweep;

import java.util.Random;

/**
 * [快速排序]
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
//        fastSort(array, 0, array.length - 1);
        partitionOptimizThree(array, 0, array.length - 1);
    }

    private void fastSort(int[] array, int l, int r) {
        if (l < r) {
            int p = partitionOptimizTwo(array, l, r);
            //进过一次排序之后，p左侧的元素必定小于p，p右侧的元素必定大于p，所以不需要对p位置进行处理了
            fastSort(array, l, p - 1);
            fastSort(array, p + 1, r);
        }
    }

    /**
     * 调用此函数之后，使得p前的元素全部小于p，p位置之后的元素全部大于p
     * 过程：选择一个基准i之后,把所有小于i的元素都紧贴着i的右边放置，
     * 最后交换i和小于i的最后一个元素的j位置，这样，就把数组分成左侧小于i，右侧大于i的元素了
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
                //注意：重点在这  j的位置要不断向后移动哦
                Sweep.sweep(array, i, ++j);
            }
        }
        Sweep.sweep(array, l, j);
        return j;
    }

    /**
     * 每一次的基准值位置变成随机获取，这种方法避免了元素向一段倾斜，造成O(O^2)
     *
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partitionOptimizOne(int[] array, int l, int r) {
        //使随机元素变成标准元素
        Sweep.sweep(array, new Random().nextInt(r - l + 1) + l, l);
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


    /**
     * 双路排序
     *
     * @param array
     * @param l
     * @param r
     * @return
     */
    private int partitionOptimizTwo(int[] array, int l, int r) {
        //使随机元素变成标准元素
        Sweep.sweep(array, new Random().nextInt(r - l + 1) + l, l);
        //标准元素
        int e = array[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && array[i] < e) {
                i++;
            }
            while (j >= l + 1 && array[j] > e) {
                j--;
            }
            if (i > j) {
                break;
            }
            Sweep.sweep(array, i, j);
            i++;
            j--;
        }
        Sweep.sweep(array, l, j);
        return j;
    }

    /**
     * 三路排序 分为大于 等于 小于
     * arr[l+1...lt]     arr[lt+1...i]  arr[gt...r]
     * 适用于有大量重复元素的排序
     *
     * @param array
     * @param l
     * @param r
     * @return
     */
    private void partitionOptimizThree(int[] array, int l, int r) {
        //
        if (r - l < 15) {
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.insertSort(array, array.length);
            return;
        }
        //上面代码是对这段的优化
//        if(l>=r){
//            return;
//        }
        Sweep.sweep(array, l, new Random().nextInt(r - l + 1) + l);

        //基准元素
        int e = array[l];

        int lt = l;
        int i = l + 1;
        int gt = r + 1;

        while (i < gt) {
            if (array[i] < e) {
                Sweep.sweep(array, i, lt + 1);
                lt++;
                i++;
            } else if (array[i] > e) {
                Sweep.sweep(array, i, gt - 1);
                gt--;
                //此时i不需要移动，因为依旧指向一个没有处理的元素
            } else {
                i++;
            }
        }
        Sweep.sweep(array, l, lt);
        partitionOptimizThree(array, l, lt - 1);
        partitionOptimizThree(array, gt, r);
    }
}
