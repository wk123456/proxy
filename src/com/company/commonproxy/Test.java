package com.company.commonproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Person person = new Student();
        InvocationHandler handler = new MyHandler(person);
        Person s = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, handler);
        s.say();
        System.out.println("程序结束");

    }
}
