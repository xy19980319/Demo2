package com.xiaoxiao.junit;

import static com.xiaoxiao.junit.Calculator.add;

/**
 * @author Xiaoyu
 * @date 2019/11/13 - 15:28
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        int result1 = c.add(1,2);
        int result2 = c.sub(2,1);
        System.out.println("result2 = " + result2);
    }

}
