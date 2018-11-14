package com.myself.sort;

import com.myself.sort.inner.exchange.FastSort;
import com.myself.utils.GenerateRandom;
import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/11/12.
 */
public class FastSortTest {
    @Test
    public void fastSortTest() throws Exception {
        FastSort fastSort = new FastSort();
        long startTime = System.currentTimeMillis();
        int[] input = GenerateRandom.generateRandomArray(10000, 1, 100000000);
        fastSort.fastSort(input, input.length);
        long endTime = System.currentTimeMillis();
        for (int anInput : input) {
            System.out.println(anInput);
        }
        System.out.println("used time 4 :" + (endTime - startTime));
    }
}