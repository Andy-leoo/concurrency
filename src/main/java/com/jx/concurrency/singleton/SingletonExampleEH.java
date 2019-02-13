package com.jx.concurrency.singleton;


import com.jx.concurrency.annotation.ThreadSafe;

/**
 *  饿汉模式
 *  单例实例  在类装载的时候创建
 *
 *  如果 没有实际的调用就会造成资源浪费
 */
@ThreadSafe
public class SingletonExampleEH {
    /**
     * 私有的构造方法
     */
    private SingletonExampleEH() {

    }

    //单例对象
    private static SingletonExampleEH instance = new SingletonExampleEH();

    //静态的工厂方法
    public static SingletonExampleEH getInstance(){

        return instance;
    }
}
