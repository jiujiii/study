package com.data_structure.sort;

import cn.hutool.core.util.RandomUtil;

import java.util.stream.IntStream;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/17 19:03
 */
public class ArraysUtil {

    public static int[] generatorArray(int length){
        return generatorArray(1,100,length);
    }

    public static int[] generatorArray(int min,int max,int length){
        return IntStream.generate(() -> RandomUtil.randomInt(min,max)).limit(length).toArray();
    }

}
