package com.jx.concurrency.singleton;


import com.jx.concurrency.annotation.NoRecommend;
import com.jx.concurrency.annotation.NoThreadSafe;
import com.jx.concurrency.annotation.ThreadSafe;

/**
 *  懒汉模式
 *  单例实例  在第一次使用的时候创建
 *
 *  volatile + 双重检测机制 -> 禁止指令重排
 */
@ThreadSafe
public class SingletonExampleLH4 {
    /**
     * 私有的构造方法
     */
    private SingletonExampleLH4() {

    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存


    //单例对象
    private volatile static SingletonExampleLH4 instance = null;

    //静态的工厂方法
    public static SingletonExampleLH4 getInstance(){
        if (instance ==null){
            synchronized (SingletonExampleLH4.class){
             if (instance==null){
                 instance = new SingletonExampleLH4();
             }
            }
        }
        return instance;
    }
}
