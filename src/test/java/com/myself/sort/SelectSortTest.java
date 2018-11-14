package com.myself.sort;

import com.myself.sort.inner.select.SelectSort;
import com.myself.utils.GenerateRandom;
import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/10/30.
 */
public class SelectSortTest {

    @Test
    public void selectSortTest() {
        SelectSort selectSort = new SelectSort();
        long startTime = System.currentTimeMillis();
        int[] input = GenerateRandom.generateRandomArray(40000, 1, 1000);
        selectSort.selectSort(input, input.length);
        long endTime = System.currentTimeMillis();
        for (int anInput : input) {
            System.out.println(anInput);
        }
        System.out.println("used time 1673 :" + (endTime - startTime));
    }

}