package com.jx.concurrency.singleton;


import com.jx.concurrency.annotation.Recommend;
import com.jx.concurrency.annotation.ThreadSafe;

/**
 *  枚举模式： 最安全
 */
@ThreadSafe
@Recommend
public class SingletonExampleEnum {
    /**
     * 私有的构造方法
     */
    private SingletonExampleEnum() {

    }

    //静态的工厂方法
    public static SingletonExampleEnum getInstance(){

        return Singleton.INSTANCE.getInstance();
    }

    public enum Singleton{
        INSTANCE;

        private SingletonExampleEnum singletonExampleEnum;

        //jvm 保证 这个方法绝对只调用一次
        Singleton(){
            singletonExampleEnum = new SingletonExampleEnum();
        }

        public SingletonExampleEnum getInstance(){
            return singletonExampleEnum;
        }
    }
}
