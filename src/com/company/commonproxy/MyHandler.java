package com.company.commonproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    private Object object;
    MyHandler(Object object){
        this.object = object;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("举手发言");
        method.invoke(object,args);
        System.out.println("坐下");
        return null;
    }
}
