package com.xiaoxiao.test;

import com.xiaoxiao.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Xiaoyu
 * @date 2019/11/13 - 15:55
 */
public class Calculator1 {
    /*
    * 测试计算
    * */
    @Before
    public void init() {
        System.out.println("init....");
    }
    @After
    public void close() {
        System.out.println("close...");
    }
    @Test
    public void testAdd() {
          Calculator c = new Calculator();
          int result1 = c.add(1,2);
        System.out.println("add....");
        Assert.assertEquals(2,result1);


    }
    @Test
    public void testSub() {
        Calculator c = new Calculator();
        int result2 = c.sub(3,1);
        Assert.assertEquals(2, result2);
        System.out.println("sub.....");
    }
}
