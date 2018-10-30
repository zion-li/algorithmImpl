package com.myself.sort;

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
        int[] input = GenerateRandom.generateRandomArray(40, 10, 100);
        selectSort.selectSort(input, input.length);
        for (int anInput : input) {
            System.out.println(anInput);
        }
    }

}