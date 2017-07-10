package com.kaishengit.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by linfeiya on 2017/7/10 0010.
 */
public class MyMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("mouse---");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("mouse ");
        return result;
    }
}
