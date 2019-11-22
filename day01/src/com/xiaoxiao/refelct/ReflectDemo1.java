package com.xiaoxiao.refelct;

import com.xiaoxiao.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Xiaoyu
 * @date 2019/11/15 - 10:22
 * 1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
 * * 多用于配置文件，将类名定义在配置文件中。读取文件，加载类
 * 2. 类名.class：通过类名的属性class获取
 * * 多用于参数的传递
 * 3. 对象.getClass()：getClass()方法在Object类中定义着。
 * * 多用于对象的获取字节码的方式
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        Class cls1 = Class.forName("com.xiaoxiao.domain.Person");
        System.out.println(cls1);
        Class cls2 = Person.class;
        System.out.println(cls2);
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);
        //用==去比较
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        System.out.println("---------------------");
        Person p1 = new Person();
        Class clazz = p1.getClass();
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-----------");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        Object value = name.get(p1);
        name.set(p1,"张三");
        System.out.println(value);
        System.out.println(p1.toString());
        System.out.println("--------------");

        Constructor constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Object o = constructor.newInstance("张三", 23);
        System.out.println(o);
        System.out .println("-------------");
        Object o1 = clazz.newInstance();
        System.out.println(o1);
        System.out.println("----------------------------");


        Class personclass = Person.class;
        Method eat_method = personclass.getMethod("eat");
        Person p11 = new Person();
        eat_method.invoke(p11);
        Method eat_method1 = personclass.getMethod("eat",String.class,int.class);
        eat_method1.invoke(p11,"李四",24);
        System.out.println("-------------");




    }
}
