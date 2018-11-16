package com.myself.sort.inner.select;

import com.myself.utils.Sweep;

/**
 * 堆排序
 * 最坏，最好，平均时间复杂度均为O(nlogn)---->  优先队列 O(NlogM)
 * 不稳定排序
 * <p>
 * Binary Heap （大堆）任何一个结点都不大于他的父亲结点，必须是“完全二叉树”
 *
 * @author Created by zion
 * @Date 2018/11/16.
 */
public class MaxHeapSort {

    /**
     * 使用数组来保存数据
     */
    private int[] data;

    /**
     * 当前数组中的元素个数
     */
    private int size;

    private int capacity;

    public MaxHeapSort(int n) {
        this.data = new int[n + 1];
        this.size = 0;
        this.capacity = n;
    }

    /**
     * 构造函数直接将数据变成大堆
     * <p>
     * 这种插入方法会将O(nlogn)----> O(n)
     * <p>
     * 上面是每次只插入一个元素。
     * 一下实现一次性将一个数组构建成堆
     * 过程：heapify
     * 1：所有的叶子结点本身就是一个最大堆
     * 2：第一个不是叶子的结点的索引为（叶子结点/2）
     * 3：数组 0 位置不使用
     * 首先找到第一个不为叶子结点的元素的索引，这个元素以前都不是叶子结点
     * 把不是叶子结点都执行 shiftDown（）方法就可以变成大堆了
     */
    public MaxHeapSort(int[] arr, int n) {
        this.data = new int[n + 1];
        capacity = n;
        System.arraycopy(arr, 0, data, 1, n);
        size = n;
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

    public void pull(int value) {
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
        while (k > 1 && data[k / 2] < data[k]) {
            Sweep.sweep(data, k / 2, k);
            k /= 2;
        }
    }

    public Integer push() {
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
            //有右孩子，同时有孩子大于左孩子，就需要与右孩子交换了
            if (j + 1 <= size && data[j + 1] > data[j]) {
                j = j + 1;
            }
            if (data[k] > data[j]) {
                break;
            }
            Sweep.sweep(data, k, j);
            k = j;
        }
    }
}
