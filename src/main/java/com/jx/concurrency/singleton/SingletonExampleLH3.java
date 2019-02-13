package com.jx.concurrency.singleton;


import com.jx.concurrency.annotation.NoRecommend;
import com.jx.concurrency.annotation.ThreadSafe;

/**
 *  懒汉模式
 *  单例实例  在第一次使用的时候创建
 *
 * 双重同步锁单例模式
 */
@ThreadSafe
@NoRecommend
public class SingletonExampleLH3 {
    /**
     * 私有的构造方法
     */
    private SingletonExampleLH3() {

    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化，发生了指令重排

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象

    //单例对象
    private static SingletonExampleLH3 instance = null;

    //静态的工厂方法
    public static SingletonExampleLH3 getInstance(){
        if (instance ==null){
            synchronized (SingletonExampleLH3.class){
             if (instance==null){
                 instance = new SingletonExampleLH3();
             }
            }
        }
        return instance;
    }
}
