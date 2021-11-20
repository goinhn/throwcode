package com.goinhn.concurrent;


import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @version 1.0.0
 * @date 2020/8/1 18:30
 */
public class Timer implements Runnable {


    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        while (true) {
            System.out.println(now);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            now = now.plusSeconds(1);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Timer());
        thread.start();
    }
}
