package com.jx.concurrency.atomic;

import com.jx.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class ConcurrencyAtomicFieldUpdater {

    private static AtomicIntegerFieldUpdater<ConcurrencyAtomicFieldUpdater> updater
            = AtomicIntegerFieldUpdater.newUpdater(ConcurrencyAtomicFieldUpdater.class,"count");

    @Getter
    private volatile int count = 100;

    public static void main(String[] args) {

        ConcurrencyAtomicFieldUpdater atomicFieldUpdater = new ConcurrencyAtomicFieldUpdater();

        if (updater.compareAndSet(atomicFieldUpdater,100,120)) {
            System.out.println("count 1:" +atomicFieldUpdater.getCount());
        }

        if (updater.compareAndSet(atomicFieldUpdater,100,120)) {
            System.out.println("count 2:" +atomicFieldUpdater.getCount());
        }else {
            System.out.println("count 3:" +atomicFieldUpdater.getCount());
            log.info("count :{}",atomicFieldUpdater.getCount());
        }
    }
}
