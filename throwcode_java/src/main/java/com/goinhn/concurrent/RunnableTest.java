package com.goinhn.concurrent;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @version 1.0.0
 * @date 2020/8/1 18:15
 */
public class RunnableTest implements Runnable{

    @Override
    public void run() {
        int count = 1000;
        while(count > 0) {
            System.out.println(Thread.currentThread().getName() + count);
            count--;
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
    }
}
