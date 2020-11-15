package com.data_structure.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * <p>
 * 冒泡排序
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/17 19:03
 */
public class BUB {

    public static int[] sort(int[] unSortInts) {
        for (int i = 1; i < unSortInts.length; i++) {
            for (int j = 0; j < unSortInts.length - 1; j++) {
                if (unSortInts[j] > unSortInts[j + 1]) {
                    ArrayUtil.swap(unSortInts, j, j + 1);
                }
            }
        }
        return unSortInts;
    }

    public static int[] sortByHead(int[] unSortInts) {
        for (int i = 1; i < unSortInts.length; i++) {
            for (int j = 0; j < unSortInts.length - i; j++) {
                if (unSortInts[j] > unSortInts[j + 1]) {
                    ArrayUtil.swap(unSortInts, j, j + 1);
                }
            }
        }
        return unSortInts;
    }

    public static int[] sortByTail(int[] unSortInts) {
        for (int i = 1; i < unSortInts.length; i++) {
            for (int j = unSortInts.length - 1; j >= i; j--) {
                if (unSortInts[j] < unSortInts[j - 1]) {
                    ArrayUtil.swap(unSortInts, j, j - 1);
                }
            }
        }
        return unSortInts;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(sortByTail(ArraysUtil.generatorArray(20))));
        }
    }

}
