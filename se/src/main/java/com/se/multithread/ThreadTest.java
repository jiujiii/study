package com.se.multithread;

import com.Node;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/7/22 18:41
 */
public class ThreadTest extends Thread {

    ThreadLocal<Node> tln = new ThreadLocal<>();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i);
            tln.set(new Node(1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadTest t1 = new ThreadTest();
        final ThreadTest t2 = new ThreadTest();
        t1.start();
        t2.start();
        t1.join();
        long d = 2;
        float a = 2.0f;
    }
}
