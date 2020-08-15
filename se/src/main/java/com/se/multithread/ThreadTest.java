package com.se.multithread;

import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/7/22 18:41
 */
public class ThreadTest extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i);
        }
    }

    public static void main(String[] args) {
        final ThreadTest t1 = new ThreadTest();
        final ThreadTest t2 = new ThreadTest();
        t1.start();
        t2.start();
    }
}
