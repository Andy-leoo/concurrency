package com.jx.concurrency;

import com.jx.concurrency.annotation.NoThreadSafe;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
@NoThreadSafe
public class ConcurrencyTest {


    //请求总数
    public static int clientTotal = 5000;
    //线程总数
    public static int threadCount = 200;

    public static int count  = 0;

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
        count++;
    }
}
