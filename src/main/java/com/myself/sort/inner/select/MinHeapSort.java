package com.myself.sort.inner.select;

import com.myself.utils.Sweep;

/**
 * 最小堆排列
 *
 * @author Created by zion
 * @Date 2019/1/4.
 */
public class MinHeapSort {
    /**
     * 使用数组来保存数据
     */
    private int[] data;

    /**
     * 当前数组中的元素个数
     */
    private int size;

    private int capacity;

    public MinHeapSort(int n) {
        this.data = new int[n + 1];
        this.size = 0;
        this.capacity = n;
    }

    //创建堆
    public MinHeapSort(int[] array, int n) {
        this.data = new int[n + 1];
        this.capacity = n;
        System.arraycopy(array, 0, data, 1, n);
        this.size = n;
        for (int i = size / 2; i >= 1; i--) {
            shiftDown(data, i);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入：
     * 1）  将新插入的元素，放置到队列的尾部。
     * 2）  若该元素小于其父节点，两个元素互换。（上移操作）
     * 3）  迭代，直至该元素没有父节点或小于其父节点。
     *
     * @param value
     */
    public void push(int value) {
        if (size + 1 > capacity) {
            int[] tmp = new int[size * 2];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
        data[size + 1] = value;
        size++;
        shiftUp(data, size);
    }

    private void shiftUp(int[] data, int k) {
        while (k > 1 && data[k / 2] > data[k]) {
            Sweep.sweep(data, k / 2, k);
            k /= 2;
        }
    }

    /**
     * 删除：
     * 1）  移掉顶部的节点。
     * 2）  将队末的元素放置到顶部。
     * 3）  该节点与其子节点中较小的那个比较，若小于它，则交换位置，（下移操作）
     * 4）  迭代，直到叶节点或不再比其子节点中较小那个大。
     *
     * @return
     */
    public Integer pull() {
        if (size == 0) {
            return null;
        }
        int e = data[1];
        Sweep.sweep(data, 1, size);
        //这块必须size--，相当于把最后一个元素去掉了，虽然这个元素的值还存在
        size--;
        shiftDown(data, 1);
        return e;
    }

    /**
     * 尝试将k位置的元素向下移动
     *
     * @param data
     * @param k
     */
    private void shiftDown(int[] data, int k) {
        //是否有左孩子
        while (2 * k <= size) {
            int j = 2 * k;
            //有右孩子，同时右孩子大于左孩子，就需要与右孩子交换了
            if (j + 1 <= size && data[j + 1] < data[j]) {
                j = j + 1;
            }
            if (data[k] < data[j]) {
                break;
            }
            Sweep.sweep(data, k, j);
            k = j;
        }
    }
}
