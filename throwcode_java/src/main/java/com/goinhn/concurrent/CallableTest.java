package com.goinhn.concurrent;

import java.util.concurrent.*;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @version 1.0.0
 * @date 2020/8/1 18:18
 */
public class CallableTest implements Callable<Boolean> {


    @Override
    public Boolean call() throws Exception {
        int count = 1000;
        while(count > 0) {
            System.out.println(Thread.currentThread().getName() + count);
            count--;
        }

        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Boolean> future = executorService.submit(callableTest);

        System.out.println(future.get());
        executorService.shutdown();
    }
}
