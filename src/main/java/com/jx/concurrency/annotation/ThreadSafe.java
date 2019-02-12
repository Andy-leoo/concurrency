package com.jx.concurrency.annotation;

import java.lang.annotation.*;


/**
 * 用来标记{线程安全}的类或者写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {

    String value() default "";
}
