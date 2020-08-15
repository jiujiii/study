package com.extra.joda;

import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2019-12-07 21:40
 */
public class JodaTimeTest {

    @Test
    public void demo1(){
        System.out.println(JodaTimeUtil.strToDate("2019-12-7 19:21:31").getTime());
    }

}
