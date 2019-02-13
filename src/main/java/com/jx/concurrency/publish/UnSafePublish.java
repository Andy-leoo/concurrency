package com.jx.concurrency.publish;

import com.jx.concurrency.annotation.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 发布   使一个对象能够被当前范围之外的代码所使用
 */
@Slf4j
@NoThreadSafe
public class UnSafePublish {

    private String[] states = {"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("{}", Arrays.toString(unSafePublish.getStates()));

        unSafePublish.getStates()[0]="J";
        log.info("{}", Arrays.toString(unSafePublish.getStates()));

    }
}
