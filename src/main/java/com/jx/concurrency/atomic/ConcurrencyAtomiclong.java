package com.jx.concurrency.atomic;

import com.jx.concurrency.annotation.NoThreadSafe;
import com.jx.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@ThreadSafe
public class ConcurrencyAtomiclong {


    //请求总数
    public static int clientTotal = 5000;
    //线程总数
    public static int threadCount = 200;

    public static AtomicLong count  = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("error"+e.getMessage());
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        service.shutdown();
        System.out.println("count  : "+count);
    }

    private static void add() {
        count.incrementAndGet();
    }
}
