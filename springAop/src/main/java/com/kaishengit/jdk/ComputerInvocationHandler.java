package com.kaishengit.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */
public class ComputerInvocationHandler implements InvocationHandler{

    private Object target;

    public ComputerInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before------");
        Object result = method.invoke(target, args);
        System.out.println("after-------");
        return result;
    }
}
