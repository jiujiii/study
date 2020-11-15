package com.se.multithread;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/25 15:05
 */
public class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService es = Executors.newCachedThreadPool();
        Future<Integer> result = es.submit(() -> {
            Thread.sleep(1000);
            return 2;
        });
        System.out.println(result.get());
    }
}
