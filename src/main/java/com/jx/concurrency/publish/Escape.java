package com.jx.concurrency.publish;

import com.jx.concurrency.annotation.NoRecommend;
import com.jx.concurrency.annotation.NoThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 对象溢出  一种错误的发布  当一个对象还没有构造完成   就使得他被其他线程所见
 */
@Slf4j
@NoThreadSafe
@NoRecommend
public class Escape {


}
