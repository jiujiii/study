package com.se.multithread;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/7/22 18:56
 */
public class ThreadTestRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+"\t"+i);
        }
    }

    public static void main(String[] args) {
        final Thread t1 = new Thread(new ThreadTestRunnable());
        final Thread t2 = new Thread(new ThreadTestRunnable());
        t1.start();
        t2.start();
    }
}
