package com.myself.sort.inner.merge;

/**
 * 归并排序 [左右边都是闭区间]
 * 需要使用O（n）额外的空间
 * <p>
 * 在最坏、最佳、平均情况下归并排序时间复杂度均为o(nlogn)
 * <p>
 * -----------------------------------------------------
 * ┆凉┆暖┆降┆等┆幸┆我┆我┆里┆将┆　┆可┆有┆谦┆戮┆那┆　┆大┆始┆　┆然┆
 * ┆薄┆一┆临┆你┆的┆还┆没┆　┆来┆　┆是┆来┆逊┆没┆些┆　┆雁┆终┆　┆而┆
 * ┆　┆暖┆　┆如┆地┆站┆有┆　┆也┆　┆我┆　┆的┆有┆精┆　┆也┆没┆　┆你┆
 * ┆　┆这┆　┆试┆方┆在┆逃┆　┆会┆　┆在┆　┆清┆来┆准┆　┆没┆有┆　┆没┆
 * ┆　┆生┆　┆探┆　┆最┆避┆　┆在┆　┆这┆　┆晨┆　┆的┆　┆有┆来┆　┆有┆
 * ┆　┆之┆　┆般┆　┆不┆　┆　┆这┆　┆里┆　┆没┆　┆杀┆　┆来┆　┆　┆来┆
 *
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class MergeSort {

    public void mergeSort(int[] array, int l, int r) {
        int mid = l + (r - l) / 2;
        if (l < r) {
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, r);
            //归并过程保证了从l到mid 以及 mid+1 到 r是有序的，所以当mid小于mid+1的时候，
            //就已经不需要再一次的进行merge操作了、
            if (array[mid] > array[mid + 1]) {
                merge(array, l, mid, r);
            }
        }
    }

    /**
     * 归并[l,mid) 和[mid,r)
     *
     * @param arry
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] arry, int left, int mid, int right) {
        //生成一个临时的空间，大小[left,right)
        int[] aux = new int[right - left + 1];
        //对这个临时空间进行数据填充
        for (int i = left; i <= right; i++) {
            aux[i - left] = arry[i];
        }
        //找到左右两个区间的起始点
        int i = left, j = mid + 1;
        //将所有两个区间的元素全部排序放进临时空间里
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arry[k] = aux[j - left];
                j++;
                continue;
            } else if (j > right) {
                arry[k] = aux[i - left];
                i++;
                continue;
            }

            if (aux[i - left] < aux[j - left]) {
                arry[k] = aux[i - left];
                i++;
            } else {
                arry[k] = aux[j - left];
                j++;
            }
        }
    }

}
