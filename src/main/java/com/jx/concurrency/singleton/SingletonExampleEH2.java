package com.jx.concurrency.singleton;


import com.jx.concurrency.annotation.ThreadSafe;

/**
 *  饿汉模式
 *  单例实例  在类装载的时候创建
 *
 */
@ThreadSafe
public class SingletonExampleEH2 {
    /**
     * 私有的构造方法
     */
    private SingletonExampleEH2() {

    }

    //单例对象
    private static SingletonExampleEH2 instance = null;

    static {
        instance = new SingletonExampleEH2();
    }
    //静态的工厂方法
    public static SingletonExampleEH2 getInstance(){

        return instance;
    }
}
