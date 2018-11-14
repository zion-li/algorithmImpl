package com.myself.sort;

import com.myself.sort.inner.insert.InsertionSort;
import com.myself.utils.GenerateRandom;
import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class InsertionSortTest {
    @Test
    public void insertSort() throws Exception {
        InsertionSort insertionSort = new InsertionSort();
        long startTime = System.currentTimeMillis();
        int[] input = GenerateRandom.generateRandomArray(40000, 1, 1000);
        insertionSort.insertSort(input, input.length);
        long endTime = System.currentTimeMillis();
        for (int anInput : input) {
            System.out.println(anInput);
        }
        System.out.println("used time 525 :" + (endTime - startTime));
    }

    @Test
    public void insertSortOptimize() throws Exception {
        InsertionSort insertionSort = new InsertionSort();
        long startTime = System.currentTimeMillis();
        int[] input = GenerateRandom.generateRandomArray(100, 1, 100);
        insertionSort.insertSortOptimize(input, input.length);
        long endTime = System.currentTimeMillis();
        for (int anInput : input) {
            System.out.println(anInput);
        }
        System.out.println("used time 335 :" + (endTime - startTime));
    }
}