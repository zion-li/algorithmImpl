package com.myself.sort;

import com.myself.sort.inner.insert.ShellSort;
import com.myself.utils.GenerateRandom;
import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class ShellSortTest {
    @Test
    public void shellSort() throws Exception {
        ShellSort shellSort=new ShellSort();
        long startTime = System.currentTimeMillis();
        int[] input = GenerateRandom.generateRandomArray(10, 1, 100);
        shellSort.shellSort(input, input.length);
        long endTime = System.currentTimeMillis();
        for (int anInput : input) {
            System.out.println(anInput);
        }
        System.out.println("used time 1673 :" + (endTime - startTime));
    }

}