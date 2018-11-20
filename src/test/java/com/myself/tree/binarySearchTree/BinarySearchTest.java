package com.myself.tree.binarySearchTree;

import com.myself.sort.inner.exchange.FastSort;
import com.myself.utils.GenerateRandom;
import org.junit.Test;

/**
 * @author Created by zion
 * @Date 2018/11/20.
 */
public class BinarySearchTest {

    @Test
    public void binarySearch() {
        int[] input = GenerateRandom.generateRandomArray(100, 1, 100);
        FastSort sort = new FastSort();
        sort.fastSort(input, input.length - 1);
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.binarySearch(input, input.length, 10);
        int index1 = binarySearch.binarySearchRecursion(input, 0, input.length - 1, 10);
        System.out.println(index);
        System.out.println(index1);
    }

}