package com.jx.concurrency.synch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果 同一个线程 执行同一个方法，那么 将会 执行完毕一个 在执行下一个
 * 如果 两个线程 执行同一个 修饰方法  那么将会交叉开始
 */
@Slf4j
public class syncExampleOne {

    //修饰代码块
    public void test1(int i){
        synchronized (this){
            for (int j = 0; j < 5; j++) {
                log.info("test1 : {} ,{}" , j,i);
            }
        }
    }

    //修饰方法
    public synchronized void test2(int i){
        for (int j = 0; j < 5; j++) {
            log.info("test2 : {} ,{}" , j,i);
        }
    }

    //修饰一个类
    public void test3(int i){
        synchronized (syncExampleOne.class){
            for (int j = 0; j < 5; j++) {
                log.info("test3 : {} ,{}" , j,i);
            }
        }
    }

    //修饰一个静态类
    public static synchronized void test4(int i){
        for (int j = 0; j < 5; j++) {
            log.info("test4 : {} ,{}" , j,i);
        }
    }

    public static void main(String[] args) {
        syncExampleOne example1 = new syncExampleOne();
        syncExampleOne example2 = new syncExampleOne();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()-> {
            example1.test1(1);
        });
        service.execute(()-> {
            example2.test1(2);
        });
    }

}
