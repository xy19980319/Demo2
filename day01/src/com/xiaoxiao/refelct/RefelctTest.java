package com.xiaoxiao.refelct;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Xiaoyu
 * @date 2019/11/15 - 19:30
 */
public class RefelctTest {
    public static void main(String[] args) throws Exception {
        //创建一个反射的
        Properties properties = new Properties();
        ClassLoader classLoader = RefelctTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        Class clazz = Class.forName(className);
        Object o = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(o);
    }
}
