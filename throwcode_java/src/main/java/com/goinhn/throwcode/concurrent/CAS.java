package com.goinhn.throwcode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author goinhn
 * @version 1.0.0
 * @date 2020/7/28 22:24
 */
public class CAS {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        i.incrementAndGet();
        System.out.println(i);



    }

}