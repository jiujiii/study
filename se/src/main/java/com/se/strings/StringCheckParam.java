package com.se.strings;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;

public class StringCheckParam {

    private void checkStringParam(String... args){
        for (String arg : args)
            if (StringUtils.isEmpty(arg))
                throw new IllegalArgumentException(
                        String.format("参数错误:参数为空,参数列表为 %s", Arrays.toString(args))
                );
    }

    @Test
    public void demo1(){
        checkStringParam("123","456","87654","1111");
    }

}
