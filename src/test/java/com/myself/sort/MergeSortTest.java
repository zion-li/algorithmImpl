package com.myself.sort;

import com.myself.sort.inner.merge.MergeSort;
import com.myself.utils.GenerateRandom;
import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class MergeSortTest {
    @Test
    public void mergeSort() throws Exception {
        MergeSort mergeSort=new MergeSort();
        long startTime = System.currentTimeMillis();
        int[] input = GenerateRandom.generateRandomArray(10, 1, 10);
        mergeSort.mergeSort(input, 0,input.length-1);
        long endTime = System.currentTimeMillis();
        for (int anInput : input) {
            System.out.println(anInput);
        }
        System.out.println("used time 1673 :" + (endTime - startTime));
    }

}