package com.myself.sort;

import com.myself.sort.inner.exchange.BubbleSort;
import com.myself.utils.GenerateRandom;
import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class BubbleSortTest {
    @Test
    public void bubbleSort() throws Exception {
        BubbleSort bubbleSort=new BubbleSort();
        long startTime = System.currentTimeMillis();
        int[] input = GenerateRandom.generateRandomArray(30, 1, 100);
        bubbleSort.bubbleSortOptim(input, input.length);
        long endTime = System.currentTimeMillis();
        for (int anInput : input) {
            System.out.println(anInput);
        }
        System.out.println("used time 335 :" + (endTime - startTime));
    }

}