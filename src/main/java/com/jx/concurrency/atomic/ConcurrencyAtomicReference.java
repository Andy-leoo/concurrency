package com.jx.concurrency.atomic;

import com.jx.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class ConcurrencyAtomicReference {

    private static AtomicReference<Integer> count = new AtomicReference<>(1);

    /**
     *  上面初始值 是 1 到
     *  第一步 第二部 expect 为 0  pass
     *  第三部 1  改为 3
     *  第五步  改为5
     *  最后打印 出来 5
     * @param args
     */
    public static void main(String[] args) {
        count.compareAndSet(0, 2); // 2
        count.compareAndSet(0, 1); // no
        count.compareAndSet(1, 3); // no
        count.compareAndSet(2, 4); // 4
        count.compareAndSet(3, 5); // no
        System.out.println(("count:"+ count.get()));
    }
}
