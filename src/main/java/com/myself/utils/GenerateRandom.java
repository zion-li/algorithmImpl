package com.myself.utils;

import java.util.Random;

/**
 * 随机数生成算法
 *
 * @author Created by zion
 * @Date 2018/10/29.
 */
public class GenerateRandom {

    /**
     * 生成N个元素的随机数，每个元素的随机范围是rangeL到rangeR
     *
     * @param n      生成元素的个数
     * @param rangeL 最小值
     * @param rangeR 最大值
     * @return 数组
     */
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        if (rangeR < rangeL) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = new Random().nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tmp = GenerateRandom.generateRandomArray(100, 40, 45);
        for (int aTmp : tmp) {
            System.out.println(aTmp);
        }
    }
}
