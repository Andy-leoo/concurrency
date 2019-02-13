package com.jx.concurrency.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
       //线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            service.execute(new Runnable() {
//                @Override
//                public void run() {
//                    log.info("tesk : {}",index);
//                }
//            });
//        }

//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.info("schedule run");
//            }
//        },3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();

//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                log.info("schedule run");
//            }
//        },2,2,TimeUnit.SECONDS  );

        //类似 定时
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("timer run");
            }
        },new Date(),2000);
    }

}
