package com.se.lang.nums;

import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/5/20 10:55
 */
public class IntegerTest {

    @Test
    public void demo1() {
        Integer aa = new Integer(300);
        Integer bb = new Integer(301);
        System.out.println("aa hashcode:"+System.identityHashCode(aa));
        System.out.println("bb hashcode:"+System.identityHashCode(bb));
        changeInteger(aa);
        changeInteger(bb);
        System.out.println(aa);
        System.out.println(bb);
    }

    public void changeInteger(Integer num) {
        System.out.println("num hashcode:"+System.identityHashCode(num));
        num = 5;
    }



    /**
     * Byte、Short、Integer、Long、Character都具有缓存机制
     * 范围为
     * Byte，Short，Integer，Long为 -128 到 127
     * Character范围为 0 到 127
     */
    @Test
    public void demo2() {
        //情景1
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);//false

        //情景2
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);//true。b.intValue()

        //情景3
        Integer e = new Integer(1);
        Integer f = new Integer(1);
        System.out.println(e == f);//false
    }

    @Test
    public void demo3(){
        Integer a = 400;
        Integer b = new Integer(400);
        Integer c = new Integer(0);
        System.out.println(a == b + c);
    }

    @Test
    public void demo4(){
        System.out.println(Integer.valueOf("1"));
        System.out.println("123.321.123.321".replaceAll("\\.",
                                           "[.]"));
        System.out.println(Integer.valueOf(String.valueOf('1')));

    }

    @Test
    public void demo5(){
        final Integer[] integers = { 1, 2 };
        int[] ints = { 1, 2 };
    }

}
