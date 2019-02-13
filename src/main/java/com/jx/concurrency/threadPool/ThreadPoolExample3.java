package com.jx.concurrency.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample3 {

    public static void main(String[] args) {
       //线程池
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("tesk : {}",index);
                }
            });
        }
        service.shutdown();
    }
}
