package com.xiaoxiao.domain;

/**
 * @author Xiaoyu
 * @date 2019/11/15 - 10:22
 */
public class Person {
    private String name;
    private int age;
    public String a;
    public String b;
    public String c;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void eat() {
        System.out.println("人要吃饭");
    }
    public void eat(String name, int age) {

        System.out.println(name + "正在吃饭,他已经" + age + "岁了");
    }
}
