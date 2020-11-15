package com.se.collection;

import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/9/7 19:48
 */
public class HashMapTest {

    @Test
    public void demo1(){
        final HashMap<Object, Object> map = new HashMap<>(16, 0.75f);
        for (int i = 0; i < 20; i++) {
            map.put(RandomUtil.randomInt(100,10000),"TEST");
        }
    }

}
