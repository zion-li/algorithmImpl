package com.myself.sort.inner.select;

import com.myself.utils.Sweep;

/**
 * 索引堆
 * 将数据和索引分开存储，
 * data内容不会发生改变，但是index会发生改变。
 *
 * @author Created by zion
 * @Date 2018/11/19.
 */
public class IndexHeap {

    /**
     * 最终保存用户存储的真正数据
     */
    int[] data;


    /**
     * indexs-》data的索引
     */
    int[] indexs;

    /**
     * data-》indexs中的索引
     */
    int[] rev;

    int size;

    int capacity;


    public IndexHeap(int capacity) {
        this.data = new int[capacity + 1];
        this.indexs = new int[capacity + 1];
        this.rev = new int[capacity + 1];
        //0根本没有意义的位置
        for (int i = 0; i <= capacity; i++) {
            rev[i] = 0;
        }
        this.size = 0;
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入元素，内部从1开始插入，外部从0开始计算的
     *
     * @param i    索引位置
     * @param item 插入元素
     */
    public void push(int i, int item) throws IndexOutOfBoundsException {
        if (i + 1 < 1 && i + 1 > capacity) {
            throw new IndexOutOfBoundsException();
        }
        i += 1;
        data[i] = item;
        indexs[size + 1] = i;
        rev[i] = size + 1;
        size++;
        shiftUp(size);
    }

    private void shiftUp(int k) {
        while (k > 1 && data[indexs[k / 2]] < data[indexs[k]]) {
            Sweep.sweep(indexs, k / 2, k);
            rev[indexs[k / 2]] = k / 2;
            rev[indexs[k]] = k;
            k /= 2;
        }
    }

    public Integer pull() {
        if (size == 0) {
            return null;
        }
        int e = data[indexs[1]];
        Sweep.sweep(indexs, 1, size);
        rev[indexs[1]] = 1;
        rev[indexs[size]] = 0;
        size--;
        shiftDown(1);
        return e;

    }

    public int extractMaxIndex() {
        if (size == 0) {
            return -1;
        }
        int e = indexs[1] - 1;
        Sweep.sweep(indexs, 1, size);
        rev[indexs[1]] = 1;
        rev[indexs[size]] = 0;
        size--;
        shiftDown(1);
        return e;

    }

    private void shiftDown(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j + 1 <= size && data[indexs[j + 1]] > data[indexs[j]]) {
                j += 1;
            }
            Sweep.sweep(indexs, k, j);
            rev[indexs[k]] = k;
            rev[indexs[j]] = j;
            k = j;
        }
    }

    public int getItem(int i) {
        return data[i + 1];
    }

    /**
     * @param i
     * @param item
     */
    public void change(int i, int item) {
        i += 1;
        data[i] = item;
        shiftUp(rev[i]);
        shiftDown(rev[i]);
    }

    public boolean contain(int i) {
        if (i + 1 > 1 && i + 1 <= capacity) {
            return rev[i + 1] != 0;
        } else {
            return false;
        }
    }
}
