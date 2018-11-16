package com.myself.sort.inner.select;

import org.junit.Test;

import java.util.Random;

/**
 * @author Created by zion
 * @Date 2018/11/16.
 */
public class MaxHeapSortTest {
    @Test
    public void size1() throws Exception {

    }

    @Test
    public void isEmpty1() throws Exception {

    }

    @Test
    public void pull() throws Exception {

    }

    @Test
    public void push() throws Exception {

    }

    @Test
    public void size() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        MaxHeapSort maxHeapSort = new MaxHeapSort(5);
        for (int i = 0; i < 1000; i++) {
            maxHeapSort.pull(new Random().nextInt(100000));
        }
        while (!maxHeapSort.isEmpty()) {
            System.out.println(maxHeapSort.push());
        }
    }

}