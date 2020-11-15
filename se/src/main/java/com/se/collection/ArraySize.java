package com.se.collection;

import com.Node;
import com.beust.jcommander.internal.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/5/9 21:48
 */
public class ArraySize {

    @Test
    public void demo1() {
        final Integer[] ints = new Integer[10];
        System.out.println(ints.length);
    }

    @Test
    public void demo2() {
        final int[] a = {1, 2, 3, 4, 5};
        final int[] b = {4, 5, 6, 7, 8};
        System.arraycopy(a,0,a,1,4);
        System.out.println(Arrays.toString(a));
    }

    public void demo3(){
        final List<Node> nodes = Lists.newArrayList(Node.of(1), Node.of(2), Node.of(3));
    }

}
