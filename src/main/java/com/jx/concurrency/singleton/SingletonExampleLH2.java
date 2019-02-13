package com.jx.concurrency.singleton;


import com.jx.concurrency.annotation.NoRecommend;
import com.jx.concurrency.annotation.ThreadSafe;

/**
 *  懒汉模式
 *  单例实例  在第一次使用的时候创建
 *
 * 添加同步锁
 */
@ThreadSafe
@NoRecommend
public class SingletonExampleLH2 {
    /**
     * 私有的构造方法
     */
    private SingletonExampleLH2() {

    }

    //单例对象
    private static SingletonExampleLH2 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExampleLH2 getInstance(){
        if (instance ==null){
            instance = new SingletonExampleLH2();
        }
        return instance;
    }
}
