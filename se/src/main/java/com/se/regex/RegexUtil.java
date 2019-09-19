package com.se.regex;

import cn.hutool.core.util.ReUtil;
import org.junit.Assert;
import org.junit.Test;

public class RegexUtil {

    private static final String PATTER_1 = "^/(\\w)+.do(.)*";
    private static final String PATTER_2 = "^/(.)+.do(.)*";

    @Test
    public void demo1(){
        Assert.assertTrue(ReUtil.isMatch(PATTER_1, "/logout.do3213"));
        Assert.assertTrue(ReUtil.isMatch(PATTER_1, "/error.do32234rasdfd"));
        Assert.assertTrue(ReUtil.isMatch(PATTER_1, "/login_error.dofdsafe"));
    }

    @Test
    public void demo2(){
        Assert.assertTrue(ReUtil.isMatch(PATTER_2, "/logout.do3213"));
        Assert.assertTrue(ReUtil.isMatch(PATTER_2, "/error.do32234rasdfd"));
        Assert.assertTrue(ReUtil.isMatch(PATTER_2, "/login_error.dofdsafe"));
    }

}
