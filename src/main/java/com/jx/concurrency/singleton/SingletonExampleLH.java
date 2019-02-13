package com.jx.concurrency.singleton;


import com.jx.concurrency.annotation.NoThreadSafe;

/**
 *  懒汉模式
 *  单例实例  在第一次使用的时候创建
 *
 *  在单线程中 ，没问题
 *  但是在多线程中 会造成性能问题
 */
@NoThreadSafe
public class SingletonExampleLH {
    /**
     * 私有的构造方法
     */
    private SingletonExampleLH() {

    }

    //单例对象
    private static SingletonExampleLH instance = null;

    //静态的工厂方法
    public static SingletonExampleLH getInstance(){
        if (instance ==null){
            instance = new SingletonExampleLH();
        }
        return instance;
    }
}
