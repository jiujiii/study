package com.se.strings;

import org.junit.Test;

import java.util.Date;

/**
 * <p>
 *  字符串格式化
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2019-07-14 22:52
 */
public class StringFormatForTest {

    @Test
    public void demo1() {
        formatStr("%s , %s", "按顺序定位", "测试");
        formatStr("%2$s, %1$s", "按照索引定位", "测试");
        formatStr("%06d",1242);

        Date date=new Date();
        formatStr("%tc",date);
        formatStr("%tF",date);
        formatStr("%tD",date);
        formatStr("%tr",date);
        formatStr("%tT",date);
        formatStr("%tR",date);
    }

    private void formatStr(String format, Object... objs) {
        System.out.println(String.format(format, objs));
    }

}
