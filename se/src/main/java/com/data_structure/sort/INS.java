package com.data_structure.sort;

import java.util.Arrays;

/**
 * <p>
 * 插入排序
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/17 23:46
 */
public class INS {

    public static int[] sort(int[] unSortArr) {
        for (int i = 1; i < unSortArr.length; i++) {
            final int mark = unSortArr[i];
            int j = i - 1;
            while (j >= 0 && mark < unSortArr[j]) {
                unSortArr[j + 1] = unSortArr[j];
                j--;
            }
            unSortArr[j + 1] = mark;
        }
        return unSortArr;
    }

    @Deprecated
    public static int[] sortD(int[] unSortArr) {
        for (int i = 1; i < unSortArr.length; i++) {
            final int mark = unSortArr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (mark > unSortArr[j]) {
                    if (i - j >= 0) System.arraycopy(unSortArr, j, unSortArr, j + 1, i - j);
                    unSortArr[j + 1] = mark;
                    break;
                }
                if (j == 0 && mark < unSortArr[0]) {
                    System.arraycopy(unSortArr, 0, unSortArr, 1, i);
                    unSortArr[0] = mark;
                }
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
