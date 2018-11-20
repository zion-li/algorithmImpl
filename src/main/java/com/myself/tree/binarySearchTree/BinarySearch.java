package com.myself.tree.binarySearchTree;

/**
 * 二分查找
 * O（logN）
 *
 * @author Created by zion
 * @Date 2018/11/20.
 */
public class BinarySearch {

    public int binarySearch(int[] array, int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == target) {
                return mid;
            } else {
                if (target < array[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

    public int binarySearchRecursion(int[] array, int l, int r, int target) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == target) {
                return mid;
            } else {
                if (target < array[mid]) {
                    return binarySearchRecursion(array, l, mid - 1, target);
                } else {
                    return binarySearchRecursion(array, mid + 1, r, target);
                }
            }
        }
        return -1;
    }
}
