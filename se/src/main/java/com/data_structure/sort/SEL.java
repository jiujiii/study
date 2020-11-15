package com.data_structure.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * <p>
 * 选择排序
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/17 20:56
 */
public class SEL {

    public static int[] sort(int[] unSortArr) {
        for (int i = 1; i < unSortArr.length; i++) {
            int minIndex = i - 1;
            for (int j = i; j < unSortArr.length; j++) {
                if (unSortArr[minIndex] > unSortArr[j]) {
                    minIndex = j;
                }
            }
            if (i - 1 != minIndex) {
                ArrayUtil.swap(unSortArr, i - 1, minIndex);
            }
        }
        return unSortArr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(sort(ArraysUtil.generatorArray(20))));
        }
    }
}
