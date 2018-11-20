package com.myself.sort.inner.select;

import org.junit.Test;

import java.util.Random;

/**
 * @author Created by zion
 * @Date 2018/11/20.
 */
public class IndexHeapTest {
    @Test
    public void size() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void insert() throws Exception {
        IndexHeap maxHeapSort = new IndexHeap(100);
        for (int i = 0; i < 5; i++) {
            maxHeapSort.push(i, new Random().nextInt(100));
        }
        while (!maxHeapSort.isEmpty()) {
            System.out.println(maxHeapSort.pull());
        }

    }

    @Test
    public void extractMax() throws Exception {

    }

    @Test
    public void extractMaxIndex() throws Exception {

    }

    @Test
    public void getItem() throws Exception {

    }

    @Test
    public void change() throws Exception {

    }

    @Test
    public void contain() throws Exception {

    }
}